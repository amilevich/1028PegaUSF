package com.homework.qnineteen;

import java.util.ArrayList;

public class Qnineteen {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> qNineteen = new ArrayList();
		ArrayList<Integer> even = new ArrayList();
		ArrayList<Integer> odd = new ArrayList();
		
		int[] intList = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		
		for (int i = 0; i < intList.length; i++) {
			qNineteen.add(intList[i]);
		}
		System.out.println(qNineteen);
		
		for (int j = 0; j < intList.length; j++) {
			if (j % 2 == 0) {
				odd.add(intList[j]);
			}else {
				even.add(intList[j]);
			}
		}
		
//		System.out.println(even);
//		System.out.println(odd);
		
		int evenSum = 0;
		int oddSum = 0;
		
		for(Integer eAdd: even) {
			evenSum += eAdd;
		}
		
		for(Integer oAdd: odd) {
			oddSum += oAdd;
		}
		System.out.println("Total of even numbers is " + evenSum);
		System.out.println("Total of odd numbers is " + oddSum);
		
		for (int k = 0; k < qNineteen.size() - 1; k++) {
			if (isPrime(qNineteen.get(k))) {
				qNineteen.remove(qNineteen.get(k));
				k--;
			}
		}
		System.out.println("ArrayList without Prime Numbers: " + qNineteen);
	}
	
	public static boolean isPrime(int x) {
		boolean itIs = true;
		for (int i = 2; i < x; i++) {
			if (x % i == 0) {
				itIs = false;
			}
		}
		return itIs;

	}

}
