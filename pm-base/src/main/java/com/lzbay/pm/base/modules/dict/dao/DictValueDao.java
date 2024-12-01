package com.lzbay.pm.base.modules.dict.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lzbay.pm.base.modules.dict.domain.entity.DictValueEntity;
import com.lzbay.pm.base.modules.dict.domain.form.DictValueQueryForm;
import com.lzbay.pm.base.modules.dict.domain.vo.DictValueVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 字典
 *
 */
@Mapper
@Component
public interface DictValueDao extends BaseMapper<DictValueEntity> {

    /**
     * 查找所有未删除的自带key
     *
     */
    List<DictValueEntity> selectByDeletedFlag(@Param("deletedFlag") Boolean deletedFlag);

    /**
     * 查找所有未删除的自带key
     *
     */
    List<DictValueEntity> selectByDeletedFlagAndKeyId(@Param("dictKeyId") Long dictKeyId, @Param("deletedFlag") Boolean deletedFlag);

    /**
     * 逻辑删除
     *
     */
    void updateDeletedFlagByIdList(@Param("dictValueIdList") List<Long> dictValueIdList, @Param("deletedFlag") Boolean deletedFlag);

    /**
     * 分页查询
     *
     */
    List<DictValueVO> query(Page page, @Param("query") DictValueQueryForm queryForm);

    /**
     * 跟进code查询
     *
     */
    DictValueEntity selectByCode(@Param("valueCode") String valueCode, @Param("deletedFlag") Boolean deletedFlag);
}
