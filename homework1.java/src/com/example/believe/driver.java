package com.example.believe;

public class driver {
	
	
	public static void main(String[] args) {
		
		Vehicle a = new Vehicle("fox");
		Vehicle b = new Vehicle("hen");
		
		Object[] vehicleObject = {a,b};
		
		for(int i = 0; i < vehicleObject.length; i++)
		{
			System.out.println(vehicleObject[i]);
		}
	}

	}		

