package com.example.dao;

import java.util.List;

import com.example.model.IceCream;

public interface IceCreamDao {
	// CREATE
	public int insertIceCream(IceCream ice); // return type does not matter

	// READ
	public IceCream selectByFlavor(String flavor);

	public List<IceCream> selectAllIceCream(); // will go to database select all from pets and will then go to java

	// UPDATE
	public int updateIceCream(IceCream ice); // return type does not matter

	// DELETE
	public int deleteIceCream(IceCream ice);

}
