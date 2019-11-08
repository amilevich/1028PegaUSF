package com.example.inheritance;

public class SuperVillain extends SuperHero {
	 String alias = "Captain Hindight";
	
	public SuperVillain() {
		System.out.println("*********IN suuperVillain constructor");
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
