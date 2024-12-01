package com.lzbay.pm.base.modules.file.service;

import cn.hutool.core.util.StrUtil;
import com.lzbay.pm.base.common.domain.ResponseDTO;
import com.lzbay.pm.base.modules.file.domain.vo.FileDownloadVO;
import com.lzbay.pm.base.modules.file.domain.vo.FileUploadVO;
import org.springframework.web.multipart.MultipartFile;

import java.util.concurrent.ConcurrentHashMap;

/**
 * 接口
 *
 */
public interface IFileStorageService {

    /**
     * 文件上传
     *
     * @param file
     * @param path
     * @return
     */
    ResponseDTO<FileUploadVO> upload(MultipartFile file, String path);

    /**
     * 获取文件url
     *
     * @param fileKey
     * @return
     */
    ResponseDTO<String> getFileUrl(String fileKey);


    /**
     * 流式下载（名称为原文件）
     *
     * @param key
     * @return
     */
    ResponseDTO<FileDownloadVO> download(String key);

    /**
     * 单个删除文件
     * 根据文件key删除
     *
     * @param fileKey
     * @return
     */
    ResponseDTO<String> delete(String fileKey);


    /**
     * 获取文件类型
     *
     * @param fileExt
     * @return
     */
    default String getContentType(String fileExt) {
        ConcurrentHashMap<String, String> concurrentMap = new ConcurrentHashMap<>();
        concurrentMap.put("bmp", "image/bmp");
        concurrentMap.put("gif", "image/gif");
        concurrentMap.put("jpeg", "image/jpeg");
        concurrentMap.put("jpg", "image/jpeg");
        concurrentMap.put("png", "image/png");
        concurrentMap.put("html", "text/html");
        concurrentMap.put("txt", "text/plain");
        concurrentMap.put("vsd", "application/vnd.visio");
        concurrentMap.put("ppt", "application/vnd.ms-powerpoint");
        concurrentMap.put("pptx", "application/vnd.ms-powerpoint");
        concurrentMap.put("doc", "application/msword");
        concurrentMap.put("docx", "application/msword");
        concurrentMap.put("pdf", "application/pdf");
        concurrentMap.put("xml", "text/xml");

        String fileContentType = concurrentMap.get(fileExt.toLowerCase());
        return !StrUtil.isEmpty(fileContentType) ? fileContentType : "";
    }
}
