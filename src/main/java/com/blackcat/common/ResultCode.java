package com.blackcat.common;
/**
 * @Title 统一状态枚举
 * @Description
 * @author zhanghui
 * @date 2020年12月31日 9:49
 * @version V1.0
 * @see
 * @since V1.0
 */
public enum ResultCode {


	SUCCESS(200, "获取数据成功"),
//	NO_DATA(300, "查询无结果"),
//	NO_PARAMTER(301, "请求参数为空"),
	ERROR(500, "系统异常");

	private Integer code;
	private String message;

	ResultCode(Integer code, String message) {
		this.code = code;
		this.message = message;
	}

	public Integer code() {
		return this.code;
	}

	public String message() {
		return this.message;
	}
}
