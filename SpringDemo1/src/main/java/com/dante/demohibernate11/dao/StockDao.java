package com.dante.demohibernate11.dao;

import com.dante.demohibernate11.model.Stock;

public interface StockDao {

    void save(Stock stock);
    void update(Stock stock);
    void delete(Stock stock);
    Stock findByStockCode(String stockCode);

}
