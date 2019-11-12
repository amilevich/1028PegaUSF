package cafe;

public class MainClass {

	public static void main(String[] args) {
				
		 Cafe cafe = new Cafe();
		 new Cashier(cafe);
		 new Server(cafe);

	}

}
