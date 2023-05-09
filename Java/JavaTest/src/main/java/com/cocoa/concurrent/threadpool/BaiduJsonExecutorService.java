package com.cocoa.concurrent.threadpool;

import org.junit.Test;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class BaiduJsonExecutorService {


    public class DownloadCallable implements Callable {

        private final Long time;

        public DownloadCallable(Long time) {
            this.time = time;
        }

        @Override
        public Boolean call() throws Exception {
            Thread.sleep(time * 1000);
            return true;
        }
    }


    @Test
    public void test1() throws Exception{
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        Future submit1 = executorService.submit(new DownloadCallable(1L));
        Future submit2 = executorService.submit(new DownloadCallable(10L));
        Future submit3 = executorService.submit(new DownloadCallable(10L));
        Future submit4 = executorService.submit(new DownloadCallable(10L));


        System.out.println(submit1.get());
        System.out.println(submit2.get());
        System.out.println(submit3.get());
//        System.out.println(submit4.get());
        boolean down = executorService.isTerminated();
        while (!down){
            down = executorService.isTerminated();

        }

    }


}
