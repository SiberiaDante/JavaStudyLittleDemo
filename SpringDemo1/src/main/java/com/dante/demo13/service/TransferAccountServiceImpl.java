package com.dante.demo13.service;

import com.dante.demo13.dao.TransferAccountDao;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

public class TransferAccountServiceImpl implements TransferAccountService {

    private TransferAccountDao accountDao;

    private TransactionTemplate transactionTemplate;

    public void setTransactionTemplate(TransactionTemplate transactionTemplate) {
        this.transactionTemplate = transactionTemplate;
    }

    public void setAccountDao(TransferAccountDao accountDao) {
        this.accountDao = accountDao;
    }

    @Override
    public void transfer(String inName, String outName, double money) {
        transactionTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus transactionStatus) {
                accountDao.outMoney(outName, money);
                int i = 1 / 0;
                accountDao.inMoney(inName, money);
            }
        });

    }
}
