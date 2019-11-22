package firsthw;


import java.util.ArrayList;

public class quest12 {
	public static void main(String[] args) {
		
	
	int en[]=new int [100];
	
	for(int i=0;i<100;i++) {
		en [i]=i+1;
	}
	for (int d:en) {
		 if(d%2!=0) {
			 System.out.print(en[d]+" " );
		 }
	}
	}
}
