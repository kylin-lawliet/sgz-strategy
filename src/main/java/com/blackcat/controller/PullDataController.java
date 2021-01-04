package com.blackcat.controller;

import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import com.blackcat.service.PullDataService;
import com.blackcat.util.ExcelUtil;
import com.blackcat.vo.LineupExcelInfo;
import com.blackcat.vo.LineupGeneralTacticsExcelInfo;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Title 拉取数据
 * @Description
 * @author zhanghui
 * @date 2020年12月24日 15:18
 * @version V1.0
 * @see
 * @since V1.0
 */
@Controller
public class PullDataController {

	@Autowired
	private PullDataService pullDataService;

	/**
	 * <p> 描述 : 拉取官网英雄战法数据
	 * @author : blackcat
	 * @date  : 2020/12/29 14:22
	*/
	@GetMapping("pullData")
	@ResponseBody
	public String PullData() throws IOException {
		return pullDataService.pullData();
	}

	@PostMapping("importExcelSubmit")
	@ResponseBody
	public String importExcelSubmit(@RequestParam("file") MultipartFile file) throws Exception {
		// 根据file得到Workbook,主要是要根据这个对象获取,传过来的excel有几个sheet页
		Workbook workBook = ExcelUtil.getWorkBook(file);
		ImportParams params = new ImportParams();
		// 循环工作表Sheet
		for (int numSheet = 0; numSheet < workBook.getNumberOfSheets(); numSheet++) {
			// 表头在第几行
			params.setTitleRows(0);
			// 第几个sheet页
			params.setStartSheetIndex(numSheet);
			List<LineupExcelInfo> lineupList = new ArrayList<>();
			List<LineupGeneralTacticsExcelInfo> lineupGTList = new ArrayList<>();
			if(numSheet==0){// 阵容信息
				lineupList = ExcelImportUtil.importExcel(file.getInputStream(), LineupExcelInfo.class, params);
			}else if(numSheet==1){// 阵容武将战法信息
				lineupGTList = ExcelImportUtil.importExcel(file.getInputStream(), LineupGeneralTacticsExcelInfo.class, params);
			}
			pullDataService.saveLineupInfo(lineupList,lineupGTList);
		}
        return "ok";
	}

	@GetMapping("toImportExcel")
	public String toImportExcel(){
		return "excel";
	}

}
