package com.lzbay.pm.business;

import com.lzbay.pm.base.listener.Ip2RegionListener;
import com.lzbay.pm.base.listener.LogVariableListener;
import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.UserDetailsServiceAutoConfiguration;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableScheduling;


@EnableCaching
@EnableScheduling
@EnableAspectJAutoProxy(proxyTargetClass = true, exposeProxy = true)
@ComponentScan(PmBusinessApplication.SCAN_PACKAGE)
@MapperScan(value = PmBusinessApplication.SCAN_PACKAGE, annotationClass = Mapper.class)
@SpringBootApplication(exclude = {UserDetailsServiceAutoConfiguration.class})
public class PmBusinessApplication {

    public static final String SCAN_PACKAGE = "com.lzbay.pm";

    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(PmBusinessApplication.class);

        application.addListeners(new LogVariableListener(), new Ip2RegionListener());
        application.run(args);
    }

}
