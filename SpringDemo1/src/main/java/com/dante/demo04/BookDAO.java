package com.dante.demo04;

import com.dante.demo01.IBookDAO;
import org.springframework.stereotype.Component;

@Component("bookDao")
public class BookDAO implements IBookDAO {
    public String addBook(String name) {
        return "add book "+name+" success";
    }
}
