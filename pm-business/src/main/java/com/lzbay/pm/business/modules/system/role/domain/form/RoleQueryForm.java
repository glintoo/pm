package com.lzbay.pm.business.modules.system.role.domain.form;

import com.lzbay.pm.base.common.domain.PageParam;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 角色 查询
 *
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class RoleQueryForm extends PageParam {

    @Schema(description = "角色名称")
    private String roleName;

    @Schema(description = "角色id")
    private String roleId;
}
