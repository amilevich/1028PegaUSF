package reveture.home.work;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

		public class CityCafe {

public CityCafe() {
	
}
	 public static double itemPrice;
	 public static double totalAmount;
	 static boolean order = true;
	  static Scanner input = new Scanner(System.in);
	   static Queue<String>DrinkOrder= new LinkedList<>();
		static Queue<String>FoodOrder = new LinkedList<>();

		  public static void menu(){
			  System.out.println("Welcome to CityCafe ! \n Please enter the number you want to order \n1. Burger ($4.50) \n2. Soda ($1.50)\n3.Fench Fries ($1.50)\n4.Donat ($1.99)\n5.Pizza($8.50) \n6. Done ");
		   }
		   public static double itemPrice(int foodItem) {
		      if (foodItem == 1) {
		        //burger= $4.50
		         System.out.println("You have ordered a Burger");
		         itemPrice = 4.50;
		      }
		      if (foodItem == 2) {  
		        //Soda = $1.99
		         System.out.println("You have ordered Soda ");
		         itemPrice = 1.99;
		      }
		      if (foodItem == 3) {
		        //fries = $1.50
		         System.out.println("You have ordered French Frie");
		         itemPrice = 1.50;
		      }
		      if (foodItem == 4) {
		        //Donat = $1.50
		         System.out.println("You have ordered Donat");
		         itemPrice = 1.50;
		      }
		      if (foodItem == 5) {
		        //Pizza = $8.50
		         System.out.println("You have ordered Pizza");
		         itemPrice = 8.50;
		      }
		      quantity();
		      return itemPrice;
		   }
		   public static double quantity() {
		      System.out.println("Enter quantity");       
		      double quantity = input.nextDouble();
		      subTotal(quantity, itemPrice);
		      return quantity;
		   }
		   public static double subTotal(double quantity, double Price) {
		      double subTotal = quantity*Price;
		      System.out.println("Subtotal: $ " + subTotal);
		      totalAmount += (subTotal );
		      return subTotal;
		   }
		   public static void done(){
		      order = false;
		      System.out.println(totalAmount );
		      System.out.println("Enjoy your Food !!");
		   }
		   public static void main(String[] args) {
			  
			     /* System.out.println("Burger" +FoodOrder);
			      System.out.println("Soda "+DrinkOrder);
			      System.out.println("Fries" +FoodOrder);
			      System.out.println("Donat" +FoodOrder);
			      System.out.println("Donat" +FoodOrder);*/
		      int menuOption;
		      int foodItem = 0;
		      input = new Scanner(System.in); 
		      do{
		         double totalAmount=0;
		         menu(  );
		         menuOption = input.nextInt();    
		         switch(menuOption){
		            case 1:
		               foodItem = 1;
		               itemPrice(foodItem);
		               break;
		            case 2:
		               foodItem = 2;
		               itemPrice(foodItem);
		               break;
		            case 3:
		               foodItem = 3;
		               itemPrice(foodItem);
		               break;
		            case 4:
		               foodItem = 4;
		               itemPrice(foodItem);
		               break;
		            case 5:
		               foodItem = 5;
		               itemPrice(foodItem);
		               break;
		            case 6:
		               done();
		               break;      
		            default:
		               System.out.println("Invalid Option");
		         }
		      
		      } while(order); 
		      {
		         System.out.println("Total amouunt " + totalAmount);
		      }
		   
		   }
		}
		
	

