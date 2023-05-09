package com.cocoa.concurrent.threadpool;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class Test1{
	public static void main(String[] args) throws ExecutionException, InterruptedException {
			
//		AtomicInteger ai = new AtomicInteger();
//
//		System.out.println(ai.getAndIncrement());
//		System.out.println(ai.getAndIncrement());
//		System.out.println(ai.getAndIncrement());
//		System.out.println(ai.getAndIncrement());

		Callable<String> callable = new Callable<String>() {
			@Override
			public String call() throws Exception {

				Thread.sleep(3000);
				return "123";
			}
		};

		FutureTask futureTask = new FutureTask(callable);
		new Thread(futureTask).start();

		System.out.println(futureTask.get());

	}
}