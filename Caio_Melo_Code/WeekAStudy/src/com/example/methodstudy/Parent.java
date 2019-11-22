package com.example.methodstudy;

public class Parent extends Human{

	protected int age;
	private String name;
	boolean hello;
	
	
	Parent(){
		
	}
	
	Parent(int x,String y, boolean z){
		
		this.age = x;
		this.name = y;
		this.hello = z;
		
	}
	
	public void eat() {
		
	}
	
	public int getAge() {
		return age;
	}
	public void setAge(int a) {
		this.age = a;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean isHello() {
		return hello;
	}
	public void setHello(boolean hello) {
		this.hello = hello;
	}
	
	
}
