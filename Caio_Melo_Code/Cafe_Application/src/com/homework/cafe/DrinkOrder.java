package com.homework.cafe;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Scanner;

public class DrinkOrder {

	LinkedList<String> drinksList = new LinkedList<String>();
	private String coffee = "coffee";
	private String decafeCoffee = "decafCoffee";
	private String espresso = "espresso";
	private String latte = "latte";
	private String cappuccino = "cappuccino";
	private String machiato = "machiato";
	private String tea = "tea";
	private String orangeJuice = "orangeJuice";
	private String appleJuice = "appleJuice";
	private String cranberryJuice = "cranberryJuice";
	private String water = "water";

	public DrinkOrder() {

	}

	public LinkedList<String> getDrinks() {
		return drinksList;
	}

	public void setDrinks(LinkedList<String> drinks) {
		this.drinksList = drinks;
	}

	public String getCoffee() {
		return coffee;
	}

	public void setCoffee(String coffee) {
		this.coffee = coffee;
	}

	public String getDecafeCoffee() {
		return decafeCoffee;
	}

	public void setDecafeCoffee(String decafeCoffee) {
		this.decafeCoffee = decafeCoffee;
	}

	public String getEspresso() {
		return espresso;
	}

	public void setEspresso(String espresso) {
		this.espresso = espresso;
	}

	public String getLatte() {
		return latte;
	}

	public void setLatte(String latte) {
		this.latte = latte;
	}

	public String getCappuccino() {
		return cappuccino;
	}

	public void setCappuccino(String cappuccino) {
		this.cappuccino = cappuccino;
	}

	public String getMachiato() {
		return machiato;
	}

	public void setMachiato(String machiato) {
		this.machiato = machiato;
	}

	public String getTea() {
		return tea;
	}

	public void setTea(String tea) {
		this.tea = tea;
	}

	public String getOrangeJuice() {
		return orangeJuice;
	}

	public void setOrangeJuice(String orangeJuice) {
		this.orangeJuice = orangeJuice;
	}

	public String getAppleJuice() {
		return appleJuice;
	}

	public void setAppleJuice(String appleJuice) {
		this.appleJuice = appleJuice;
	}

	public String getCranberryJuice() {
		return cranberryJuice;
	}

	public void setCranberryJuice(String cranberryJuice) {
		this.cranberryJuice = cranberryJuice;
	}

	public String getWater() {
		return water;
	}

	public void setWater(String water) {
		this.water = water;
	}
	
	public String toString() {
		
		if(drinksList.isEmpty()) {
			return "";
		}
		else {
		String temp = "Drinks: [";
		for(String x:drinksList) {
			temp += x + ", ";
		}
		temp = temp.substring(0,temp.lastIndexOf(','));

		temp += "]";
		return temp;
		}
	}

}
