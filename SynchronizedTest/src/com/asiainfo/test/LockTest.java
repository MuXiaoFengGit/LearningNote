package com.asiainfo.test;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockTest {
	Lock lock =new ReentrantLock();
	void m1() {
		lock.lock();
		Condition newCondition = lock.newCondition();
		try {
			newCondition.await();
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		newCondition.signalAll();
		System.out.println("m1--Begin");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("m1--End");
		lock.unlock();
	}
	
	void m2() {
		try {
			lock.lockInterruptibly();
			System.out.println("m2--suceess");
		} catch (InterruptedException e) {
			System.out.println("m2--lockInterruptibly");
//			e.printStackTrace();
		}
		try {
			lock.unlock();
		} catch (Exception e) {
			System.out.println("m2--unlock");
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) {
		LockTest test =new LockTest();
		Thread t1 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				test.m1();
			}
		});
				t1.start();
		Thread t2 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				test.m2();
			}
		});
				t2.start();
				t2.interrupt();
	}

}
