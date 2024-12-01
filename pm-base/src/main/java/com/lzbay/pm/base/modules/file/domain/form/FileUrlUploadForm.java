package com.lzbay.pm.base.modules.file.domain.form;

import com.lzbay.pm.base.common.enums.CheckEnum;
import com.lzbay.pm.base.common.enums.FileFolderTypeEnum;
import com.lzbay.pm.base.common.enums.SchemaEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

/**
 * url上传文件
 *
 */
@Data
public class FileUrlUploadForm {

    @SchemaEnum(value = FileFolderTypeEnum.class, desc = "业务类型")
    @CheckEnum(value = FileFolderTypeEnum.class, required = true, message = "业务类型错误")
    private Integer folder;

    @Schema(description = "文件url")
    @NotBlank(message = "文件url不能为空")
    private String fileUrl;

}
