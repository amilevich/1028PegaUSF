package interview.questions;
import interview.questions.eleven.*;

public class QEleven {

	private String x;
	private String y;

	public static void main(String[] args) {
		QElevenB floatAccessor = new QElevenB();
		
		System.out.println( "floats from another package " + floatAccessor.x + " ~ " + floatAccessor.y);
	}
	
}
