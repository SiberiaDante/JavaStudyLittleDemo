package com.dante.demo01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BookService {

    IBookDAO iBookDAO;

    public BookService() {
        //容器
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring01.xml");
        //从容器中获得id为bookdao的bean
        iBookDAO = (IBookDAO) ctx.getBean("bookDao");
    }

    public void storeBook(String name) {
        System.out.println("图片上货：");
        String result = iBookDAO.addBook(name);
        System.out.print(result);
    }
}
