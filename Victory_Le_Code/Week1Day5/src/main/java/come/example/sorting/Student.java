package come.example.sorting;

import java.time.LocalDate;
import java.util.Date;

public class Student implements Comparable<Student>{

	private int studentId;
	private String name;
	private double gpa;
	private String year;
	private LocalDate dob;
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getGpa() {
		return gpa;
	}
	public void setGpa(double gpa) {
		this.gpa = gpa;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public LocalDate getDob() {
		return dob;
	}
	public void setDob(LocalDate dob) {
		this.dob = dob;
	}
	
	//Contrl+space+enter = empty constructor
	public Student() {
		// TODO Auto-generated constructor stub
	}
	public Student(int studentId, String name, double gpa, String year, LocalDate dob) {
		super();
		this.studentId = studentId;
		this.name = name;
		this.gpa = gpa;
		this.year = year;
		this.dob = dob;
	}
	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", name=" + name + ", gpa=" + gpa + ", year=" + year + ", dob=" + dob
				+ "]";
	}
	public int compareTo(Student o) {
		// TODO Auto-generated method stub
		return this.getStudentId() - o.getStudentId();
	}
	
	
}
