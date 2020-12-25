package com.blackcat.dao;

import com.blackcat.entity.Tactics;
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
public interface TacticsMapper extends BaseMapper<Tactics> {

	@Delete("delete from tactics")
	void deleteAll();
}
