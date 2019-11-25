package Project0BankAccountM.Project0BankAccountM;

public class MainDriver
{
	public static void main(String[] arrgs)
	{
		// Create menu
		MenuManager mainMenu = MenuManager.getInstance();
		
		// Start the menu system
		mainMenu.initMenuSystem();
		
		// Entering main game loop
		long timePrevous = System.nanoTime();
		long timeSlice = 0;
		while(mainMenu.update(timeSlice)) 
		{
			//update timeslice
			timeSlice = System.nanoTime() - timePrevous;
			timePrevous = System.nanoTime();
		}
		
		//Use exited, shut everything down
		mainMenu.shutDown();
		mainMenu = null;
	}
	
}

