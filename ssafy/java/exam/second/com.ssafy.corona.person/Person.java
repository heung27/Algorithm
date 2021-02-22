package com.ssafy.corona.person;

import java.io.Serializable;

public class Person implements Serializable {
	private String name;
	private int age;
	private String phone;
	
	public Person() {}
	public Person(String name, int age, String phone) {
		setName(name);
		setAge(age);
		setPhone(phone);
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	@Override
	public String toString() {
		StringBuilder sb=new StringBuilder();
		sb.append(getName()).append("\t")
		  .append(getAge()).append("\t")
		  .append(getPhone());
		return sb.toString();
	}
}
