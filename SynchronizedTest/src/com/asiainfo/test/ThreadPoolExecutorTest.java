package com.asiainfo.test;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolExecutorTest {

	public static void main(String[] args) {
		ThreadPoolExecutor threadPoolExecutor = 
				new ThreadPoolExecutor(5, 5, 123, TimeUnit.SECONDS,new LinkedBlockingQueue<Runnable>());
		for(int i=0;i<5;i++) {
			threadPoolExecutor.execute(new Runnable() {
				@Override
				public void run() {
					System.out.println(Thread.currentThread().getName());
					
				}
			});
		}
		System.out.println(threadPoolExecutor);
		threadPoolExecutor.shutdown();
		
	}
	
}
