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
	private  int status =0; //fALSE MEANS PENDING
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

	public customer(String username, String password, String usern2, String pass2, int z) {
		this.setUsern1(username);
		this.setPass1(password);
		this.usern2 = usern2;
		this.pass2 = pass2;
		this.status = z;
	}

	public customer(String cusna, String username, String password) {
		super(cusna,username, password);
	}

	@Override
	public String toString() {
		return "customer [id=" + super.getId() + ", username=" + super.getUsername() + ", password="
				+ super.getPassword() + "username 2= " + usern2 + "password 2" + pass2 + ", cusna=" + super.getCusna()
				+ "account ballance $" + super.getBalance() + "]";
	}
	public static int customerOptions(account r) {
		System.out.println("hi would you want to 1withdraw/ 2deposit/ 3transfer/ 4 create joint?");
		int choice = Bank.cusnam.nextInt();
		switch (choice) {
		case 1:
			withdraw(r);
			break;

		case 2:
			deposit(r);

			break;

		case 3:
			
			return 3;

			
		case 4:
		
			return 2;
		case 5:
			System.out.println(r.getBalance());
			customerOptions(r);
			break;
		case 0:
			System.out.println("main menu");
			break;
		

		default:System.out.println("try again");
		customerOptions(r);
			break;
		}
		return 1;
	}

	public static void deposit(account r) {
		System.out.println("how much with you deposit?");
		int dep;

		while (true) {
			dep = Bank.cusnam.nextInt();
			if (dep < 0) {
				System.out.println("please enter a valid amount");
			} else {
				break;
			}
		}
		r.setBalance(r.getBalance() + dep);
		System.out.println(r.getBalance());
		customerOptions(r);
		Bank.DAO.updateacc(r);
	}

	public static void withdraw(account r) {
		System.out.println("how much will u withdraw");
		int dep;
		while (true) {
			dep = Bank.cusnam.nextInt();
			if (dep < 0) {
				System.out.println("please enter a valid amount");
			} else {
				break;
			}

		}
		r.setBalance(r.getBalance() - dep);
		System.out.println(r.getBalance());
		Bank.DAO.updateacc(r);
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

	public int isStatus() {
		return status;
	}

	public void setStatus(int i) {
		this.status = i;
	}

}
