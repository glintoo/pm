package com.lzbay.pm.business.modules.system.dataScope.strategy;


import com.lzbay.pm.business.enums.DataScopeViewTypeEnum;
import com.lzbay.pm.business.modules.system.dataScope.domain.entiry.DataScopeSqlConfig;

import java.util.Map;

/**
 * 数据范围策略 ,使用DataScopeWhereInTypeEnum.CUSTOM_STRATEGY类型，DataScope注解的joinSql属性无用
 *
 */
public abstract class AbstractDataScopeStrategy {

    /**
     * 获取joinsql 字符串
     */
    public abstract String getCondition(DataScopeViewTypeEnum viewTypeEnum, Map<String, Object> paramMap, DataScopeSqlConfig sqlConfigDTO);
}
