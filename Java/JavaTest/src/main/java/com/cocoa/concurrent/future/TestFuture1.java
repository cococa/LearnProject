package com.cocoa.concurrent.future;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

public class TestFuture1 {


    /**
     * 常见的两种创建线程的方式。一种是直接继承Thread，另外一种就是实现Runnable接口。
     * 这两种方式都有一个缺陷就是：在执行完任务之后无法获取执行结果。
     */

    class Task implements Callable<String> {
        private String tag;
        private Long time;

        public Task(String tag, Long time) {
            this.tag = tag;
            this.time = time;
        }

        @Override
        public String call() throws Exception {
            Thread.sleep(TimeUnit.SECONDS.toMillis(this.time));
            return this.tag;
        }
    }


    @Test
    public void test1() throws Exception {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        Callable<String> task1 = new Task("hello", 2L);
        Callable<String> task2 = new Task("World", 10L);
        Future<String> future1 = executorService.submit(task1);
        Future<String> future2 = executorService.submit(task2);
        // 阻塞
        String o1 = future1.get();
        String o2 = future2.get();
        System.out.println("the result = " + o1 + o2);
        System.out.println("done!");
    }

    @Test
    public void test2() throws Exception {
        List<Integer> list1 = new ArrayList<>();
        list1.add(5);
//        list1.add(2);
//        list1.add(3);
        List<Integer> list2 = new ArrayList<>();
        list2.add(1);
        list2.add(2);
        list2.add(3);
        list1.retainAll(list2);
        System.out.println(list1);
        System.out.println(list2);


    }
}
