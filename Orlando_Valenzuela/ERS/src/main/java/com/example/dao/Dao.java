package com.example.dao;

import java.util.ArrayList;

public interface Dao <T>{
	
	public boolean insert(T t);
	public boolean delete(T t);
	public boolean update(T t);
	public T find(String s); 
	public ArrayList<T> findAll();
}
