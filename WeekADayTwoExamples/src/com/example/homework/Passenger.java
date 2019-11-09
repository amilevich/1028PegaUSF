package com.example.homework;

 class Passenger {
	
	private String name= "Jose";
	int age = 50;
	boolean hasArrived = true;
	
	
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
	public boolean isHasArrived() {
		return hasArrived;
	}
	public void setHasArrived(boolean hasArrived) {
		this.hasArrived = hasArrived;
	}
	
	
	public static void money(int ...m) {
		
		System.out.println("Amount of money paid for the ride: " + "$" +  m.length);
	}
	
	public static void staticMethod() {
		System.out.println("This is my Static method");
	}
	
	public static void anotherStaticMethod() {
		System.out.println("This is another static method");
	}
	@Override
	public String toString() {
		return "Passenger [name=" + name + ", age=" + age + ", hasArrived=" + hasArrived + "]";
	}
	
	

}
