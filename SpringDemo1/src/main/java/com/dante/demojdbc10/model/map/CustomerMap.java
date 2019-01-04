package com.dante.demojdbc10.model.map;

import com.dante.demojdbc10.model.Customer;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerMap implements RowMapper {
    public Customer mapRow(ResultSet resultSet, int i) throws SQLException {
        System.out.println(resultSet.getInt("AGE"));
        return new Customer(resultSet.getInt("CUST_ID"),resultSet.getString("NAME"),resultSet.getInt("AGE"));
    }
}
