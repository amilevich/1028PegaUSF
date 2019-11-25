package com.example.bank;

import java.util.Scanner;
import org.apache.log4j.Logger;
import com.example.utiles.Controller;
import com.example.utiles.Presentation;
import com.example.utiles.Store;

public class MyClass {
	
	final static Logger loggy = Logger.getLogger(MyClass.class);

	public static void main(String[] args) {
		
		String user = "bank", pass = "bank0";
		String url = "jdbc:oracle:thin:@dbtraining.ccdruazatxie.us-east-2.rds.amazonaws.com:1521:orcl";
		
		Scanner sc = new Scanner(System.in);
		Store store = new Store(url, user, pass, loggy);
		Controller controller = new Controller(store, loggy);
		Presentation presentation = new Presentation(controller, loggy, sc);
		presentation.mainPresentation();
	}
}

