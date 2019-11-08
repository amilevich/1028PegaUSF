package com.example.inheritance;

public class SuperHero {
	private Boolean hasCape = true;
	private String name = "BlankMan";
	private String ability = "Blank people's minds";
	 String alias = "Bob Ross";
	String weakness = "Mistakes";
	public SuperHero() {
		System.out.println("****In Super Hero constructor");
	}
	public SuperHero(Boolean hasCape, String name, String ability, String alias, String weaknes) {
		super();
		this.hasCape = hasCape;
		this.name = name;
		this.ability = ability;
		this.alias = alias;
		this.weakness = weaknes;
	}
	public SuperHero(String s) {
		System.out.println("*************In Superhero constructor(string)");
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
	public String getWeaknes() {
		return weakness;
	}
	public void setWeaknes(String weaknes) {
		this.weakness = weaknes;
	}
	@Override
	public String toString() {
		return "SuperHero [hasCape=" + hasCape + ", name=" + name + ", ability=" + ability + ", alias=" + alias
				+ ", weaknes=" + weakness + "]";
	}
	
	public String alterWeakness() {
		return weakness = "wearin capes";
	}
	
	
}
