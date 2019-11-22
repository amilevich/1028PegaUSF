package com.homework.qtwenty;

import java.io.FileReader;
import java.io.IOException;

public class Qtwenty {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String filename = "./Data.txt";
		readCharacterStream(filename);

		


	}

	public static void readCharacterStream(String filename) {
		try(FileReader reader = new FileReader(filename)){
			int i;
			String temp = "";
			while((i = reader.read()) != -1) {
				if ((char)i != '\n') {
					temp += (char)i;
				}else {
			     String[] stringArr = temp.split(":", 4);
				System.out.println("Name: " + stringArr[0] + " " + stringArr[1]);
				System.out.println("Age: " + stringArr[2] + " years");
				System.out.println("State: " + stringArr[3] + "State");
				temp = "";
				}
			}
		}catch(IOException ioe) {
			ioe.printStackTrace();
		}
	}
}
