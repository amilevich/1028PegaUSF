package cafe;

public class FoodOrder {
	
	private String name;
	private String entree;
	private String side;
	private String dessert;
	
	
	public FoodOrder(String name, String entree, String side, String dessert) {
		super();
		this.name = name;
		this.entree = entree;
		this.side = side;
		this.dessert = dessert;
	}
	public FoodOrder(String n) {
		this.name = n;
		this.entree = " ";
		this.side = " ";
		this.dessert = " ";
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEntree() {
		return entree;
	}
	public void setEntree(String entree) {
		this.entree = entree;
	}
	public String getSide() {
		return side;
	}
	public void setSide(String side) {
		this.side = side;
	}
	public String getDessert() {
		return dessert;
	}
	public void setDessert(String dessert) {
		this.dessert = dessert;
	}
	@Override
	public String toString() {
		return "FoodOrder [name=" + name + ", entree=" + entree + ", side=" + side + ", dessert=" + dessert + "]";
	}
	
	

	
}
