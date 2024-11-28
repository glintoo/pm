package com.lzbay.pm.business.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class AppStartupRunner implements CommandLineRunner {

    @Override
    public void run(String... args) {
        log.info("AppStartupRunner running");
    }
}
