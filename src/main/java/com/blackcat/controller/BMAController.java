package com.blackcat.controller;

import com.blackcat.common.Result;
import com.blackcat.service.BMAservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @Title 匹配算法
 * @Description
 * @author zhanghui
 * @date 2020年12月31日 9:12
 * @version V1.0
 * @see
 * @since V1.0
 */
@Controller
public class BMAController {

	@Autowired
	private BMAservice bmAservice;

	/**
	 * <p> 描述 : 阵容匹配--小白版
	 * @author : blackcat
	 * @date  : 2020/12/31 9:56
	*/
	@GetMapping("toLineupBMA")
	public String toLineupBMA(){
		return "lineupBMA";
	}

	@GetMapping("lineupBMA")
	public Result lineupBMA(){
		return bmAservice.getLineupBMA();
	}
}
