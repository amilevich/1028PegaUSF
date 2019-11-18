package com.examples.p0;
/*package com.examples.p0;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class InputOutput {

	public static void main(String[] args) {
		String filename = "./sampleObjectFile.txt";
		writeObject(filename, Customer.accounts);
		readObject(filename);
		System.out.println("done");
	}
	
	public static void writeObject(String filename, Object obj) {
		try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))){
			oos.writeObject(obj);
			
		}catch(IOException io) {
			io.printStackTrace();
		}
	}
	
	public static void readObject(String filename) {
		try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))){
			System.out.println(ois.readObject());
		}catch(IOException exception) {
		exception.printStackTrace();
		}catch(ClassNotFoundException anything) {
			anything.printStackTrace();
		}
	}	
	
}
*/