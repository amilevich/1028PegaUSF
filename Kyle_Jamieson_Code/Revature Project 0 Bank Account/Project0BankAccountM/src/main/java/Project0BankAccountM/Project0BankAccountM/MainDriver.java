package Project0BankAccountM.Project0BankAccountM;

public class MainDriver
{
	public static void main(String[] arrgs)
	{
		// Create menu
		Menu mainMenu = Menu.GetInstance();
		
		// Start the menu system
		mainMenu.initMenuSystem();
		
		// Entering main game loop
		double timeSlice = 0.0;
		while(mainMenu.update(timeSlice)) {}
		
		//Use exited, shut everything down
		mainMenu.shutDown();
		mainMenu = null;
	}
	
}

