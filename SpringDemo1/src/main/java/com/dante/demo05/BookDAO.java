package com.dante.demo05;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

//@Component("b")
@Repository
public class BookDAO implements IBookDAO {
    public String addBook(String name) {
        return "add book "+name+" success";
    }
}
