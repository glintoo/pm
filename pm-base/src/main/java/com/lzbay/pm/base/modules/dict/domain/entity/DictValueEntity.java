package com.lzbay.pm.base.modules.dict.domain.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * 字典
 *
 */
@Data
@TableName("t_dict_value")
public class DictValueEntity {

    @TableId(type = IdType.AUTO)
    private Long dictValueId;

    private Long dictKeyId;
    /**
     * 编码
     */
    private String valueCode;
    /**
     * 名称
     */
    private String valueName;
    /**
     * 备注
     */
    private String remark;

    /**
     * 排序
     */
    private Integer sort;
    /**
     * 删除标识
     */
    private Boolean deletedFlag;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;
}