package com.lzbay.pm.base.modules.config.domain.form;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

/**
 * 配置更新表单
 *
 */
@Data
public class ConfigUpdateForm extends ConfigAddForm {

    @Schema(description = "configId")
    @NotNull(message = "configId不能为空")
    private Long configId;
}
