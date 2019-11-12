package thecannabiscafe;

public class Brew_of_Coffee extends Cannabis_and_Coffee  {
	 public String brew[]= {"Iced Coffee", "Latte", "Cappuccino", "Frappuccino" };
	 public Brew_of_Coffee() {
		 
	 }
	public Brew_of_Coffee(String[] brew) {
		super();
		this.brew = brew;
	}

	public String[] getBrew() {
		return brew;
	}

	public void setBrew(String[] brew) {
		this.brew = brew;
	}

	@Override
	public String toString() {
		return "Brew_of_Coffee [brew=" + brew + "]";
	}
	 
	 
	 
	 
}
