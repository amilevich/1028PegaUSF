package src.Question20;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/*
 * Create a notepad file called Data.txt and enter the following: 
Mickey:Mouse:35:Arizona
Hulk:Hogan:50:Virginia
Roger:Rabbit:22:California
Wonder:Woman:18:Montana

Write a program that would read from the file and print it out to the screen in the following format:

Name: Mickey Mouse
Age: 35 years
State: Arizona State

 */
public class MyClass {

	public static void main(String[] args) throws IOException {
        BufferedReader reader = null;
        try{
            reader = new BufferedReader(new FileReader("src/question20.txt")); //reading data from the .txt file
            String line;
            while((line = reader.readLine()) != null){

                String[] data = line.split(":");

                System.out.println("Name: "+data[0]+" "+data[1]); //Outputting the data for the correct format 
                System.out.println("Age: "+ data[2]+" years");
                System.out.println("State: "+ data[3]+" State");
                System.out.println("\n");
            }
        }catch(IOException ex){
            ex.printStackTrace();
        }finally{
            if(reader != null){
                reader.close();
            }
        }
    }
}
