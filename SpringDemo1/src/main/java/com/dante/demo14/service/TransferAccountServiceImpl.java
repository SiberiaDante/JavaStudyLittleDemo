package com.dante.demo14.service;

import com.dante.demo14.dao.TransferAccountDao;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

public class TransferAccountServiceImpl implements TransferAccountService {

    private TransferAccountDao accountDao;
    public void setAccountDao(TransferAccountDao accountDao) {
        this.accountDao = accountDao;
    }

    @Override
    public void transfer(String inName, String outName, double money) {
        accountDao.outMoney(outName, money);
//        int i = 1 / 0;
        accountDao.inMoney(inName, money);
    }
}
