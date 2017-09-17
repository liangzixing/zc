/*Copyright 1999-2017. Alibaba.com All right reserved. This software is the
confidential and proprietary information of Alibaba.com ("Confidential
Information"). You shall not disclose such Confidential Information and shall
use it only in accordance with the terms of the license agreement you entered
into with Alibaba.com.*/

package com.zc.main;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author zixing.liangzx@alibaba-inc.com
 * @version 17/8/31 15:09 1.0.0
 */
@SpringBootApplication
@ComponentScan("com.zc")
@MapperScan("com.zc.**.dao")
public class ApplicationMain {

    public static void main(String[] args) {
        SpringApplication.run(ApplicationMain.class, args);
    }

}
