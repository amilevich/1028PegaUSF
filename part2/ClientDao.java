package part2;

import java.util.ArrayList;

public interface ClientDao {
	
	//CREATE
	public void insertClnt(Client c);
	
	//READ
	public Client selectClntByUserName(String userName);
	public ArrayList<Client> selectAllClnts();
	
	//UPDATE
	public void updateClnt(Client c);
	
	//DELETE
	public void deleteClnt(Client c);

}
