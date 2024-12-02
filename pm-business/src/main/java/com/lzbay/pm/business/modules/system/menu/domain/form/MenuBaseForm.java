package com.lzbay.pm.business.modules.system.menu.domain.form;

import com.lzbay.pm.base.common.enums.CheckEnum;
import com.lzbay.pm.base.common.enums.SchemaEnum;
import com.lzbay.pm.business.modules.system.menu.constant.MenuPermsTypeEnum;
import com.lzbay.pm.business.modules.system.menu.constant.MenuTypeEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

/**
 * 菜单基础
 *
 */
@Data
public class MenuBaseForm {

    @Schema(description = "菜单名称")
    @NotBlank(message = "菜单名称不能为空")
    @Length(max = 30, message = "菜单名称最多30个字符")
    private String menuName;

    @SchemaEnum(value = MenuTypeEnum.class, desc = "类型")
    @CheckEnum(value = MenuTypeEnum.class, message = "类型错误")
    private Integer menuType;

    @Schema(description = "父菜单ID 无上级可传0")
    @NotNull(message = "父菜单ID不能为空")
    private Long parentId;

    @Schema(description = "显示顺序")
    private Integer sort;

    @Schema(description = "路由地址")
    private String path;

    @Schema(description = "组件路径")
    private String component;

    @Schema(description = "是否为外链")
    @NotNull(message = "是否为外链不能为空")
    private Boolean frameFlag;

    @Schema(description = "外链地址")
    private String frameUrl;

    @Schema(description = "是否缓存")
    @NotNull(message = "是否缓存不能为空")
    private Boolean cacheFlag;

    @Schema(description = "显示状态")
    @NotNull(message = "显示状态不能为空")
    private Boolean visibleFlag;

    @Schema(description = "禁用状态")
    @NotNull(message = "禁用状态不能为空")
    private Boolean disabledFlag;

    @SchemaEnum(value = MenuPermsTypeEnum.class, desc = "权限类型 ")
    @CheckEnum(value = MenuPermsTypeEnum.class, message = "权限类型")
    private Integer permsType;

    @Schema(description = "前端权限字符串")
    private String webPerms;

    @Schema(description = "后端端权限字符串")
    private String apiPerms;

    @Schema(description = "菜单图标")
    private String icon;

    @Schema(description = "功能点关联菜单ID")
    private Long contextMenuId;
}