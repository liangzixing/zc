/*Copyright 1999-2017. Alibaba.com All right reserved. This software is the
confidential and proprietary information of Alibaba.com ("Confidential
Information"). You shall not disclose such Confidential Information and shall
use it only in accordance with the terms of the license agreement you entered
into with Alibaba.com.*/

package com.zc.view;

import java.nio.charset.Charset;

import java.util.List;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @author zixing.liangzx@alibaba-inc.com
 * @version 17/9/8 14:17 1.0.0
 */
@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/login").setViewName("loginPage");
    }

    @Bean
    public HttpMessageConverter<String> responseBodyConverter() {
        StringHttpMessageConverter converter = new StringHttpMessageConverter(
            Charset.forName("UTF-8"));
        return converter;
    }

    @Override
    public void configureMessageConverters(
        List<HttpMessageConverter<?>> converters) {
        super.configureMessageConverters(converters);
        converters.add(responseBodyConverter());
    }

    @Override
    public void configureContentNegotiation(
        ContentNegotiationConfigurer configurer) {
        configurer.favorPathExtension(false);
    }
}