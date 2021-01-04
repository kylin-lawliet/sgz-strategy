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
 *     阵容信息
 * </p>
 *
 * @author blackcat
 * @since 2020-12-29
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Lineup extends Model<Lineup> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 主武将编号
     */
    private Integer masterId;

    /**
     * 副将1武将编号
     */
    private Integer assistantOneId;

    /**
     * 副将2武将编号
     */
    private Integer assistantTwoId;

    /**
     * 提供阵容信息的游戏玩家名称
     */
    private String gamers;

    /**
     * 供阵容信息链接
     */
    private String url;

    /**
     * 贴吧楼层
     */
    private String floor;

    /**
     * 阵容补充
     */
    private String supplement;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
