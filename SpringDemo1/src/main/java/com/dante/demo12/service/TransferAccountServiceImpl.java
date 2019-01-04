package com.dante.demo12.service;

import com.dante.demo12.dao.TransferAccountDao;

public class TransferAccountServiceImpl implements TransferAccountService {

    private TransferAccountDao accountDao;

    public void setAccountDao(TransferAccountDao accountDao) {
        this.accountDao = accountDao;
    }

    @Override
    public void transfer(String inName, String outName, double money) {
        accountDao.outMoney(outName, money);
        accountDao.inMoney(inName, money);
    }
}
