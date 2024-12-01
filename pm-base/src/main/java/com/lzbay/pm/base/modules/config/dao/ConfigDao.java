package com.lzbay.pm.base.modules.config.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lzbay.pm.base.modules.config.domain.entity.ConfigEntity;
import com.lzbay.pm.base.modules.config.domain.form.ConfigQueryForm;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 系统参数配置 t_config Dao层
 *
 */
@Component
@Mapper
public interface ConfigDao extends BaseMapper<ConfigEntity> {

    /**
     * 分页查询系统配置
     *
     */
    List<ConfigEntity> queryByPage(Page page, @Param("query") ConfigQueryForm queryForm);

    /**
     * 根据key查询获取数据
     *
     */
    ConfigEntity selectByKey(String key);
}
