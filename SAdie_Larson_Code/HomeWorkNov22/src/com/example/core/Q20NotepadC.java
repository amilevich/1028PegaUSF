package com.example.core;

import java.io.Serializable;

public class Q20NotepadC implements Serializable{

	private static final long serialVersionUID = 1L;
	public  String name;
	public String type;
	public int age;
	public String state;
	
	
	public Q20NotepadC(String name, String type, int age, String state) {
		super();
		this.name = name;
		this.type = type;
		this.age = age;
		this.state = state;
	}
	
	
}
