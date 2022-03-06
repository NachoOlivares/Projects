package com.database.services;

import java.util.List;

import com.database.dao.DatabaseDao;
import com.database.modelo.Data;

public interface DatabaseService extends DatabaseDao {

	void AddData(Data data);
	
	Data findByUrl(String url);
	
	void deleteByName(String name);
	
	void deleteByUrl(String url);
	
	List<Data> findAll();
}
