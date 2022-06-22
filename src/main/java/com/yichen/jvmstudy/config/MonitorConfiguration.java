package com.yichen.jvmstudy.config;

import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.stereotype.Component;

/**
 * @author Qiuxinchao
 * @version 1.0
 * @date 2022/6/22 9:38
 * @describe 监控配置
 */
@Configuration
public class MonitorConfiguration {

    @Component
    @Slf4j
    public static class SpringBootStartListener implements ApplicationListener<ApplicationReadyEvent> {
        @Override
        public void onApplicationEvent(ApplicationReadyEvent applicationReadyEvent) {
            log.info("=> SpringBoot启动成功");
        }
    }

    @Component
    @Slf4j
    public static class SpringBootStopListenner implements ApplicationListener<ContextClosedEvent> {
        // 监听kill pid     无法监听 kill -9 pid
        @Override
        public void onApplicationEvent(ContextClosedEvent contextClosedEvent) {
            log.info("=> SpringBoot即将关闭");
        }
    }

}
