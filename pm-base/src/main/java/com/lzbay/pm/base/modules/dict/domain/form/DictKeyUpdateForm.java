package com.lzbay.pm.base.modules.dict.domain.form;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

/**
 * 字典
 *
 */
@Data
public class DictKeyUpdateForm extends DictKeyAddForm {

    @Schema(description = "keyId")
    @NotNull(message = "keyId不能为空")
    private Long dictKeyId;
}