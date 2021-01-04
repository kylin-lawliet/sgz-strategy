package com.blackcat.common;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Title 统一返回对象
 * @Description
 * @author zhanghui
 * @date 2020年12月31日 9:49
 * @version V1.0
 * @see
 * @since V1.0
 */
@Data
@NoArgsConstructor
public class Result<T> implements Serializable {

	/** 返回状态码 */
	private int code;

	/** 提示信息 */
	private String msg;

	/** 数据类型 */
	private T data;

	public Result(ResultCode resultCode) {
		this.code = resultCode.code();
		this.msg = resultCode.message();
	}

	public Result(ResultCode resultCode,T data) {
		this(resultCode);
		this.data = data;
	}

	/** 快速创建成功结果 */
	public static final Result SUCCESS = new Result(ResultCode.SUCCESS);
	/** 快速创建成功结果并返回结果数据 */
	public static Result SUCCESS(Object data) {
		return new Result(ResultCode.SUCCESS,data);
	}
	/** 快速创建失败结果(返回 500：系统异常) */
	public static final Result FAIL = new Result(ResultCode.ERROR);
	/** 快速创建失败结果并返回结果数据(返回 500：系统异常) */
	public static Result FAIL(Object data) {
		return new Result(ResultCode.ERROR,data);
	}
	/** 返回结果 */
	public static Result result(ResultCode resultCode,Object data){
		return new Result(resultCode,data);
	}

}
