package Q12PrintEvenTo100;

public class PrintEvenTo100 {

	public static void main(String[] args) {
		int arr[] = new int[100];
		
		for (int i = 0; i<100;i++) {
			arr[i]= i;
		}
		
		for (int x : arr) {
			if (arr[x]%2!=0)
				System.out.print(arr[x]+1+" ");
		}
		
	}

}
