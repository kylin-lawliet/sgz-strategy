package com.blackcat.dao;

import com.blackcat.entity.General;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author zhanghui
 * @since 2020-12-24
 */
@Mapper
public interface GeneralMapper extends BaseMapper<General> {

	@Delete("delete from general")
	void deleteAll();
}
