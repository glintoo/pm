package com.lzbay.pm.base.modules.config.service;

import com.lzbay.pm.base.common.domain.ResponseDTO;
import com.lzbay.pm.base.common.enums.ConfigKeyEnum;
import com.lzbay.pm.base.modules.config.domain.form.ConfigAddForm;
import com.lzbay.pm.base.modules.config.domain.form.ConfigUpdateForm;

public interface IConfigService {

    ResponseDTO<String> add(ConfigAddForm configAddForm);

    ResponseDTO<String> updateConfig(ConfigUpdateForm updateDTO);

    ResponseDTO<String> updateValueByKey(ConfigKeyEnum key, String value);
}
