package com.example.inheritance;

public class SuperVillain extends SuperHero{
	
	String alias = "Captain Hindsight";
	
	/*
	 * Shadowing
	 * refers to the practice of using two variables with the 
	 * same name in overlapping scopes
	 * when you do the the variable with the higher scope is 
	 * hidden because the variable with the lower scope
	 * "shadows" it 
	 * 
	 * 
	 * if you want to access the parent variable's value
	 * from within the child class super.varibalename
	 * (and cast it to the parent class)
	 */
	public SuperVillain() {
		System.out.println("******In SuperVillain constructor");
	}

	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}
	
	@Override
	public String alterWeakness() {
		weakness = "bananas";
		return weakness;
	}

}
