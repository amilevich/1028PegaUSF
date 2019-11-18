package com.example.exceptions;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		MyCustomException myEx = new MyCustomException("This is my ex");
		MyCustomException myEx1 = new MyCustomException("Is this my ex? ", myEx);
		MyCustomException myEx2 = new MyCustomException("This is is not even my ex");
		
		MyCustomRuntimeException myRex = new MyCustomRuntimeException("This is my Rex", myEx2);


		
		try {
			throw myEx2;
		}catch(MyCustomException e) {
			e.printStackTrace();
		}

	}

}
