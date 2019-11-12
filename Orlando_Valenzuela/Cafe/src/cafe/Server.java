package cafe;

public class Server implements Runnable{
	
	 private Cafe cafe;
	 
	 Server(Cafe cafe) {
		 this.cafe = cafe;
		 new Thread(this, "Server").start();
	 }

	@Override
	public void run() {
		while(true) {
			cafe.ordercompleted();
		}				
	}
	
}
