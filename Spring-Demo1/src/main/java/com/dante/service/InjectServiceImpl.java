package com.dante.service;

import com.dante.dao.InjectDao;

public class InjectServiceImpl implements InjectService{

	private InjectDao injectDao;
	
	private InjectServiceImpl() {
	}

	public InjectServiceImpl(InjectDao injectDao) {
		this.injectDao = injectDao;
	}

	public void setInjectDao(InjectDao injectDao) {
		this.injectDao = injectDao;
	}

	@Override
	public void save(String arg) {
		System.out.println("-----InjectServiceImpl--------:"+arg);
		injectDao.save(arg);
	}

}
