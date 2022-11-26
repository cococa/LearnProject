package com.cocoa.lambda;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class PracticeBaiduJson {

    @Test
    void test1() {
        Arrays.asList(1,2,3,4,5)
                .stream()
                .map(x -> x*x )
                .forEach(System.out::println);
    }
}