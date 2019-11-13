package com.example.io;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CharacterStream {
	
	/*
	 *  I/O - input/output
	 *  
	 *  Character Stream - human readable text -> FileWriter & FileReader
	 *  Byte Stream - machine readable, byte code -> FileOutputStream & FileInputStream
	 *  
	 *  For large chunks of data vs one char at a time:
	 *  BufferReaders and BufferWriter for char stream
	 *  BufferInputStream and BufferedOutputStream for byte stream
	 * 
	 */

	public static void main(String[] args) {
		String filename = "./CharExample.txt"; //default into project folder or specify folder destination
		writeCharacterStream(filename);
		readCharacterStream(filename);
		
		System.out.println("Done");
	}
	public static void writeCharacterStream(String filename) {
		try(FileWriter writer = new FileWriter(filename, true)){// false - create new file / true - appends to existing file
		for(int i = 65; i <72; i++) {//ASCII values for A-G
			writer.write(i);
		}
		}catch(IOException e) {
			e.printStackTrace();// prints red text
		}
	}
	
	public static void readCharacterStream(String filename) {
		try(FileReader reader = new FileReader(filename)){
			int i;
			while((i = reader.read()) != 1) {
				System.out.print((char)i);//explicit type casting, converting an int to a char
			}
		}catch(IOException ioe) {
			ioe.printStackTrace();
		}
	}
}
