package homework1;

public class Triangle {
	public void triangle() {
		int a=0, b=1,c=0;
		for(int i = 0; i<4; i++) {
			for(int j=0; j<=i;j++) {
				if (c==0) {
					System.out.print(a + " ");
					c=b;
				}
				else if(c==1) {
					System.out.print(b + " ");
					c=a;
				}
				
			}
			
			System.out.println("\n");
		}
	}
}
