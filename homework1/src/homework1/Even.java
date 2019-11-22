package homework1;

public class Even {
	public void even() {
		//Declare array from 1 to 100
		int[]aaray=new int[100];
		//go through the array
		for(int i=0;i<aaray.length;i++) {
			aaray[i]=i;
			//for hhance loop
		}for (int v : aaray) {
			if (aaray[v] %2==0) {
				//display the result
				System.out.println(v);
			}
			
		}
	}

}
