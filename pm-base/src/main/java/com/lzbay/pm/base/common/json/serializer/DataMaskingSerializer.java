package com.lzbay.pm.base.common.json.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.ContextualSerializer;
import com.lzbay.pm.base.common.enums.DataMaskingTypeEnum;
import com.lzbay.pm.base.common.utils.CustomDataMaskingUtil;
import com.lzbay.pm.base.modules.dataMasking.DataMasking;
import org.apache.commons.lang3.ObjectUtils;

import java.io.IOException;

/**
 * 脱敏序列化
 *
 */
public class DataMaskingSerializer extends JsonSerializer<Object> implements ContextualSerializer {

    private DataMaskingTypeEnum typeEnum;

    @Override
    public void serialize(Object value, JsonGenerator jsonGenerator, SerializerProvider serializers) throws IOException {

        if (ObjectUtils.isEmpty(value)) {
            jsonGenerator.writeObject(value);
            return;
        }

        if (typeEnum == null) {
            jsonGenerator.writeObject(CustomDataMaskingUtil.dataMasking(String.valueOf(value)));
            return;
        }

        jsonGenerator.writeObject(CustomDataMaskingUtil.dataMasking(value, typeEnum));
    }

    @Override
    public JsonSerializer<?> createContextual(SerializerProvider prov, BeanProperty property) throws JsonMappingException {
        // 判断beanProperty是不是空
        if (null == property) {
            return prov.findNullValueSerializer(null);
        }

        DataMasking annotation = property.getAnnotation(DataMasking.class);
        if (null == annotation) {
            return prov.findValueSerializer(property.getType(), property);
        }

        typeEnum = annotation.value();
        return this;
    }

}