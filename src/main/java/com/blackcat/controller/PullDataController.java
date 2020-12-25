package com.blackcat.controller;

import com.blackcat.service.PullDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.IOException;

/**
 * @Title 拉取官网英雄战法数据
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

	@GetMapping("pullData")
	public String PullData() throws IOException {
		return pullDataService.pullData();
	}
}
