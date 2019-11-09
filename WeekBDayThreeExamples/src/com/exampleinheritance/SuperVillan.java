package com.exampleinheritance;

public class SuperVillan extends SuperHero {


	String alias = "Captain Hindsight";
	/*
	 * shadowing
	 * refers to the practice of using two variable with
	 * same name in overlapping scopes
	 * when you do this, the variable with the higher scope is 
	 * hidden because the variable with the lower scope
	 * 
	 * "shadows it"
	 * 
	 * if you want to access the parent variable's value
	 * from within the child class super.variableName
	 * (and cast it to the parent class)
	 */
	
	public SuperVillan() {
            System.out.println("****In SuperVillan constructor***");	

	}

	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}
	
	@Override
	public String alterWeakness() {
		return weakness = "bananas";
	}
}


