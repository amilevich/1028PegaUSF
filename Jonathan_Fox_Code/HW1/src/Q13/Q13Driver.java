package Q13;

public class Q13Driver {

	//Display the triangle on the console as follows using any type of loop.  Do NOT use a simple group of print statements to accomplish this.
    //0
    //1 0
    //1 0 1
    //0 1 0 1
	public static void main(String[] args) {
		int k = 0;
		
		// i = lines 1 through 5
		for(int i = 1; i < 5; i++) {
			// for 0 through line#
			for(int j = 0; j < i; j++) {
				//print, then alternate k between 0 and 1
				System.out.printf("%d ", k);
				k^=1;
			}
			
			System.out.printf("\n");
		}

	}

}
