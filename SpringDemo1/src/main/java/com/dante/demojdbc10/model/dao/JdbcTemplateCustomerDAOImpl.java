package com.dante.demojdbc10.model.dao;

import com.dante.demojdbc10.model.Customer;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

public class JdbcTemplateCustomerDAOImpl implements CustomerDAO {
    private JdbcTemplate jdbcTemplate;
    private DataSource dataSource;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void insert(Customer customer) {
        String sql = "INSERT INTO CUSTOMER  (CUST_ID, NAME, AGE) VALUES (?, ?, ?)";
        jdbcTemplate = new JdbcTemplate(dataSource);
        jdbcTemplate.update(sql,new Object[]{customer.getCustId(),customer.getName(),customer.getAge()});
    }

    public void update(Customer customer) {

    }

    public Customer findByCustomerId(int custId) {
        String sql = "SELECT * FROM customer WHERE CUST_ID= ?";
        jdbcTemplate = new JdbcTemplate(dataSource);
        return null;
    }
}
