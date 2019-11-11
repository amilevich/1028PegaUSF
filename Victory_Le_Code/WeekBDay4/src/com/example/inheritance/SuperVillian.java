package com.example.inheritance;

public class SuperVillian extends SuperHero{

	String alias = "Captain Hindsight";
	
	public SuperVillian() {
		System.out.println("***********In SuperVillian Constructor**********");
	}

	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}
	
}
