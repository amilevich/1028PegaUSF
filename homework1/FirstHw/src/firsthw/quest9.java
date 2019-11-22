package firsthw;

public class quest9 {
	
	
	public static void main(String args[]) {

        for (int i = 2; i <= 100; i++) {
            if (isPrime(i)) {
                System.out.println(i);
            }
        }
    }

    public static boolean isPrime(int num) {
        if (num == 2 || num == 3) {
            return true;
        }

        if (num % 2 == 0 || num % 3 == 0) {
            return false;
        }

        for (int i = 3; i < Math.sqrt(num); i += 2) {
            if (num % i == 0 || num % Math.sqrt(num) == 0) {
                return false;
            }
        }
        return true;

    }
}


