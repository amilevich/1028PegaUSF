package com.exampleinheritance;

public class SuperHero {

	private Boolean hasCape = true;
	private String name = "BlankMan";
	private String ability = "Blank people's minds";
	 String alias = "Bob Ross";
	 String weakness = "Mistakes";
	
	
	public SuperHero() {
		System.out.println("****In SuperHero constructor*****");
	}


	public SuperHero(Boolean hasCape, String name, String ability, String alias, String weakness) {
		super();
		this.hasCape = hasCape;
		this.name = name;
		this.ability = ability;
		this.alias = alias;
		this.weakness = weakness;
	}
	public SuperHero(String s) {
		System.out.println("*** In SuperHero constructor (String)");
	}


	public Boolean getHasCape() {
		return hasCape;
	}


	public void setHasCape(Boolean hasCape) {
		this.hasCape = hasCape;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getAbility() {
		return ability;
	}


	public void setAbility(String ability) {
		this.ability = ability;
	}


	public String getAlias() {
		return alias;
	}


	public void setAlias(String alias) {
		this.alias = alias;
	}


	public String getWeakness() {
		return weakness;
	}


	public void setWeakness(String weakness) {
		this.weakness = weakness;
	}


	@Override
	public String toString() {
		return "SuperHero [hasCape=" + hasCape + ", name=" + name + ", ability=" + ability + ", alias=" + alias
				+ ", weakness=" + weakness + "]";
	}
	
	public String alterWeakness() {
		
		return weakness = "wearing capes";
	}
	
}
