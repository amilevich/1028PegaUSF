package com.example.bank;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Date;

public class Test {

	
	public class BasicSerializationExample {
	    static final String filePath = "user.ser";
	     
	    static void serialize(User user) {
	        try {
	            FileOutputStream fos = new FileOutputStream(filePath);
	            ObjectOutputStream outputStream = new ObjectOutputStream(fos);
	            outputStream.writeObject(user);
	            outputStream.close();
	        } catch (IOException ex) {
	            System.err.println(ex);
	        }
	    }
	     
	    static User deserialize() {
	        User savedUser = null;
	         
	        try {
	            FileInputStream fis = new FileInputStream(filePath);
	            ObjectInputStream inputStream = new ObjectInputStream(fis);
	            savedUser = (User) inputStream.readObject();
	            inputStream.close();
	        } catch (IOException | ClassNotFoundException ex) {
	            System.err.println(ex);
	        }
	         
	        return savedUser;
	    }
	     
	    public static void main(String[] args) {
	        String username = "codejava";
	        String email = "info@codejava.net";
	        String password = "secret";
	        Date birthDay = new Date();
	        int age = 20;
	         
	        User newUser = new User(username, email, password, birthDay, age);
	         
	        serialize(newUser);
	 
	        User savedUser = deserialize();
	         
	        if (savedUser != null) {
	            savedUser.printInfo();
	        }
	    }
}
