package thecannabiscafe;


public class Cannabis_strain extends Cannabis_and_Coffee {
	public String Strain[] = {"Jack Herer", "Skywalker OG", "Gorilla Glue", "Blue Dream"} ;

	public Cannabis_strain(String[] strain) {
		super();
		Strain = strain;
	}

	public String[] getStrain() {
		return Strain;
	}

	public void setStrain(String[] strain) {
		Strain = strain;
	}

	@Override
	public String toString() {
		return "Cannabis_strain [Strain=" + Strain + "]";
	}
	
	



}