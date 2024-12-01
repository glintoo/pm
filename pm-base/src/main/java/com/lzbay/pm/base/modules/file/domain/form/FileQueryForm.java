package com.lzbay.pm.base.modules.file.domain.form;

import com.lzbay.pm.base.common.domain.PageParam;
import com.lzbay.pm.base.common.enums.CheckEnum;
import com.lzbay.pm.base.common.enums.FileFolderTypeEnum;
import com.lzbay.pm.base.common.enums.SchemaEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDate;

/**
 * 文件信息查询
 *
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class FileQueryForm extends PageParam {

    @SchemaEnum(value = FileFolderTypeEnum.class, desc = "文件夹类型")
    @CheckEnum(value = FileFolderTypeEnum.class, message = "文件夹类型 错误")
    private Integer folderType;

    @Schema(description = "文件名词")
    private String fileName;

    @Schema(description = "文件Key")
    private String fileKey;

    @Schema(description = "文件类型")
    private String fileType;

    @Schema(description = "创建人")
    private String creatorName;

    @Schema(description = "创建时间")
    private LocalDate createTimeBegin;

    @Schema(description = "创建时间")
    private LocalDate createTimeEnd;

}
