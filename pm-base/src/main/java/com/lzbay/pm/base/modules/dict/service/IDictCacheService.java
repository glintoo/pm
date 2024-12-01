package com.lzbay.pm.base.modules.dict.service;

import com.lzbay.pm.base.common.domain.ResponseDTO;

public interface IDictCacheService {

    ResponseDTO<String> cacheRefresh();

}
