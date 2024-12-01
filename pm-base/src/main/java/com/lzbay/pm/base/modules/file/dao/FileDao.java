package com.lzbay.pm.base.modules.file.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lzbay.pm.base.modules.file.domain.entity.FileEntity;
import com.lzbay.pm.base.modules.file.domain.form.FileQueryForm;
import com.lzbay.pm.base.modules.file.domain.vo.FileVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;

/**
 * 文件服务
 *
 */
@Mapper
@Component
public interface FileDao extends BaseMapper<FileEntity> {

    /**
     * 文件key单个查询
     *
     * @param fileKey
     * @return
     */
    FileVO getByFileKey(@Param("fileKey") String fileKey);


    /**
     * 批量获取
     */
    List<FileVO> selectByFileKeyList(@Param("fileKeyList") Collection<String> fileKeyList);

    /**
     * 分页 查询
     *
     * @param page
     * @param queryForm
     * @return
     */
    List<FileVO> queryPage(Page page, @Param("queryForm") FileQueryForm queryForm);

}
