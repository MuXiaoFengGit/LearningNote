package com.asiainfo.test;

import java.io.IOException;
import java.lang.management.GarbageCollectorMXBean;
import java.lang.management.ManagementFactory;
import java.util.List;

public class Test {
	
	public static void main(String[] args) {
		List<GarbageCollectorMXBean> l = 
		ManagementFactory.getGarbageCollectorMXBeans(); 
		 for(GarbageCollectorMXBean b : l) { 
			 System.out.println(b.getName()); 
		 } 
		 try {
			 System.in.read();
		 	} catch (IOException e) {
			 e.printStackTrace();
		 	}
		}
	}


class Person{
	String name;
	String pwd;
	int age;
	public Person(String name, String pwd, int age) {
		super();
		this.name = name;
		this.pwd = pwd;
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((pwd == null) ? 0 : pwd.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		if (age != other.age)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (pwd == null) {
			if (other.pwd != null)
				return false;
		} else if (!pwd.equals(other.pwd))
			return false;
		return true;
	}
	
}
