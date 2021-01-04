package com.blackcat.vo;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Title 阵容匹配结果集
 * @Description
 * @author zhanghui
 * @date 2020年12月31日 10:46
 * @version V1.0
 * @see
 * @since V1.0
 */
@Data
@NoArgsConstructor
public class LineupResult {

	private String masterName;
	private String masterTactics;
	private String assistantOneName;
	private String assistantOneTactics;
	private String assistantTwoName;
	private String assistantTwoTactics;
	private String addInfo;
	private String supplement;
}
