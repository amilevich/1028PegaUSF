package problem1;

public class Solution {
	
	
	public static void main(String[] args) {	
		int[] array = new int[]{1,0,5,6,3,2,3,7,9,8,4};			
		for(int i=0; i<array.length-1; i++) {	
			int x;
			for(int j=0; j<array.length-1-i; j++) {
				if (array[j]> array[j+1]) {
					x = array[j+1];
					array[j+1] = array[j];
					array[j] = x;			
				} 
			}
		}
		for (int t=0; t<array.length-1; t++) {
			System.out.print(array[t]);
		}
		
	}
}