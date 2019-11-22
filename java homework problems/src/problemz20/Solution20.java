package problemz20;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList; 

public class Solution20 {
	
	public static void main(String[] args) throws IOException {
		  File file = new File("C:\\Users\\USER\\Desktop\\lecture codes\\java homework problems\\src\\problemz20\\Data.txt");
		  String s = null;
		  String[] array;
		  ArrayList<String> arraylist = new ArrayList<>(); 
		  BufferedReader reader = new BufferedReader(new FileReader(file));
		  for (s=reader.readLine(); s!=null; s=reader.readLine()){
			  arraylist.add(s);
		  }
		  for(String i : arraylist) {
			  array = i.split(":");
			  System.out.println("\nName: " + array[0] + " " + array[1] + " \nAge: " + array[2] + "\nState: " + array[3] );
		  }
		  reader.close(); 
	}
}
