package com.lzbay.pm.base.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum SystemEnvironmentEnum implements BaseEnum {

    DEV(SystemEnvironmentNameConst.DEV, "开发环境"),

    TEST(SystemEnvironmentNameConst.TEST, "测试环境"),

    PROD(SystemEnvironmentNameConst.PROD, "生产环境");

    private final String value;
    private final String desc;

    public static final class SystemEnvironmentNameConst {
        public static final String DEV = "dev";
        public static final String TEST = "test";
        public static final String PROD = "prod";
    }
}
