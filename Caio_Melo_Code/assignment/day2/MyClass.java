package com.assignment.day2;

public class MyClass {

	public static void main(String[] args) {
		
		government[] index = new government[5];
		
		government Japan = new government("Japan","Small",100000);
		government Germany = new government("Germany","Medium",500000);
		government USA = new government("USA","Large",1000000);
		government Russia = new government("Russia","Large",1000000);
		government Italy = new government("Italy","Small",10000);
		
		index[0] = Japan;
		index[1] = Germany;
		index[2] = USA;
		index[3] = Russia;
		index[4] = Italy;
		
		
		Japan.declareWar(USA,Russia,Italy);
		
		Germany.condemn(Japan);
		
		
	}
}
