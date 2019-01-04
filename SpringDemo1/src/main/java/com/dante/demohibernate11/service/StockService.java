package com.dante.demohibernate11.service;

import com.dante.demohibernate11.model.Stock;

public interface StockService {

    void save(Stock stock);
    void update(Stock stock);
    void delete(Stock stock);
    Stock findByStockCode(String stockCode);

}
