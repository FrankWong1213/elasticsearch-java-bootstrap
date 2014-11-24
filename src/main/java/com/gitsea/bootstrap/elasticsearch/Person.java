package com.gitsea.bootstrap.elasticsearch;

/**
 * @ClassName:     Person.java
 * @Description:   TODO
 * @author         FrankWong
 * @version        V1.0  
 */
public class Person {

	private String name;
	private int age;
	private String address;
	private boolean gender;
	
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public boolean isGender() {
		return gender;
	}
	public void setGender(boolean gender) {
		this.gender = gender;
	} 
}
