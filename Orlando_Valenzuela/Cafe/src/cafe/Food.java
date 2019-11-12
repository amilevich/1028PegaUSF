package cafe;

public class Food {
	
	private String name;
	private float price;

	public Food(String name, float price) {
		super();
		this.name = name;
		this.price = price;
		
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	@Override
	public String toString() {
		
		char[] w = {'-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-'};
		int l = name.length();
		String aux = String.copyValueOf(w, 0, 30 - l);
		return "Food " + name + aux + price;
	}




    
}
