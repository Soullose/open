package com.wsf.infrastructure.open;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringApplicationRunListener;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

/**
 * open
 * SoulLose
 * 2022-05-26 20:58
 */
public class OpenApplicationRunListener implements SpringApplicationRunListener {
    private static final Logger log = LoggerFactory.getLogger(OpenApplicationRunListener.class);
    
    
    public OpenApplicationRunListener(SpringApplication springApplication,String[] args){}
    
    @Override
    public void starting() {
        log.info("服务启动Runner starting");
    }
    
    @Override
    public void environmentPrepared(ConfigurableEnvironment environment) {
        log.debug("服务启动Runner environmentPrepared");
    }
    
    @Override
    public void contextPrepared(ConfigurableApplicationContext context) {
        log.debug("服务启动Runner contextPrepared");
    }
    
    @Override
    public void contextLoaded(ConfigurableApplicationContext context) {
        log.debug("服务启动Runner contextLoaded");
    }
    
    @Override
    public void started(ConfigurableApplicationContext context) {
        log.debug("服务启动Runner started");
    }
    
    @Override
    public void running(ConfigurableApplicationContext context) {
        log.debug("服务启动Runner running");
    }
    
    @Override
    public void failed(ConfigurableApplicationContext context, Throwable exception) {
        log.debug("服务启动Runner failed");
    }
}
