package com.lzbay.pm.base.common.utils;

import com.lzbay.pm.base.common.enums.BaseEnum;

import java.util.stream.Stream;

public class CustomEnumUtil {
    public static <T extends BaseEnum> T getEnumByValue(Object value, Class<T> enumClass) {
        if (null == value) {
            return null;
        }
        return Stream.of(enumClass.getEnumConstants())
                .filter(e -> e.equalsValue(value))
                .findFirst()
                .orElse(null);
    }
}
