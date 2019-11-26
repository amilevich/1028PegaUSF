package part2;

import java.util.ArrayList;

public interface EmployeeDao {

	//CREATE
	public void insertEmp(Employee e);
	
	//READ
	public Employee selectEmpByName(String name);
	public ArrayList<Employee> selectAllEmps();
	
	//UPDATE
	public void updateEmp(Employee e);
	
	//DELETE
	public void deleteEmp(Employee e);
	
}
