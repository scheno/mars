package com.xinghuan.mars.config;

import com.xinghuan.mars.interceptor.HttpClientInterceptor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author shenchen
 * @version 1.0
 * @date 2022/3/21 2:32 下午
 */
@Slf4j
@Configuration
@RequiredArgsConstructor
public class RestTemplateConfig {

    private final HttpClientInterceptor httpClientInterceptor;
    @Bean
    public RestTemplate restTemplate() {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getInterceptors().add(httpClientInterceptor);
        return restTemplate;
    }
}
