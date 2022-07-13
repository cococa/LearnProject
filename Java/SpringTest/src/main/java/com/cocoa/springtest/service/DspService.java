package com.cocoa.springtest.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DspService {


    @Autowired
    private SS s;

//    @Autowired
//    public DspService(SS s){
//        System.out.println("--DspService--"+s);
//        this.s = s;
//    }

    public String test1() {
        return s.getName();
    }

}


