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
 * 战法表
 * </p>
 *
 * @author blackcat
 * @since 2020-12-24
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Tactics extends Model<Tactics> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 兵法/战法名
     */
    private String name;

    /**
     * 战法品质
     */
    private String quality;

    /**
     * 战法类型
     */
    private String type;

    /**
     * 战法来源：1-自带战法；2-传承战法
     */
    private Integer source;

    /**
     * 兵种适用：
        1-骑兵、2-弓兵、3-枪兵、4-盾兵、5-器械
        多个逗号分隔
     */
    private String suit;

    /**
     * 目标
     */
    private String target;

    /**
     * 战法描述
     */
    private String tacticsDescribe;

    /**
     * 战法冲突
     */
    private Integer conflict;

    /**
     * 0-战法；1兵书
     */
    private Integer isTactics;

    /**
     * 战法图片路径
     */
    private String imgUrl;

    /**
     * 来源武将,拉取战法信息时存储
     */
    private String sourceGeneral;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
