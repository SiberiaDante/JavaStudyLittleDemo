package com.dante.demo13.dao;

public interface TransferAccountDao {

    public void outMoney(String name, double money);

    public void inMoney(String name, double money);
}
