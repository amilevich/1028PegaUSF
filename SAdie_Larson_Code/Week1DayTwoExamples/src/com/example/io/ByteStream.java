package com.example.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class ByteStream {

	public static void main(String[] args) {

		String filename = "./ByteStream.txt";
		writeByteStream(filename);
		readByteStream(filename);
		System.out.println("done");
	}

	public static void writeByteStream(String filename) {
		try (OutputStream os = new FileOutputStream(filename)) { //will automatically overwrite new file
			os.write(65);
			os.write(24);
			os.write(5);
			os.write(142);
			os.write(500); // modular arithmetic --> will go to end then repeat all the way to the begining
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void readByteStream(String filename) {
		try (InputStream is = new FileInputStream(filename)) { // input stream is an abstract class super string of all
																// input streams
			int i;
			while ((i = is.read()) != -1) {
				System.out.println((char)i + " ");
			}
		} catch (IOException somethingOrOther) {
			somethingOrOther.printStackTrace();
		}

	}
}
