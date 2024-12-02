package com.lzbay.pm.base.modules.dict.domain.form;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 字典
 *
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class DictKeyUpdateForm extends DictKeyAddForm {

    @Schema(description = "keyId")
    @NotNull(message = "keyId不能为空")
    private Long dictKeyId;
}