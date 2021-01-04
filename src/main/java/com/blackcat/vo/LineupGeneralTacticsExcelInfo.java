package com.blackcat.vo;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelTarget;
import lombok.Data;

/**
 * @Title 阵容武将战法配置
 * @Description
 * @author zhanghui
 * @date 2020年12月30日 11:21
 * @version V1.0
 * @see
 * @since V1.0
 */
@Data
@ExcelTarget("战法")
public class LineupGeneralTacticsExcelInfo {

	@Excel(name="武将")
	private String generalName;
	@Excel(name="战法")
	private String tacticsName;
	@Excel(name="加点")
	private String addInfo;
	@Excel(name="队伍")
	private String lineupNo;
	@Excel(name="区分")
	private Integer type;
}
