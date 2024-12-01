package com.lzbay.pm.base.modules.dict.service.impl;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.StrUtil;
import com.google.common.collect.Lists;
import com.lzbay.pm.base.common.domain.ResponseDTO;
import com.lzbay.pm.base.common.utils.CustomBeanUtil;
import com.lzbay.pm.base.modules.dict.dao.DictKeyDao;
import com.lzbay.pm.base.modules.dict.dao.DictValueDao;
import com.lzbay.pm.base.modules.dict.domain.entity.DictKeyEntity;
import com.lzbay.pm.base.modules.dict.domain.entity.DictValueEntity;
import com.lzbay.pm.base.modules.dict.domain.vo.DictValueVO;
import com.lzbay.pm.base.modules.dict.service.IDictCacheService;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

/**
 * 字典缓存 服务
 *
 */
@Slf4j
@Service
public class DictCacheServiceImpl implements IDictCacheService {

    @Resource
    private DictKeyDao dictKeyDao;
    @Resource
    private DictValueDao dictValueDao;

    private final ConcurrentHashMap<String, List<DictValueVO>> DICT_CACHE = new ConcurrentHashMap<>();

    private final ConcurrentHashMap<String, DictValueVO> VALUE_CACHE = new ConcurrentHashMap<>();


    @PostConstruct
    public void dictCache() {
        this.cacheInit();
    }

    public void cacheInit() {
        List<DictKeyEntity> dictKeyEntityList = dictKeyDao.selectByDeletedFlag(false);
        if (CollectionUtil.isEmpty(dictKeyEntityList)) {
            return;
        }
        List<DictValueEntity> dictKeyValueList = dictValueDao.selectByDeletedFlag(false);
        List<DictValueVO> dictValueVOList = CustomBeanUtil.copyList(dictKeyValueList, DictValueVO.class);
        Map<Long, List<DictValueVO>> valueListMap = dictValueVOList.stream().collect(Collectors.groupingBy(DictValueVO::getDictKeyId));
        //字典键值对缓存
        for (DictKeyEntity dictKeyEntity : dictKeyEntityList) {
            String keyCode = dictKeyEntity.getKeyCode();
            Long dictKeyId = dictKeyEntity.getDictKeyId();
            DICT_CACHE.put(keyCode, valueListMap.getOrDefault(dictKeyId, Lists.newArrayList()));
        }
        //字典值缓存
        dictValueVOList.forEach(e -> {
            VALUE_CACHE.put(e.getValueCode(), e);
        });
        log.info("################# 数据字典缓存初始化完毕 ###################");
    }

    /**
     * 刷新缓存
     */
    public ResponseDTO<String> cacheRefresh() {
        DICT_CACHE.clear();
        VALUE_CACHE.clear();
        this.cacheInit();
        return ResponseDTO.ok();
    }

    /**
     * 查询某个key对应的字典值列表
     *
     * @param keyCode
     * @return
     */
    public List<DictValueVO> selectByKeyCode(String keyCode) {
        return DICT_CACHE.getOrDefault(keyCode, Lists.newArrayList());
    }

    /**
     * 查询值code名称
     *
     * @param valueCode
     * @return
     */
    public String selectValueNameByValueCode(String valueCode) {
        if (StrUtil.isEmpty(valueCode)) {
            return null;
        }

        DictValueVO dictValueVO = VALUE_CACHE.get(valueCode);
        if (dictValueVO == null) {
            return "";
        }
        return dictValueVO.getValueName();
    }

    public DictValueVO selectValueByValueCode(String valueCode) {
        if (StrUtil.isEmpty(valueCode)) {
            return null;
        }
        return VALUE_CACHE.get(valueCode);
    }

    public String selectValueNameByValueCodeSplit(String valueCodes) {
        if (StrUtil.isEmpty(valueCodes)) {
            return "";
        }
        List<String> valueNameList = Lists.newArrayList();
        String[] valueCodeArray = valueCodes.split(",");
        for (String valueCode : valueCodeArray) {
            DictValueVO dictValueVO = VALUE_CACHE.get(valueCode);
            if (dictValueVO != null) {
                valueNameList.add(dictValueVO.getValueName());
            }
        }
        return StringUtils.join(valueNameList, ",");
    }

}