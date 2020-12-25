package com.blackcat.service.impl;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.blackcat.dao.ArmsMapper;
import com.blackcat.dao.GeneralMapper;
import com.blackcat.dao.TacticsMapper;
import com.blackcat.entity.Arms;
import com.blackcat.entity.General;
import com.blackcat.entity.Tactics;
import com.blackcat.service.PullDataService;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Title
 * @Description
 * @author zhanghui
 * @date 2020年12月24日 15:22
 * @version V1.0
 * @see
 * @since V1.0
 */
@Service
public class PullDataServiceImpl implements PullDataService {

	@Autowired
	private TacticsMapper tacticsMapper;
	@Autowired
	private GeneralMapper generalMapper;
	@Autowired
	private ArmsMapper armsMapper;

	private static String TacticsId = "350659307657771017";
	private static String TacticsListUrl = "https://sgz.ejoy.com/station/ajax/"+TacticsId+"/categoryId-undefined/";
	private static int TacticsPageSize = 9;
	private static String GeneralsId = "350659087930767364";
	private static String GeneralsListUrl = "https://sgz.ejoy.com/station/ajax/"+GeneralsId+"/categoryId-undefined/";
	private static int GeneralsPageSize = 5;

	Map<String,Integer> tacticsMap = new HashMap();
	Map<String,Integer> generalMap = new HashMap();

	@Override
	public String pullData() throws IOException {
		pullTacticss();
		pullGenerals();
		return "ok";
	}

	private List<General> pullGenerals() throws IOException {
//		List<General> list = new ArrayList<>();
		generalMapper.deleteAll();
		armsMapper.deleteAll();
		int j = 0;
		for (int i = 1; i < GeneralsPageSize+1; i++) {
			Document doc = Jsoup.connect(GeneralsListUrl+i).get();
			Elements generals= doc.getElementsByAttributeValue("data-tbid",GeneralsId);
			System.out.println("英雄页数："+i+" 条数："+generals.size());

			for (Element info : generals) {
				General general = getGeneral(info.attr("data-rowid"));
				generalMapper.insert(general);
				generalMap.put(general.getName(),general.getId());
				List<Arms> armsS = general.getArmsS();
				for (Arms Arms : armsS) {
					Arms.setGeneralId(general.getId());
					armsMapper.insert(Arms);
				}
				System.out.println("j=="+j);
				j++;
//				list.add(general);
			}
		}
		return null;
//		return list;
	}

	private General getGeneral(String id) throws IOException {
		String url = "https://sgz.ejoy.com/station/ajax/" + GeneralsId + "/detail-" + id;
		Document doc = Jsoup.connect(url).get();
		General general = new General();
		Elements name = doc.getElementsByClass("detail-title");
		general.setName(name.get(0).text());
		Elements resultLinks = doc.select("div > img");
		general.setImgUrl(resultLinks.get(0).attr("src"));
		List<Arms> armsS = new ArrayList<>();
		Elements armS = doc.select(".synopsis4 > li");
		for (Element element : armS) {
			Arms arms = new Arms(getArmValue(element.child(1).text()),element.child(2).text());
			armsS.add(arms);
		}
		general.setArmsS(armsS);
		Elements title= doc.getElementsByClass("li-title padding-deal");
		general.setByoTactics(tacticsMap.get(title.get(0).text()));
		Elements title1= doc.getElementsByClass("li-title padding-deal");
		general.setInheritTactics(tacticsMap.get(title1.get(1).text()));
		Elements text= doc.getElementsByClass("text");
		general.setBiographies(text.get(0).text());
		return general;
	}

	private List<Tactics> pullTacticss() throws IOException {
//		List<Tactics> list = new ArrayList<>();
		tacticsMapper.deleteAll();
		// 查询所有战法信息
		for (int i = 1; i < TacticsPageSize+1; i++) {
			Document doc = Jsoup.connect(TacticsListUrl+i).get();
			Elements tacticss= doc.getElementsByAttributeValue("data-tbid",TacticsId);
			System.out.println("战法页数："+i+" 条数："+tacticss.size());
			// 查询每页中的战法id
			for (Element info : tacticss) {
				Tactics tactics = getTactics(info.attr("data-rowid"));
				tacticsMapper.insert(tactics);
				tacticsMap.put(tactics.getName(),tactics.getId());
//				list.add(tactics);
			}
		}
		return null;
//		return list;
	}

	private Tactics getTactics(String id) throws IOException {
		String url = "https://sgz.ejoy.com/station/ajax/"+TacticsId+"/detail-"+id;
		Document doc = Jsoup.connect(url).get();

		Tactics tactics = new Tactics();
		Elements names = doc.getElementsByClass("detail-title");
		tactics.setName(names.get(0).text());

		Elements resultLinks = doc.select("div > img");
		tactics.setImgUrl(resultLinks.get(0).attr("src"));
		Elements detailList = doc.select(".detail-list > li");
		tactics.setType(detailList.get(0).text().replace("战法类型：", ""));
		tactics.setQuality(detailList.get(1).text().replace("战法品质：", ""));
		String source = detailList.get(2).text().replace("战法来源：", "");
		tactics.setSource(source.equals("传承战法")?2:1);
		tactics.setSourceGeneral(detailList.get(3).text().replace("来源武将：", ""));
		String[] arms = detailList.get(4).text().replace("兵种限制:", "").split("、");
		StringBuilder limitStr = new StringBuilder();
		for (int i = 0; i < arms.length; i++) {
			limitStr.append(","+getArmValue(arms[i]));
		}
		tactics.setSuit(limitStr.toString().replaceFirst(",",""));
		tactics.setTarget(detailList.get(5).text().replace("战法目标:", ""));
		Elements text= doc.getElementsByClass("text");
		tactics.setTacticsDescribe(text.get(0).text());
//		System.out.println(text.get(0).text());
		return tactics;
	}

	private Integer getArmValue(String name){
		if("骑兵".equals(name)){
			return 1;
		}else if("弓兵".equals(name)){
			return 2;
		}else if("枪兵".equals(name)){
			return 3;
		}else if("盾兵".equals(name)){
			return 4;
		}else{
			return 5;
		}
	}

}
