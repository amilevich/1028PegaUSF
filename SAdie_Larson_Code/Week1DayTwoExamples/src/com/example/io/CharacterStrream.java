package com.example.io;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CharacterStrream {

	/*
	 * I/O: Input / Output
	 * 
	 * Character stream: human readable text -> FileWriter & FileReader Byte Stream:
	 * machine readable, byte code -> FileOutputStream & FileInputStream
	 * 
	 * For large chunks of data vs one character at a time we have: BufferredReadrs
	 * and bufferWriter for character stream BufferredInputStream and
	 * bufferredOutputStream for byte stream
	 */

//	public static void main(String[] args) {
//		String filename = "./charExample.txt";
//		writeCharacterStream(filename);
//		readCharacterStream(filename);
//		System.out.println("done");
//	}
//
//	public static void writeCharacterStream(String filename) {
//		try (FileWriter writer = new FileWriter(filename, true)) {
//			// false would create a new file each time
//			// true would append to the existing file
//			// write
//			for (int i = 65; i < 72; i++) { //these are ASCII values for A-G
//				writer.write(i);
//			}
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//
//	}
//
//	public static void readCharacterStream(String filename) {
//		try (FileReader reader = new FileReader(filename)) {
//			int i;
//			while ((i = reader.read()) != -1) {
//				System.out.print((char) i);
//				// explicitly type casting an int to a character
//			}
//		} catch (IOException ioe) {
//			ioe.printStackTrace();
//		}
//	}
	public static void main(String[] args) {
		String filename = "./charExample2.txt";
		writeCharacterStream(filename);
		readCharacterStream(filename);
		System.out.println("done");
	}

	public static void writeCharacterStream(String filename) {
		try (FileWriter writer = new FileWriter(filename, true)) {
			// false would create a new file each time
			// true would append to the existing file
			// write
			for (int i = 65; i < 72; i++) { //these are ASCII values for A-G
				writer.write(i);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void readCharacterStream(String filename) {
		try (FileReader reader = new FileReader(filename)) {
			int i;
			while ((i = reader.read()) != -1) {
				System.out.print(i);
				// explicitly type casting an int to a character
			}
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}

}
