package com.lzbay.pm.base.modules.redis;

import cn.hutool.core.util.StrUtil;
import org.redisson.config.Config;
import org.redisson.spring.starter.RedissonAutoConfigurationCustomizer;
import org.springframework.stereotype.Component;

/**
 *
 * redission对于password 为空处理有问题，重新设置下
 *
 * @Author 1024创新实验室-主任:卓大
 * @Date 2024/7/16 01:04:18
 * @Wechat zhuoda1024
 * @Email lab1024@163.com
 * @Copyright  <a href="https://1024lab.net">1024创新实验室</a> ，Since 2012
 */

@Component
public class RedissonPasswordConfigurationCustomizer implements RedissonAutoConfigurationCustomizer {
    @Override
    public void customize(Config configuration) {
        if (configuration.isSingleConfig() && StrUtil.isEmpty(configuration.useSingleServer().getPassword())) {
            configuration.useSingleServer().setPassword(null);
        }

        if (configuration.isClusterConfig() && StrUtil.isEmpty(configuration.useClusterServers().getPassword())) {
            configuration.useClusterServers().setPassword(null);
        }
        if (configuration.isSentinelConfig() && StrUtil.isEmpty(configuration.useSentinelServers().getPassword())) {
            configuration.useSentinelServers().setPassword(null);
        }
    }
}
