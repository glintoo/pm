package com.lzbay.pm.base.common.domain;

import com.lzbay.pm.base.common.enums.SystemEnvironmentEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class SystemEnvironment {
    private boolean isProd;

    private String projectName;

    private SystemEnvironmentEnum currentEnvironment;
}
