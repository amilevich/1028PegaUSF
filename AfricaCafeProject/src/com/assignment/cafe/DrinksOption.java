package com.assignment.cafe;

import java.util.Scanner;

public class DrinksOption extends MenuOption {
	
	public String drinkOption[] = new String[9];
    private double price = 2.00;  
    
//    public DrinksOption(String drinkOption[], double price) { 
//    	
//    	
//    }
    
    DrinksOption() { 
    this.drinkOption = drinkOption; 
    System.out.println("********************Drinks*************************");
    
    

           drinkOption [0] = "fanta";
           drinkOption[1] = "ice tea";
           drinkOption[2] = "dr.peppe";
           drinkOption[3] = "coca cola";
           drinkOption[4] = "sprite";
           drinkOption[5] = "orange juice";
           drinkOption[6] = "strawberry juice";
           drinkOption[7] = "pepsi";
           drinkOption[8] = "strawberry fanta";
          
    
 
    for(int i = 0; i < drinkOption.length; i++) {
    	int value = i + 1;
    	
    	System.out.println("choice" + value + ": " + drinkOption[i]);
       }		
     	 
     }
        
  @override  
 
   public String toSptring() {
	 
    return  "drinkOption [fanta=" + "ice tea=" + "dr peppe=" + "coca cola=" + "Sprite=" + "orange juice=" + "Strawberry juice=" + "pepsi=" + "Strawberry fanta=";  
 
  } 
 
 
   public String[] getDrinkOption() {
	return drinkOption;
}

   public void setDrinkOption(String[] drinkOption) {
	this.drinkOption = drinkOption;
}

   public double getPrice() {
	return price;
}

   public void setPrice(double price) {
	this.price = price;
}

}


