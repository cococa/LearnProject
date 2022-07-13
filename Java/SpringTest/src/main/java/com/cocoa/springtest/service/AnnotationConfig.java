package com.cocoa.springtest.service;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AnnotationConfig {

    @Bean
    public SS getS() {
        SS ss = new SS();
        ss.setName("cocoa");
        return ss;
    }

    @Bean
    public SS s() {
        SS ss = new SS();
        ss.setName("s's's");
        return ss;
    }



}
