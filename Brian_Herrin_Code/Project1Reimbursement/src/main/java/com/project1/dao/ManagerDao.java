package com.project1.dao;

import com.project1.model.Manager;

public interface ManagerDao {
	
	public int insertManager(Manager m);
	public Manager selectManagerByName(String name);
	public void updateManager(Manager m);

}
