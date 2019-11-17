
public class ExceptionExampleHelper {
	
	public static void howToDuck() throws Exception {
		throw new RuntimeException();
	}

	public static void triggerException() {
		Throwable th = new Throwable();
		RuntimeException re2 = new RuntimeException();
		try {
			throw th;
		}catch(Throwable e) {
			e.printStackTrace();
		}
	}
	
}
