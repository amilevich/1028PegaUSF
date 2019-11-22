package com.homework;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.LinkedList;
import java.util.Scanner;

public class FileIO20 {

	public static void main(String[] args) 
	{

		FileIO20 io = new FileIO20();
		String file = "Data.txt";
		io.openFile(file);
		io.readFile();
		io.printFile();
		io.closeFile();

	}
	
	LinkedList<Record> records = new LinkedList<Record>();
	File file = null;
	Scanner sc = null;
	
	void openFile(String _file)
	{
		file = new File(_file);
//		System.out.println(file.getAbsolutePath());
	}
	
	void closeFile()
	{
		if(sc != null)
			sc.close();
	}
	
	void readFile()
	{
		if(file != null)
		{
//			System.out.println("file not null");
//			if(file.exists())
//			System.out.println("reading file " + file.getName());
			Scanner sc = null;
			try {
				BufferedReader reader = new BufferedReader(new FileReader(file.getAbsoluteFile()));
				sc = new Scanner(reader);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			finally
			{
//				System.out.println("finally");
				while(sc.hasNextLine() && sc != null)
				{
					String temp = sc.nextLine();
					//break up the line to build the record
					String[] data = temp.split(":");
					if(4 == data.length)
					{
						records.add(new Record(data[0]+' '+data[1],Integer.parseInt(data[2]),data[3]));
					}
				}
			}
		}
	}
	
	void printFile()
	{
		for(int i = 0; i < records.size(); i++)
			System.out.println(records.get(i).toString() + '\n');
	}
	
	protected void finalize()
	{
		closeFile();
	}

}

class Record
{
	String name;
	int age;
	String state;
	

	
	public Record(String name, int age, String state) {
		super();
		this.name = name;
		this.age = age;
		this.state = state;
	}
	
	
	@Override
	public String toString() {
		return new String("Name: " + name + "\nAge: " + age + "\nState: " + state);
	}


	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	
}
