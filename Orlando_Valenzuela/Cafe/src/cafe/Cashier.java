package cafe;

public class Cashier implements Runnable {
	
	private Cafe cafe;
	
	Cashier(Cafe cafe) {
		this.cafe = cafe;
		new Thread(this, "Cashier").start();
	}
	
	
	@Override
	public void run() {
	
		while(true) {
			cafe.neworder();
		
	    }
	}
}