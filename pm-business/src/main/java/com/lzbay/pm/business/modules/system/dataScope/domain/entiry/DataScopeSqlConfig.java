package com.lzbay.pm.business.modules.system.dataScope.domain.entiry;

import com.lzbay.pm.business.enums.DataScopeTypeEnum;
import com.lzbay.pm.business.enums.DataScopeWhereInTypeEnum;
import lombok.Data;

/**
 * 数据范围
 *
 */
@Data
public class DataScopeSqlConfig {

    /**
     * 数据范围类型
     * {@link DataScopeTypeEnum}
     */
    private DataScopeTypeEnum dataScopeType;

    /**
     * join sql 具体实现类
     */
    private Class joinSqlImplClazz;

    private String joinSql;

    private Integer whereIndex;

    private String paramName;

    /**
     * whereIn类型
     * {@link DataScopeWhereInTypeEnum}
     */
    private DataScopeWhereInTypeEnum dataScopeWhereInType;
}
