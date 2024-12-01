package com.lzbay.pm.base.common.json.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.lzbay.pm.base.common.domain.ResponseDTO;
import com.lzbay.pm.base.modules.file.service.impl.FileServiceImpl;
import jakarta.annotation.Resource;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;

/**
 * 文件key进行序列化对象
 *
 */
public class FileKeySerializer extends JsonSerializer<String> {

    @Resource
    private FileServiceImpl fileService;


    @Override
    public void serialize(String value, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        if (StringUtils.isEmpty(value)) {
            jsonGenerator.writeString(value);
            return;
        }
        if (fileService == null) {
            jsonGenerator.writeString(value);
            return;
        }
        ResponseDTO<String> responseDTO = fileService.getFileUrl(value);
        if (responseDTO.getOk()) {
            jsonGenerator.writeString(responseDTO.getData());
            return;
        }
        jsonGenerator.writeString(value);
    }
}