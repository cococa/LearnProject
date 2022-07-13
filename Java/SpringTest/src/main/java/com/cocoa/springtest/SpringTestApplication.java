package com.cocoa.springtest;

import com.alibaba.nacos.spring.context.annotation.config.NacosPropertySource;
import com.cocoa.springtest.service.DspService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.Resource;

@SpringBootApplication
@NacosPropertySource(dataId = "com.cocoa.springtest",  autoRefreshed = true)  //groupId = "DEFAULT_GROUP",
public class SpringTestApplication {




    public static void main(String[] args) {
        SpringApplication.run(SpringTestApplication.class, args);
    }

}
