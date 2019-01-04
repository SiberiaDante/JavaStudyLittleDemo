package com.dante.demo15.dao;

import org.springframework.jdbc.core.support.JdbcDaoSupport;

public class TransferAccountDaoImpl extends JdbcDaoSupport implements TransferAccountDao {


    @Override
    public void outMoney(String name, double money) {
        String sql = "update account set money = money - ? where name = ?";
        getJdbcTemplate().update(sql, money, name);
    }

    @Override
    public void inMoney(String name, double money) {
        String sql = "update account set money = money + ? where name = ?";
        getJdbcTemplate().update(sql, money, name);
    }
}
