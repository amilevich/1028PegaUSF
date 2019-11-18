package com.example.bank;

import java.io.File;
import java.util.Scanner;

import org.apache.log4j.Logger;


import com.example.utiles.Controller;
import com.example.utiles.Presentation;
import com.example.utiles.Store;

public class MyClass {
	
	final static Logger loggy = Logger.getLogger(MyClass.class);

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		File fileaccount = new File("C:\\Users\\Rosy\\Documents\\workspace-sts-3.9.4.RELEASE\\BankMaven\\src\\main\\java\\com\\example\\bank\\account.txt");
		File filecustomer = new File("C:\\Users\\Rosy\\Documents\\workspace-sts-3.9.4.RELEASE\\BankMaven\\src\\main\\java\\com\\example\\bank\\customer.txt");
		Store store = new Store(filecustomer, fileaccount, loggy);
		Controller controller = new Controller(store, loggy);
		Presentation presentation = new Presentation(controller, loggy, sc);
		presentation.mainPresentation();
	}
}

