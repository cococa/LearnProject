package com.cocoa.springtest.controller;


import com.alibaba.nacos.api.config.annotation.NacosValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/nacos")
public class TestNacosController {

    @NacosValue(value = "${useLocalCache:false}", autoRefreshed = true)
    private boolean useLocalCache;

    @NacosValue(value = "${count:0}", autoRefreshed = true)
    private Integer count;

    @RequestMapping(value = "/test1", method = RequestMethod.GET)
    public String test1() {
        return "hello" + useLocalCache + count;
    }


}
