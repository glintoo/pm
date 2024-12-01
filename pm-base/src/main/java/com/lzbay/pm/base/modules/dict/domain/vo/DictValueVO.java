package com.lzbay.pm.base.modules.dict.domain.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * 字典
 *
 */
@Data
public class DictValueVO {

    @Schema(description = "valueId")
    private Long dictValueId;

    @Schema(description = "dictKeyId")
    private Long dictKeyId;

    @Schema(description = "编码")
    private String valueCode;

    @Schema(description = "名称")
    private String valueName;

    @Schema(description = "排序")
    private Integer sort;

    @Schema(description = "备注")
    private String remark;
}