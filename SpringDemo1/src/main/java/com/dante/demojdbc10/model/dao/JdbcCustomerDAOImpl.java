package com.dante.demojdbc10.model.dao;

import com.dante.demojdbc10.model.Customer;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JdbcCustomerDAOImpl implements CustomerDAO {
    private DataSource dataSource;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public void insert(Customer customer) {
        String sql = "INSERT INTO CUSTOMER  (CUST_ID, NAME, AGE) VALUES (?, ?, ?)";
        Connection conn = null;

        try {
            conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, customer.getCustId());
            ps.setString(2, customer.getName());
            ps.setInt(3, customer.getAge());
            ps.executeUpdate();
            ps.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                }
            }
        }
    }

    public void update(Customer customer) {

    }

    @Override
    public Customer findByCustomerId(int custId) {
        String sql = "SELECT * FROM customer WHERE CUST_ID= ?";
        Connection conn = null;
        try {
            conn = dataSource.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, custId);
            ResultSet resultSet = statement.executeQuery();
            Customer customer = null;
            while (resultSet.next()) {
                customer = new Customer();
                customer.setCustId(resultSet.getInt("CUST_ID"));
                customer.setAge(resultSet.getInt("AGE"));
                customer.setName(resultSet.getString("NAME"));
            }
            resultSet.close();
            statement.close();
            return customer;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
