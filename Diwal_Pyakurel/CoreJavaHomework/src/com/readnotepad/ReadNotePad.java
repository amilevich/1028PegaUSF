package com.readnotepad;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadNotePad {
	public static void main(String[] args) {
		readFile();

	}

	public static void readFile() {

		String s;
		StringBuilder content = new StringBuilder();

		try {
			//Filereader will read the file
			FileReader fr = new FileReader(
					"C:\\Users\\Diwal Pyakurel\\Desktop\\STS Workspace\\CoreJavaHomework\\src\\com\\readnotepad\\notepad.txt");
			//Bufferreader to read the stream of characters
			BufferedReader br = new BufferedReader(fr);

			while ((s = br.readLine()) != null) {
				content.append(s);
				content.append(":");
			}

		} catch (IOException e) {
			e.getStackTrace();
		}

		

		while (content.length() != 0) {
			
			//Strings will be read using susstring till ":" then deleted

			String firstName = content.substring(0, content.indexOf(":"));
			content.delete(0, content.indexOf(":")+1);
			
			String secondName = content.substring(0, content.indexOf(":"));
			content.delete(0, content.indexOf(":")+1);
			
			String age = content.substring(0, content.indexOf(":"));
			content.delete(0, content.indexOf(":")+1);
			
			String state = content.substring(0, content.indexOf(":"));
			content.delete(0, content.indexOf(":")+1);
			

			System.out.println("Name: "+ firstName+" "+secondName);
			System.out.println("Age: "+ age);
			System.out.println("State: "+ state+"\n");

		}
	}

}
