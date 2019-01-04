package com.dante.demo01;

public class BookDAO implements IBookDAO {
    public String addBook(String name) {

        return "添加图书 " + name + " 成功";
    }
}
