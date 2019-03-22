package com.asiainfo.test;

import java.util.concurrent.CountDownLatch;

public class Test4 {
	String a="Hi";
	String b ="H"+"i";
	
	void m1() {
		synchronized(a) {
			System.out.println("m1...");
			while(true) {}
		}
		
	}
	void m2() {
		synchronized(b) {
			System.out.println("m1...");
			while(true) {}
		}
		
	}
	public static void main(String[] args) {
		Test4 test4 =new Test4();
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				test4.m1();
				
			}
		}).start();
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				test4.m2();
				
			}
		}).start();
		
		
		CountDownLatch cc =new CountDownLatch(5);
		cc.countDown();
		
	}

}
