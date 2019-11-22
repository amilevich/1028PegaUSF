package com.homework;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Switch14 
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter number between 1 - 3: ");
		int input = Integer.MIN_VALUE;
		do
		{
			try
			{
				input = sc.nextInt();
			}
			catch(InputMismatchException e)
			{
				System.out.println("Enter number between 1 - 3: ");
			}
			finally
			{
				sc.nextLine();
			}
		} while(input == Integer.MIN_VALUE);
		Switch14.doStuff(input);
		
		//Shutting down.. close scanner
		sc.close();
	}
	
	static void doStuff(int _input)
	{
		//Q14. Write a program that demonstrates the switch case. Implement the following functionalities in the cases:
		//Case 1: Find the square root of a number using the Math class method. 
		//Case 2: Display today’s date.
		//Case 3: Split the following string and store it in a string array. 
		//		“I am learning Core Java”
		switch(_input)
		{
			case 1:
				Scanner scan = new Scanner(System.in);
				System.out.println("Enter any number over zero");
				double data = Double.MIN_VALUE;
				do
				{
					try
					{
						data = scan.nextInt();
					}
					catch(InputMismatchException e)
					{
						System.out.println("not a number, try again");
					}
					finally
					{
						scan.nextLine();
					}
					
					if(data < 0)
					{
						System.out.println("not above zero, try again");
						continue;
					}
				} while(data == Double.MIN_VALUE || data < 0);
				System.out.println("sqrt: " + Math.sqrt(data));
			break;
			
			case 2:
				LocalDate date = LocalDate.now();
				System.out.println(DateTimeFormatter.ofPattern("MM/dd/yyy").format(date));
			break;
			
			case 3:
				String text = "I am learning Core Java";
				String[] output = text.split(" ");
				for(int i = 0; i < output.length; i++)
				{
					System.out.println(output[i]);
					
				}
			break;
			
			default:
			break;
		}
	}

}
