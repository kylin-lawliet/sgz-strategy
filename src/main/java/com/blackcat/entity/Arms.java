package com.blackcat.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 武将兵种适应
 * </p>
 *
 * @author blackcat
 * @since 2020-12-24
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Arms extends Model<Arms> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 武将编号
     */
    private Integer generalId;

    /**
     * 兵种：1-骑兵；2-盾兵；3-弓兵；4-枪兵；5-器械
     */
    private Integer arms;

    /**
     * 适应级别
     */
    private String level;


    public Arms(Integer arms,String level) {
        this.arms = arms;
        this.level = level;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
