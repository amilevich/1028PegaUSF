package com.Driver;

import java.util.ArrayList;

import com.Methods.Methods;
import com.profiles.Customers;

public class Driver {

	public static void main(String[] args) {
		
		System.out.println("Welcome to Bank");
		String userStatus = Methods.startApplication();
		
		if(userStatus.equals("customer")) { 
			String newOrOld = Methods.askifNew();
			if(newOrOld.equals("new")) {
				Methods.openAccount();
			}else if(newOrOld.equals("existing")) {
				// Provide the logic if old
			}
		} else if(userStatus.equals("admin")) {
			Methods.adminOptions();
		}

	}

}
