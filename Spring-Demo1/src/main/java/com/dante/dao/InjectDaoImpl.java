package com.dante.dao;

public class InjectDaoImpl implements InjectDao {

	@Override
	public void save(String arg) {
		System.out.println("---------InjectDaoImpl-------:" + arg);
	}

}
