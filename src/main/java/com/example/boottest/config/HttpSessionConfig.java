package com.example.boottest.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

/**
 * Created by zhangtianlong on 19/9/4.
 */
@Configuration
@EnableRedisHttpSession
public class HttpSessionConfig {

}
