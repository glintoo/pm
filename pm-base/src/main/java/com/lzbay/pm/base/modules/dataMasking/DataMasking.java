package com.lzbay.pm.base.modules.dataMasking;

import com.fasterxml.jackson.annotation.JacksonAnnotationsInside;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.lzbay.pm.base.common.enums.DataMaskingTypeEnum;
import com.lzbay.pm.base.common.json.serializer.DataMaskingSerializer;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 脱敏注解
 *
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@JacksonAnnotationsInside
@JsonSerialize(using = DataMaskingSerializer.class, nullsUsing = DataMaskingSerializer.class)
public @interface DataMasking {

    DataMaskingTypeEnum value() default DataMaskingTypeEnum.COMMON;

}
