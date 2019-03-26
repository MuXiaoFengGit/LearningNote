package com.asiainfo.test;

import java.util.HashSet;
import java.util.Set;

public class Test {
	
	public static void main(String[] args) {
		Set<Person> set = new HashSet<Person>();
		Person p1 = new Person("��ɮ","pwd1",25);
		Person p2 = new Person("�����","pwd2",26);
		Person p3 = new Person("��˽�","pwd3",27);
		set.add(p1);
		set.add(p2);
		set.add(p3);
		System.out.println("�ܹ���:"+set.size()+" ��Ԫ��!"); //������ܹ���:3 ��Ԫ��!
		p3.setAge(2); //�޸�p3������,��ʱp3Ԫ�ض�Ӧ��hashcodeֵ�����ı�

		set.remove(p3); //��ʱremove����������ڴ�й©

		set.add(p3); //������ӣ���Ȼ��ӳɹ�
		System.out.println("�ܹ���:"+set.size()+" ��Ԫ��!"); //������ܹ���:4 ��Ԫ��!
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
