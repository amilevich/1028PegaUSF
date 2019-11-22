package davidvallejo.hw.javacore;

import java.io.Serializable;//serializable api

public class Q20Data implements Serializable {
	private static final long serialVersionUID = 8434728043945598184L;
	private  String name;
	private int age;
	private String state;
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Q20Data(){
		super();
	}

	@Override
	public String toString() {
		return "Name: " + name + "\n" + "Age: " + age + " years" + "\n" + "State: " + state + " State";
	}
}
