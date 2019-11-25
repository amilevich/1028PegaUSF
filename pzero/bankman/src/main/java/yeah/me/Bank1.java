package yeah.me;

import java.util.List;

public interface Bank1 {
	//CREATE
		public int insertacc(account p);
		//READ
		public account selectaccByName(account p);
		public List<account> selectAllaccount(account p);
		public List<account> selectAllaccount();
		//UPDATE
		public int updateacc(account p);
		//DELETE
		public int deleteacc(account p);
		
		
}
