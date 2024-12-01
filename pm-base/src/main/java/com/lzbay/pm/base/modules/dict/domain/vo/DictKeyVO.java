package com.lzbay.pm.base.modules.dict.domain.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * 字典
 *
 */
@Data
public class DictKeyVO {

    @Schema(description = "dictKeyId")
    private Long dictKeyId;

    @Schema(description = "编码")
    private String keyCode;

    @Schema(description = "名称")
    private String keyName;

    @Schema(description = "备注")
    private String remark;
}