package com.example.another.example;

public class Book {
	
	String name = "Java for beginners";
	String authorName = "Cristian Adon";
	int numOfPages = 200;
	double cost = 150;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAuthorName() {
		return authorName;
	}
	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}
	public int getNumOfPages() {
		return numOfPages;
	}
	public void setNumOfPages(int numOfPages) {
		this.numOfPages = numOfPages;
	}
	
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
	
	
	public static void releasedDay() {
		
		System.out.println("This book was released on the 10/1/19");
	}
	
	public void owner() {
		
		System.out.println("This book is owned by the author: " + authorName);
	}
	
	public void name() {
		
		System.out.println("The name of this book is : " +  name);
	}
	
	public void pages() {
		System.out.println("This book contains :" + numOfPages + " number of pages" );
	}
	
// varargs method
     public static void Cost(double ...c) {
    	 //array -> string or iterate through an array
		System.out.println("The cost for this books is: " + "$" +  c);
		//how to print an array
	}
	@Override
	public String toString() {
		return "Book [name=" + name + ", authorName=" + authorName + ", numOfPages=" + numOfPages + ", cost=" + cost
				+ "]";
	}
     
     
	
}
