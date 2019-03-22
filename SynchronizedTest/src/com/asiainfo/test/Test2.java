package com.asiainfo.test;

import java.util.concurrent.TimeUnit;

public class Test2 {
	public boolean flag =true;
	public void m0() {
		System.out.println("begin...");
		while(flag) {
			int i=0;
			i++;
		}
		System.out.println("end...");
	}
	public void  setFlag() {
		System.out.println("set..");flag=false;
	}
	public static void main(String[] args) throws InterruptedException {
		Test2 test2 =new Test2();
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				test2.m0();
			}
		}).start();
		
		Thread.sleep(500);
		
		test2.setFlag();
		
	}

}
