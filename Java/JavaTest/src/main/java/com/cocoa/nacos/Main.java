package com.cocoa.nacos;

import com.alibaba.nacos.api.NacosFactory;
import com.alibaba.nacos.api.config.ConfigService;
import com.alibaba.nacos.api.exception.NacosException;

import java.util.Properties;

public class Main {

    public static void main(String[] args) {
        ///Users/shenjun/Documents/cocoa/nacos/distribution/target/nacos-server-2.1.0/nacos/bin
        try {
            String serverAddr = "127.0.0.1:8848";
            String dataId = "{dataId}";
            String group = "{group}";
            Properties properties = new Properties();
            properties.put("serverAddr", serverAddr);
            ConfigService configService = NacosFactory.createConfigService(properties);
            String content = configService.getConfig(dataId, group, 5000);
            System.out.println(content);
        } catch (NacosException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}
