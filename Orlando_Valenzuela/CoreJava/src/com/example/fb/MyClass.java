package com.example.fb;

public class MyClass {

	public static void main(String[] args) {
	
		 fb(25); 	
	}
	
	public static int fb(int count){
		
		 return fbaux(count, 0, 1);	
		}  
		
	private static int fbaux(int count, int n1, int n2 ) {
		System.out.print(n1+n2);
		System.out.print('-');
		if (count > 1 )
			return fbaux (count - 1, n2, n1 + n2);
		else
			return (n1 +n2);
		
	}

}
