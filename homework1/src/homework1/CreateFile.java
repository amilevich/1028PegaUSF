package homework1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class CreateFile {
	
		
		public  void readc() {
			BufferedReader reader = null;
			try {//  try catch because reading the file
				// to read the file from my file path
				reader = new BufferedReader(new FileReader("C:\\Users\\leroy\\Documents\\workspace-sts-3.9.4.RELEASE\\homework1\\src\\homework1\\Data.txt"));
				String text;  
				while ((text = reader.readLine()) != null) { //while reading the file and it is not empty

					String[] myFileData = text.split(":");// store my text
					//printing out the format with system outputs
					System.out.println("Name: " + myFileData[0] + " " + myFileData[1]);
					System.out.println("Age: " + myFileData[2] + " years");
					System.out.println("State: " + myFileData[3] + " State");
					System.out.println("\n");
				}
			} catch (IOException ex) {
				ex.printStackTrace();
			} finally {
				if (reader != null) {
					try {
						reader.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		}
}
		
	


