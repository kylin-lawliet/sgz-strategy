package com.blackcat.vo;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Title 用户信息结果集
 * @Description
 * @author zhanghui
 * @date 2020年12月31日 11:18
 * @version V1.0
 * @see
 * @since V1.0
 */
@Data
@NoArgsConstructor
public class UserResult {

	private String usernane;
	private Integer generalCount;
	private Integer teamCount;
	private Integer fiveCount;
	private Integer fourCount;
	private Integer threeCount;

}
