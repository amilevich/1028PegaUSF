package com.homework.Q18;

public class SecondClass extends TopClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		SecondClass go = new SecondClass();

		String level2 = "We are the knights at UCF!!";
		String level3 = "18245";
		
		boolean y= go.findUpper(level2);
		String n =go.lowertoup(level2);
		int value =go.intoStr(level3); 
		
		System.out.println("Finding upper: " +  y);
		System.out.println("convert to lower reads:\n " +  n);
		System.out.println("Convert to int reads:\n " +  value);
		
	}
	// calls methods from another interface s
	@Override
	public boolean findUpper(String a) {
		if(!a.equals(a.toLowerCase())) {
			return true;
		}else
		return false;
	}

	@Override
	public String lowertoup(String b) {
		String fin= b.toUpperCase();
		
		return fin;
	}

	@Override
	public int intoStr(String c) {
	 int j = Integer.parseInt(c);
	 
	 	j+=10;
	 	
	 	
		
		return j;
	}

}
