package com.homework.algorthim;

import java.io.FileReader;
import java.io.IOException;

public class Q20 {

	// *******************************************************************************************************************
	public void readCharacterStream(String filename) {
		try(FileReader reader = new FileReader(filename)){
			String temp ="";
			char i;
			while((i = (char) reader.read()) != -1) {
				temp+=i;
				if(i == '\n') {
					String[] arr = temp.split(":");
					System.out.println("Name: " + arr[0]+ " " + arr[1]+ "\n Age: " + arr[2] + " Years"+ "\n State: " + arr[3] +" state");
					temp = "";
				}
			}
		}catch(IOException ioe) {
			ioe.printStackTrace();
		}
	}

}
