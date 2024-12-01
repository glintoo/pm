package com.lzbay.pm.base.modules.dict.domain.form;

import com.lzbay.pm.base.common.domain.PageParam;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 字典
 *
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class DictKeyQueryForm extends PageParam {

    @Schema(description = "搜索词")
    private String searchWord;

    @Schema(description = "删除标识",hidden = true)
    private Boolean deletedFlag;
}