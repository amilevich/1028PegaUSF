package com.assignment.classes;

import java.util.Arrays;

public class MyDriver {
	
	
	
	public static void main(String[] args) {
		
		MyBeans Pinto = new MyBeans(true, 7, "Pinto");
		MyBeans BlackBeans = new MyBeans (false, 3, "Black Beans");
		
		MyBeans RedBeans = new MyBeans();
		RedBeans.setCooked(true);
		RedBeans.setNumOfBeans(21);
		RedBeans.setName("Red Beans");
		
		System.out.println(Pinto);
		System.out.println(BlackBeans);
		System.out.println(RedBeans);
		MyBeans.Cooking();
		Pinto.Bean("Coffee Beans", 3);
		
		Pinto.Price();
		
		MyBeans beanArray[] = new MyBeans[3];
		beanArray[0] = Pinto;
		beanArray[1] = BlackBeans;
		beanArray[2] = RedBeans;
		
		for(int b = 0; b<beanArray.length; b++) {
			System.out.println(beanArray[b]); 
		}
		
	
		
		
	}
}
