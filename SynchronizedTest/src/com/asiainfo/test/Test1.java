package com.asiainfo.test;

public  class Test1 {
	
	
	
	public    void m1() {
		System.out.println("Test.m1()...begin");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Test.m1()...end");
	}
	
	public  void m2() {
		synchronized(Test1.class) {
		System.out.println("Test.m2()...begin");
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Test.m2()...end");
		}
	}
	
	public  void m3() {
		synchronized(Test1.class) {
		System.out.println("Test.m3()...begin");
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Test.m3()...end");
		}
	}
	public   void m5() {System.out.println("Test.m5()...end");};
	
	
	public static class MyThread01 implements Runnable{
		int i;
		Test1 test1;
		public MyThread01(int i ,Test1 test1) {
			this.i=i;
			this.test1=test1;
		}

		@Override
		public void run() {
			switch(i) {
			case 0:
				test1.m3();
				break;
			case 1:
				test1.m5();
				break;
			case 2:
				test1.m3();
				break;
			}
			
		}
		
	}
	public static void main(String[] args) {
		Test1 test1 =new Test1();
		Sub_Test1 sub_Test1 =new Sub_Test1();
		new Thread(new MyThread01(0,test1)).start();
		new Thread(new MyThread01(1,sub_Test1)).start();
		
		
	}
}

class Sub_Test1 extends Test1{
	public void m5() {
		synchronized(Test1.class) {
			System.out.println("Sub_Test1.m5()...begin");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Sub_Test1.m5()...end");
		}
		
	}
	
	
	
}
