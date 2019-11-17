package com.frontend;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
public class MyClass
{
	public static void main(String [] args)
	{
		Map<String, Account> hmap = new HashMap<String, Account>();
		//Adding elements to HashMap
//		hmap.put(11, "AB");
//		hmap.put(2, "CD");
//		hmap.put(33, "EF");
//		hmap.put(9, "GH");
//		hmap.put(3, "IJ");
		hmap.put("1", new Account("apple","apple","iD",0.0));
		hmap.put("2", new Account("true","asdf","asdfpasd",100.0));
		try
		{
			FileOutputStream fos =
					new FileOutputStream("hashmap.ser");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(hmap);
			oos.close();
			fos.close();
			System.out.printf("Serialized HashMap data is saved in hashmap.ser");
		}catch(IOException ioe)
		{
			ioe.printStackTrace();
		}
	}
}
