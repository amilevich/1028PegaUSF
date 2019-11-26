package part2;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Scanner;

public class Person {

	protected String nameFirst;
	protected String nameLast;
	private Date dateOfBirth;
	private String address;
	
	public Person(String f, String l, Date dob, String a) {
		super();
		this.nameFirst = f;
		this.nameLast = l;
		this.dateOfBirth = dob;
		this.address = a;
	}

	public Person() {
		
	}

	public void setName(String f, String l) {
		this.nameFirst = f;
		this.nameLast = l;
	}
	
	public String getName() {
		return this.nameFirst +" "+ this.nameLast;
	}
	
	public String getFirstName() {
		return this.nameFirst;
	}
	public String getLastName() {
		return this.nameLast;
	}
	
//	public void setDoB(int y, int m, int d) {
//		this.dateOfBirth = LocalDate.of(y, m, d);
//	}
	
	public void setDoB(Date dob) {
		this.dateOfBirth = dob;
	}
	
	public Date getDateOfBirth() {
		return this.dateOfBirth;
	}
	
	public void setAddress(String a) {
		if(a.length()>4) {
			this.address = a;
		}else {
		int num, zip;
		String street, city, state;

		Scanner sc = new Scanner(System.in);
		System.out.println("What is your building number?");
		num = sc.nextInt();
		sc.nextLine();
		System.out.println("What is your street name?");
		street = sc.nextLine();
		System.out.println("What city do you live in?");
		city = sc.nextLine();
		System.out.println("What is your zipcode?");
		zip = sc.nextInt();
		sc.nextLine();
		System.out.println("What state do you live in?");
		state = sc.nextLine();
		
		this.address += num+" " + street + "\n"+ city + ", " + state + " "+ zip;
		}

	}
	
	public String getAddress() {
		return this.address;
	}
}
