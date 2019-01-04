package com.dante.demohibernate11.service;

import com.dante.demohibernate11.model.Stock;
import com.dante.demohibernate11.dao.StockDao;

public class StockServiceImpl implements StockDao {
    private StockDao stockDao;

    public void save(Stock stock) {
        this.stockDao.save(stock);
    }

    public void update(Stock stock) {
        this.stockDao.update(stock);
    }

    public void delete(Stock stock) {
        this.stockDao.delete(stock);
    }

    public Stock findByStockCode(String stockCode) {
        return this.stockDao.findByStockCode(stockCode);
    }
}
