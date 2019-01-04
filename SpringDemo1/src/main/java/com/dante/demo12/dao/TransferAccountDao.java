package com.dante.demo12.dao;

public interface TransferAccountDao {

    public void outMoney(String name, double money);

    public void inMoney(String name, double money);
}
