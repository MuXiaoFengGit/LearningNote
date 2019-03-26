package com.asiainfo.test;

import java.util.HashSet;
import java.util.Set;

public class Test {
	
	public static void main(String[] args) {
		Set<Person> set = new HashSet<Person>();
		Person p1 = new Person("唐僧","pwd1",25);
		Person p2 = new Person("孙悟空","pwd2",26);
		Person p3 = new Person("猪八戒","pwd3",27);
		set.add(p1);
		set.add(p2);
		set.add(p3);
		System.out.println("总共有:"+set.size()+" 个元素!"); //结果：总共有:3 个元素!
		p3.setAge(2); //修改p3的年龄,此时p3元素对应的hashcode值发生改变

		set.remove(p3); //此时remove不掉，造成内存泄漏

		set.add(p3); //重新添加，居然添加成功
		System.out.println("总共有:"+set.size()+" 个元素!"); //结果：总共有:4 个元素!
		for (Person person : set)
		{
		System.out.println(person);
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
