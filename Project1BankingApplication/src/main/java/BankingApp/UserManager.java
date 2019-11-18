package BankingApp;

import java.io.IOException;
/*
 * Interface created to extend the FileUserManger
 */

public interface UserManager {

	public boolean signUp(Users user);
	public boolean login(String username, String password);
	public boolean isValidateCredentials(String username, String password);
	public void cleanup() throws IOException;
}
