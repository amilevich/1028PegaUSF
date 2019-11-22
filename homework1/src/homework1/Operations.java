package homework1;

public class Operations implements Operation {

	@Override
	public void add(int a, int b) {
		int x = a +b;
		System.out.println("This is my addition " + x);
		// TODO Auto-generated method stub
		
	}

	@Override
	public void sub(int a, int b) {
		int x = a  - b;
		System.out.println("This is my subtraction " + x);
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mult(int a, int b) {
		int x = a *b;
		System.out.println("This is my multiplication " + x);

		
		// TODO Auto-generated method stub
		
	}

	@Override
	public void div(int a, int b) {
		int x = a /b;
		
		System.out.println("This is my subtraction " + x);

		// TODO Auto-generated method stub
		
	}
	

}
