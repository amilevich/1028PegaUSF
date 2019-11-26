package bankapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBCCONNECT {

	public static void main(String[] args) throws Exception{
		
//create jdbc connection obj and load class 
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@db1028.cxw1rocclkwr.us-east-1.rds.amazonaws.com:1521:DB1028","db1028","Password1");
		//create statement obj
		
		Statement st=conn.createStatement();
		
		//Execute the query
		ResultSet resultsOfQuery=st.executeQuery("select * from DB");
		
		//print database table records
		
		while(resultsOfQuery.next()) {
			System.out.println(resultsOfQuery.getInt(1)+" "+resultsOfQuery.getString(2)+" "+resultsOfQuery.getString(3));
		}
		
	}

}
