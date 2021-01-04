package com.blackcat.vo;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelTarget;
import lombok.Data;

/**
 * @Title Excel整容信息
 * @Description
 * @author zhanghui
 * @date 2020年12月29日 13:54
 * @version V1.0
 * @see
 * @since V1.0
 */
@Data
@ExcelTarget("阵容")
public class LineupExcelInfo {

	@Excel(name="序号")
	private String id;
	@Excel(name="主武将名称")
	private String masterName;
	@Excel(name="副将1名称")
	private String assistantOne;
	@Excel(name="副将2名称")
	private String assistantTwo;
	@Excel(name="提供攻略玩家名称")
	private String gamers;
	@Excel(name="攻略链接")
	private String url;
	@Excel(name="贴吧楼层")
	private String floor;
	@Excel(name="补充说明")
	private String supplement;
}
