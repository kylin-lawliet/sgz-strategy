package com.blackcat.service.impl;

import com.blackcat.common.Result;
import com.blackcat.service.BMAservice;
import com.blackcat.vo.UserResult;
import lombok.var;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Title 阵容匹配算法
 * @Description
 * @author zhanghui
 * @date 2020年12月31日 9:59
 * @version V1.0
 * @see
 * @since V1.0
 */
@Service
public class BMAserviceImpl implements BMAservice {

	@Override
	public Result getLineupBMA() {
		Map<String,Object> result = new HashMap(16);
		List lineupResultList = new ArrayList<>(16);
		UserResult userResult = new UserResult();
		result.put("userInfo", userResult);
		result.put("lineupInfo", lineupResultList);
		return null;
	}
}
