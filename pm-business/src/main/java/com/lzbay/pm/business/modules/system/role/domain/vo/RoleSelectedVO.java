package com.lzbay.pm.business.modules.system.role.domain.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 选择角色
 *
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class RoleSelectedVO extends RoleVO {

    @Schema(description = "角色名称")
    private Boolean selected;
}
