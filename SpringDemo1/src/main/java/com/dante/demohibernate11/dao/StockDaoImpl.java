package com.dante.demohibernate11.dao;

import com.dante.demohibernate11.model.Stock;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class StockDaoImpl extends HibernateDaoSupport implements StockDao {
    public void save(Stock stock) {
        getHibernateTemplate().save(stock);
    }

    public void update(Stock stock) {

    }

    public void delete(Stock stock) {

    }

    public Stock findByStockCode(String stockCode) {
        return null;
    }
}
