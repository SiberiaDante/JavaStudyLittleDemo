package com.dante.demo05;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    @Autowired
    IBookDAO iBookDAO;

    public void storeBook(String name) {
        System.out.println("图片上货：");
        String result = iBookDAO.addBook(name);
        System.out.print(result);
    }
}
