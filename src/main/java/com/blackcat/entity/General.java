package com.blackcat.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 *  武将
 * </p>
 *
 * @author blackcat
 * @since 2020-12-24
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class General extends Model<General> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 武将名称
     */
    private String name;

    /**
     * 武将列传
     */
    private String biographies;

    /**
     * 统御值
     */
    private Integer reign;

    /**
     * 自带战法
     */
    private Integer byoTactics;

    /**
     * 传承战法
     */
    private Integer inheritTactics;

    /**
     * 武将图片路径
     */
    private String imgUrl;

    // 兵种适应数据
    @TableField(exist = false)
    List<Arms> armsS = new ArrayList<>();

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
