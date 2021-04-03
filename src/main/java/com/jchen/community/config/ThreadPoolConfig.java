package com.jchen.community.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @Auther: jchen
 * @Date: 2021/04/03/16:11
 */
@Configuration
@EnableScheduling
@EnableAsync
public class ThreadPoolConfig {
}
