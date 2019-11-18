package com.example.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class ByteStream {

	public static void main(String[] args) {
		
		String filename = "./Bytefile.txt";
		writeByteStream(filename);
		readByteStream(filename);
		System.out.print(" I  am done");

	}
	
	public static void writeByteStream(String filename) {
		
		try(OutputStream os = new FileOutputStream(filename)){
			
			os.write(65);
			os.write(24);
			os.write(5);
			os.write(142);
			os.write(500);
			
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void readByteStream(String filename) {
		try(InputStream is = new FileInputStream(filename)){
			
			int i;
			while((i = is.read())!=-1) {
				System.out.print(i + "");
			}
			
		}catch (IOException somethingOrOther) {
			somethingOrOther.printStackTrace();
		}
	}

}
