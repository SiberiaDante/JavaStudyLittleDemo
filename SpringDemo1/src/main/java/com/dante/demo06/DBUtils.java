package com.dante.demo06;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class DBUtils {
    @Value("com.jdbc.driver.Oracle")
    private String driver;
    @Value("${URL}")
    private String location;
    @Value("${name}")
    private String name;
    @Value("${password}")
    private String password;

    @Override
    public String toString() {
        return "DBUtils{" +
                "driver='" + driver + '\'' +
                ", location='" + location + '\'' +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
