package com.blackcat.pull;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

/**
 * @Title 拉取武将信息详情
 * @Description
 * @author zhanghui
 * @date 2020年12月24日 13:27
 * @version V1.0
 * @see
 * @since V1.0
 */

public class PullGeneralData {

	/*public static void main(String[] args) throws IOException {
		String url = "https://sgz.ejoy.com/station/ajax/350659087930767364/detail-354732128524580868";
		Document doc = Jsoup.connect(url).get();
		System.out.println(doc);
		Elements names = doc.getElementsByClass("detail-title");
		Element name = names.get(0);
		System.out.println("英雄名称："+name.text());
		Elements resultLinks = doc.select("div > img");
		System.out.println("英雄图片路径："+resultLinks.get(0).attr("src"));
		System.out.print("兵种适性: ");
		Elements armS = doc.select(".synopsis4 > li");
		for (Element element : armS) {
//			System.out.print(element.child(0));// 图
			System.out.print(element.child(1).text()+"  "+element.child(2).text()+"；");
		}
		System.out.println();
		System.out.println("自带战法:");
		Elements title= doc.getElementsByClass("li-title padding-deal");
		System.out.println("名称："+title.get(0).text());
		Elements common= doc.getElementsByClass("li-common border-deal");
		System.out.println("描述："+common.get(0).text());
		System.out.println("拆解战法:");
		Elements title1= doc.getElementsByClass("li-title padding-deal");
		System.out.println("名称："+title1.get(1).text());
		Elements common1= doc.getElementsByClass("li-common border-deal");
		System.out.println("描述："+common1.get(1).text());

		Elements text= doc.getElementsByClass("text");
		System.out.println("列传:"+text.get(0).text());
	}*/

	/*public static void main(String[] args) throws IOException {
		String url = "https://sgz.ejoy.com/station/ajax/350659307657771017/categoryId-undefined/";

		for (int i = 1; i < 11; i++) {
			Document doc = Jsoup.connect(url+i).get();
			Elements tactics= doc.getElementsByAttributeValue("data-tbid","350659307657771017");
			for (Element tactic : tactics) {
				System.out.println(tactic.attr("data-rowid"));
			}
		}

	}*/

	/*public static void main(String[] args) throws IOException {
		String url = "https://sgz.ejoy.com/station/ajax/350659307657771017/detail-447081534368790536";
		Document doc = Jsoup.connect(url).get();
//		System.out.println(doc);
		Elements names = doc.getElementsByClass("detail-title");
		System.out.println("战法名称："+names.get(0).text());
		Elements resultLinks = doc.select("div > img");
		System.out.println("战法图片路径："+resultLinks.get(0).attr("src"));
		Elements detailList = doc.select(".detail-list > li");
		System.out.println("战法类型："+detailList.get(0).text().replace("战法类型：", ""));
		System.out.println("战法品质："+detailList.get(1).text().replace("战法品质：", ""));
		System.out.println("战法来源："+detailList.get(2).text().replace("战法来源：", ""));
		System.out.println("来源武将："+detailList.get(3).text().replace("来源武将：", ""));
		System.out.println("兵种限制："+detailList.get(4).text().replace("兵种限制:", ""));
		System.out.println("战法目标："+detailList.get(5).text().replace("战法目标:", ""));
		Elements text= doc.getElementsByClass("text");
		System.out.println("战法描述："+text.get(0).text());
	}*/

	/*public static void main(String[] args) throws IOException {
		String url = "https://sgz.ejoy.com/station/ajax/350659087930767364/categoryId-undefined/";

		for (int i = 1; i < 6; i++) {
			Document doc = Jsoup.connect(url+i).get();
			System.out.println(doc);
			Elements tactics= doc.getElementsByAttributeValue("data-tbid","350659087930767364");
			for (Element tactic : tactics) {
//				System.out.println(tactic.attr("data-rowid"));
			}
		}
	}*/

	/*public static void main(String[] args) throws IOException {

		String id = "350659087930767364";
//		String id2 = "350958444412418059";
//		String id2 = "350958444412418058";
//		String id2 = "350958444412418057";
//		String id2 = "350958444412418056";
		String id2 = "350958444412418055";
		int page = 1;
		String url = "https://sgz.ejoy.com/station/ajax/"+id+"/categoryId-"+id2+"/"+page;
		Document doc = Jsoup.connect(url).get();
		Elements tactics= doc.getElementsByAttributeValue("data-tbid",id);
		StringBuilder str = new StringBuilder();
		for (Element tactic : tactics) {
			str.append("'");
			str.append(tactic.attr("data-prival"));
			str.append("',");
		}
		System.out.println(str.toString());
	}*/


	public static void main(String[] args) throws IOException {
		String url = "https://community.lingxigames.com/m/ajax/strategy/s1/194/";
		for (int i = 1; i < 16; i++) {
//			Document doc = Jsoup.connect(url+1).get();
			Document doc = Jsoup.connect(url+i).get();
			Elements lis= doc.getElementsByTag("li");
			if(lis.size()>0){
				for (Element li : lis) {
					if(li.select("div[class=\"title\"]").text().indexOf("阵容安利")!=-1){
						String detailUrl = "https://community.lingxigames.com"+li.getElementsByTag("a").attr("href");
						System.out.println(detailUrl);
					}
				}
			}
		}
	}

	/*public static void main(String[] args) throws IOException {
		String url = "https://community.lingxigames.com/m/s1/strategy";
		Document doc = Jsoup.connect(url).get();
		System.out.println(doc);
	}*/
}
