package com.cocoa.springtest.controller;


import com.alibaba.nacos.api.config.annotation.NacosValue;
import com.cocoa.springtest.service.DspService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/bean")
public class TestBeanController {

    @Resource
    private DspService dspService;

    @RequestMapping(value = "/test1", method = RequestMethod.GET)
    public String test1() {


        return "hello" + dspService.test1();
    }


}
