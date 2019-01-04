package com.dante.demojdbc10.model.dao;

import com.dante.demojdbc10.model.Customer;
import com.dante.demojdbc10.model.map.CustomerMap;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import javax.sql.DataSource;
import java.util.List;

public class JdbcTempSupportDAOImpl extends JdbcDaoSupport implements CustomerDAO {
    private JdbcTemplate jdbcTemplate;

    public void insert(Customer customer) {
        String sql = "INSERT INTO CUSTOMER  (CUST_ID, NAME, AGE) VALUES (?, ?, ?)";
        getJdbcTemplate().update(sql, new Object[]{customer.getCustId(), customer.getName(), customer.getAge()});
    }

    public void update(Customer customer) {

    }

    public Customer findByCustomerId(int custId) {
        String sql = "SELECT * FROM customer WHERE CUST_ID= ?";
        if (getJdbcTemplate() != null) {
            return  (Customer) getJdbcTemplate().queryForObject(sql, new CustomerMap(), custId);
        }
//        return customerList.size() != 0 ? customerList.get(0) : null;
        return null;
    }
}
