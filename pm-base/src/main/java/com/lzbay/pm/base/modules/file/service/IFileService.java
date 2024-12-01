package com.lzbay.pm.base.modules.file.service;

import com.lzbay.pm.base.common.domain.RequestUser;
import com.lzbay.pm.base.common.domain.ResponseDTO;
import com.lzbay.pm.base.modules.file.domain.vo.FileDownloadVO;
import com.lzbay.pm.base.modules.file.domain.vo.FileUploadVO;
import org.springframework.web.multipart.MultipartFile;

public interface IFileService {
    ResponseDTO<FileUploadVO> fileUpload(MultipartFile file, Integer folderType, RequestUser requestUser);

    ResponseDTO<String> getFileUrl(String fileKeys);

    ResponseDTO<FileDownloadVO> getDownloadFile(String fileKey, String userAgent);
}
