package com.assignment.classes;

public class MyBeans {
	
	private boolean isCooked;
	private int numOfBeans;
	private String name;
	
	MyBeans(){
		
	}
	
	public MyBeans(boolean isCooked, int numOfBeans, String name) {
		this.isCooked = isCooked;
		this.numOfBeans = numOfBeans;
		this.name = name;
		
	}

	public boolean isCooked() {
		return isCooked;
	}

	public void setCooked(boolean isCooked) {
		this.isCooked = isCooked;
	}

	public int getNumOfBeans() {
		return numOfBeans;
	}

	public void setNumOfBeans(int numOfBeans) {
		this.numOfBeans = numOfBeans;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		//return "MyBeans isCooked=" + isCooked + ", there are " + numOfBeans + " beans, " + name + " will be served";
		return this.getName();
	}
	
	public static void Cooking() {
		System.out.println("Beans are cooking");
	}
	
	public void Bean(String s, int...a) {
		System.out.println("I also have " + s);
		System.out.println("#" + a.length);
	}
	
	public void Price() {
		int Price = this.numOfBeans*2;
		System.out.println(Price);
	}
	


}
