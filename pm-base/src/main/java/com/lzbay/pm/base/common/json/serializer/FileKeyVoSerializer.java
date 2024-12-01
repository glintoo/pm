package com.lzbay.pm.base.common.json.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.google.common.collect.Lists;
import com.lzbay.pm.base.modules.file.domain.vo.FileVO;
import com.lzbay.pm.base.modules.file.service.impl.FileServiceImpl;
import jakarta.annotation.Resource;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * 文件key进行序列化对象
 *
 */
public class FileKeyVoSerializer extends JsonSerializer<String> {

    @Resource
    private FileServiceImpl fileService;


    @Override
    public void serialize(String value, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        if (StringUtils.isEmpty(value)) {
            jsonGenerator.writeObject(Lists.newArrayList());
            return;
        }
        if(fileService == null){
            jsonGenerator.writeString(value);
            return;
        }
        String[] fileKeyArray = value.split(",");
        List<String> fileKeyList = Arrays.asList(fileKeyArray);
        List<FileVO> fileKeyVOList = fileService.getFileList(fileKeyList);
        jsonGenerator.writeObject(fileKeyVOList);
    }
}
