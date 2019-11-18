package part1;

import java.time.LocalDate;
import java.util.Scanner;

public class Person {

	protected String nameFirst;
	protected String nameLast;
	private LocalDate dateOfBirth;
	private String address;
	
	public Person(String f, String l, LocalDate dob, String a) {
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
	
	public void setDoB(int y, int m, int d) {
		this.dateOfBirth = LocalDate.of(y, m, d);
	}
	
	public LocalDate getDateOfBirth() {
		return this.dateOfBirth;
	}
	
	public void setAddress() {
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
	
	public String getAddress() {
		return this.address;
	}
}
