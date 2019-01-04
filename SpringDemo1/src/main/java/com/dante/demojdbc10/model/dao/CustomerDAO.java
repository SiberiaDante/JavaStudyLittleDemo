package com.dante.demojdbc10.model.dao;

import com.dante.demojdbc10.model.Customer;

public interface CustomerDAO {
    public void insert(Customer customer);

    public void update(Customer customer);

    public Customer findByCustomerId(int custId);
}
