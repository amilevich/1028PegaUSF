package com.example.inheritance;

public class SuperHero {

	private Boolean hasCApe = true;
	private String name = "BlankMan";
	private String ability = "Blank people's minds";
	 String alias = "Bob Ross";
	public String weakness = "Mistakes";
	
	public SuperHero() {

		System.out.println("******In SuperHero constructor");
	}

	public SuperHero(boolean hasCApe, String name, String ability, String alias, String weakness) {
		super();
		this.hasCApe = hasCApe;
		this.name = name;
		this.ability = ability;
		this.alias = alias;
		this.weakness = weakness;
		System.out.println("******In SuperHero constructor of all ");
	}

	public SuperHero(String name) {
		super();
		this.name = name;
		System.out.println("******In SuperHero constructor(String)");
	}

	public Boolean getHasCApe() {
		return hasCApe;
	}

	public void setHasCApe(Boolean hasCApe) {
		this.hasCApe = hasCApe;
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

	@Override
	public String toString() {
		return "SuperHero [hasCApe=" + hasCApe + ", name=" + name + ", ability=" + ability + ", alias=" + alias
				+ ", weakness=" + weakness + "]";
	}
	
	
	public String alterWeakness() {
		weakness = "weraing capes";
		return weakness;
	}
}
