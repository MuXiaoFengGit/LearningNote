package com.asiainfo.test;

public class Test3 {
	Object o =new Object();
	void m() throws InterruptedException {
		System.out.println(Thread.currentThread().getName()+"start...");
		synchronized(o) {
			while(true) {
					Thread.sleep(1000);
					System.out.println(Thread.currentThread().getName()+"..."+o);
			}
		}
		
	}
	void setO() {
		System.out.println(o);
		o=new Object();
		System.out.println(o);
	}
	
	public static void main(String[] args) throws InterruptedException {
		final Test3 test3 =new Test3();
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				try {											
					test3.m();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		},"T1").start();
		Thread.sleep(1000);
		Thread thread2 =new Thread(new Runnable() {
			
			@Override
			public void run() {
				try {
					test3.m();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		},"T2");
		test3.setO();
		thread2.start();
		
		
	}

}
