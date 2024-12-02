package com.lzbay.pm.business.modules.system.menu.domain.form;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 菜单 添加表单
 *
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class MenuAddForm extends MenuBaseForm {

    @Schema(hidden = true)
    private Long createUserId;
}
