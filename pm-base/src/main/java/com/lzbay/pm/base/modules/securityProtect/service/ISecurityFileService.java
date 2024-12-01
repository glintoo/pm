package com.lzbay.pm.base.modules.securityProtect.service;

import com.lzbay.pm.base.common.domain.ResponseDTO;
import org.springframework.web.multipart.MultipartFile;

public interface ISecurityFileService {
    ResponseDTO<String> checkFile(MultipartFile file);
}
