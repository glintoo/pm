package com.lzbay.pm.business.modules.system.role.domain.form;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 角色更新修改
 *
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class RoleUpdateForm extends RoleAddForm {

    /**
     * 角色id
     */
    @Schema(description = "角色id")
    @NotNull(message = "角色id不能为空")
    protected Long roleId;


}