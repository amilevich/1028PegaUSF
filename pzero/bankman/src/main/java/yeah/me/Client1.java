package yeah.me;

import java.util.List;

public interface Client1 {
			//CREATE
			public int insertCli(customer p);
			//READ
			public account selectCliByName(customer p);
			public List<customer> selectAllCustomer(customer p);
			//UPDATE
			public int updateCli(customer p);
			//DELETE
			public int deleteCli(customer p);
	}
	

