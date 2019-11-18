package yeah.me;

import java.io.Serializable;

public class customer extends account implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6466793166682274173L;
	private String usern1 = "Single";
	private String pass1 = "Single";
	private String usern2 = "Single";
	private String pass2 = "Single";

	public customer() {

	}

	public customer(double balance, String id, String username, String password, String cusna, String usern2,
			String pass2) { // joint customer
		super(balance, id, "Single", "Single", cusna);
		this.setUsern1(username);
		this.setPass1(password);
		this.usern2 = usern2;
		this.pass2 = pass2;
	}

	public customer(double balance, String id, String username, String password, String cusna) { // single customer
		super(balance, id, username, password, cusna);
	}

	@Override
	public String toString() {
		return "customer [id=" + super.getId() + ", username=" + super.getUsername() + ", password="
				+ super.getPassword() + "username 2= " + usern2 + "password 2" + pass2 + ", cusna=" + super.getCusna()
				+ "account ballance $" + super.getBalance() + "]";
	}

	public int customerOptions(customer i) {
		System.out.println("hi would you want to 1withdraw/ 2deposit/ 3transfer/ 4 create joint?");
		int choice = employee.cusnam.nextInt();
		switch (choice) {
		case 1:
			withdraw(i);
			break;

		case 2:
			deposit(i);

			break;

		case 3:
			
			return 3;

			
		case 4:
		
			return 2;
		case 5:
			System.out.println(i.getBalance());
			i.customerOptions(i);
			break;
		case 0:
			System.out.println("main menu");
			break;
		

		default:System.out.println("try again");
		i.customerOptions(i);
			break;
		}
		return 1;
	}

	private static void deposit(customer i) {
		System.out.println("how much with you deposit?");
		int dep;

		while (true) {
			dep = employee.cusnam.nextInt();
			if (dep < 0) {
				System.out.println("please enter a valid amount");
			} else {
				break;
			}
		}
		i.setBalance(i.getBalance() + dep);
		System.out.println(i.getBalance());
		i.customerOptions(i);
	}

	private static void withdraw(customer i) {
		System.out.println("how much will u withdraw");
		int dep;
		while (true) {
			dep = employee.cusnam.nextInt();
			if (dep < 0) {
				System.out.println("please enter a valid amount");
			} else {
				break;
			}

		}
		i.setBalance(i.getBalance() - dep);
		System.out.println(i.getBalance());
	}


	public String getUsern2() {
		return usern2;
	}

	public void setUsern2(String usern2) {
		this.usern2 = usern2;
	}

	public String getPass2() {
		return pass2;
	}

	public void setPass2(String pass2) {
		this.pass2 = pass2;
	}

	public String getPass1() {
		return pass1;
	}

	public void setPass1(String pass1) {
		this.pass1 = pass1;
	}

	public String getUsern1() {
		return usern1;
	}

	public void setUsern1(String usern1) {
		this.usern1 = usern1;
	}

}
