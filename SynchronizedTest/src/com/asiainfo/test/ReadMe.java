package com.asiainfo.test;

import java.util.Arrays;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReadMe {
	
	
	
	public static void main(String[] args) {
		MyCollection collection =new MyCollection();
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				boolean flag =true;
				while(flag) {
					if(collection.getSize() == 5) {
						System.out.println("collection.getSize()="+collection.getSize());
						try {
							Thread.sleep(2000);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						System.out.println("End..."+collection.getSize());
						System.out.println("End..."+collection.getSize());
						System.out.println("End..."+collection.getSize());
						System.out.println("End..."+collection.getSize());
						System.out.println("End..."+collection.getSize());
						flag=false;
					}
				}
				
			}
		}).start();
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				for(int i=0;i<10;i++) {
					Element ele =new Element(i);
					collection.add(ele);
					System.out.println("add.."+i);
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
			}
		}).start();
		
		
	}

}

class Element{
	int i;
	Element(int i){
		this.i =i;
	}
}
class MyCollection{
	private int index=0;
	Object o =new Object();
	String a ="BBB";
	private   Element[] elsements =new Element[4];
	
	public  Element get(int i) {
		return elsements[i];
	}
	
	public void add(Element elsement) {
		if(index>=elsements.length) {
			Element[] elsements_temp = Arrays.copyOfRange(elsements, 0,index+1 );
			elsements=elsements_temp;
		}
		elsements[index++]=elsement;
	}
	public int getSize() {
		Object o1 =new Object();
		synchronized(a) {
		int i =elsements.length;
		return i;
		}
	}
	
	
}
