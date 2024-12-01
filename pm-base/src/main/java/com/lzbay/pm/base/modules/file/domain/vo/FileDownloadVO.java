package com.lzbay.pm.base.modules.file.domain.vo;

import lombok.Data;

/**
 * 文件下载
 *
 */
@Data
public class FileDownloadVO {

    /**
     * 文件字节数据
     */
    private byte[] data;

    /**
     * 文件元数据
     */
    private FileMetadataVO metadata;


}
