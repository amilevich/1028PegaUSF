package com.projects.corejavahomework;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CharacterStream {
	
	/*
	 * I/O - input/output
	 * 
	 * Character Stream - human readable text -> FileWriter & FileReader
	 * Byte Stream - machine readable, byte code -> FileOutputStream & FileInputStream
	 * 
	 * For large chunks of data vs one character at a time we have:
	 * BufferedReaders and BufferedWriter for character stream
	 * BufferedInputStream and BufferedOutputStream for byte stream
	 */

	public static void main(String[] args) {
		String filename = "./CharExample2.txt";
		readCharacterStream(filename);
		writeCharacterStream(filename);
		System.out.println("done");
	}
	
	public static void writeCharacterStream(String filename) {
		try(FileWriter writer = new FileWriter(filename, false)){
		//false - would create a new file each time
		//true - appends to the existing file
		for(int i = 65; i<72; i++) { //ASCII values for A-G
			writer.write(i);
		}
			
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void readCharacterStream(String filename) {
		try(FileReader reader = new FileReader(filename)){
			int i;
			while((i = reader.read()) != -1) {
				System.out.print((char)i); 
				//explicit type casting, converting an int to a character
			}
		}catch(IOException ioe) {
			ioe.printStackTrace();
		}
	}
	
	

}
