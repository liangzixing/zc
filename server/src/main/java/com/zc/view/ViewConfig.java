/*Copyright 1999-2017. Alibaba.com All right reserved. This software is the
confidential and proprietary information of Alibaba.com ("Confidential
Information"). You shall not disclose such Confidential Information and shall
use it only in accordance with the terms of the license agreement you entered
into with Alibaba.com.*/

package com.zc.view;

import org.apache.commons.collections.map.HashedMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.view.velocity.VelocityConfigurer;
import org.springframework.web.servlet.view.velocity.VelocityLayoutViewResolver;

/**
 * @author zixing.liangzx@alibaba-inc.com
 * @version 17/9/1 16:15 1.0.0
 */
@Configuration
public class ViewConfig {

    @Bean("velocityConfig")
    public VelocityConfigurer velocityConfigurer() {
        VelocityConfigurer velocityConfigurer = new VelocityConfigurer();

        velocityConfigurer.setResourceLoaderPath("classpath:/templates/");
        velocityConfigurer.setVelocityPropertiesMap(new HashedMap() {{
            put("input.encoding", "UTF-8");
            put("out.encoding", "UTF-8");
        }});

        return velocityConfigurer;
    }

    @Bean("viewResolver")
    public VelocityLayoutViewResolver velocityViewResolver() {
        VelocityLayoutViewResolver velocityLayoutViewResolver = new VelocityLayoutViewResolver();

        velocityLayoutViewResolver.setCache(false);

        velocityLayoutViewResolver.setLayoutUrl("/layout/layout.vm");

        velocityLayoutViewResolver.setPrefix("/");
        velocityLayoutViewResolver.setSuffix(".vm");
        velocityLayoutViewResolver.setContentType("text/html;charset=UTF-8");

        return velocityLayoutViewResolver;
    }
}
