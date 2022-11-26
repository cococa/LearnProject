package com.cocoa.guava;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import org.junit.Test;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public class TestCache {


    @Test
    public void test1() throws ExecutionException {
        Cache<String, String> cache = CacheBuilder.newBuilder()
                .expireAfterAccess(5, TimeUnit.SECONDS)
                .maximumSize(1024).build();

        String key = "name";
        String value = "cocoa";


        cache.put(key, value);
        String s = cache.get(key, () -> {
            return "111222";
        });
        System.out.println(s);

        try {
            Thread.sleep(6 * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        String s1 = cache.get(key, () -> {
            return "111222";
        });
        System.out.println(s1);
    }


}
