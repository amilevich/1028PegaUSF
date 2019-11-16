package com.example.io;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CharacterStream {

	
	/*
	 * I/O - input/output
	 * 
	 * Character Stream - human readable text -> FileWriter & FileReader
	 * Byte Stream - machine readable , byte code -> FileOutputStream and FileInputStream
	 * 
	 * For Large chunks of data vs one character at a time we have:
	 * BufferedReaders and BufferWriter for character stream
	 * BufferedInputStream and BufferedOutputStream for byte stream
	 * 
	 */
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String filename = "./CharExample.txt";
		writeCharacterStream(filename);
		reachCharacterStream(filename);
		System.out.println("done");
	}

	// Write Character Stream 
	public static void writeCharacterStream(String filename) {
		try(FileWriter writer = new FileWriter(filename, true)){
			
		//false - would create a new file each time 
		//true - appends to the existing file
		
		//Exception - a mistake or problem that is internal to your application
			
		for (int i =65; i<72; i++) {
			writer.write(i);
		}
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	// Read Character Stream 
	public static void reachCharacterStream(String filename) {
		try(FileReader reader = new FileReader(filename)){
			int i;
			while((i=reader.read())!= -1) {
				System.out.println((char)i);
			}
			}catch(IOException ioe) {
				ioe.printStackTrace();
			}
			
		}
	}
