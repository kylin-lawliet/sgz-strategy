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
 *      阵容搭配武将战法
 * </p>
 *
 * @author blackcat
 * @since 2020-12-29
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class LineupGeneralTactics extends Model<LineupGeneralTactics> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 阵容编号
     */
    private Integer lineupId;

    /**
     * 武将编号
     */
    private Integer generalId;

    /**
     * 区分，同一阵容有不同战法匹配
     */
    private Integer type;

    /**
     * 战法信息
     */
    private String tacticsInfo;

    /**
     * 加点信息说明
     */
    private String addInfo;

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
