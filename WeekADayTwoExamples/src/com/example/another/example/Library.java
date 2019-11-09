package com.example.another.example;

public class Library {
	
	public static void main(String[] args) {
		
		Book book1 = new Book();
	
	
		
		//calling the Book's methods
		Book.releasedDay();// calling the method released day
		
		Book obj = new Book();// calling the method owner
		obj.owner();
		
		Book.Cost();// calling the method cost
		System.out.println("cost of book" + book1.getCost());
		
		Book obj1 = new Book();// calling the method name
		obj1.name();
		
		Book obj2 = new Book();//calling the numOfPages method
		obj2.pages();
		
		Book [] myBooks = {book1};// an array type myBooks
		
		for(int b = 0; b < myBooks.length; b++) {
			System.out.println(myBooks[b]);
		}


	}

}
