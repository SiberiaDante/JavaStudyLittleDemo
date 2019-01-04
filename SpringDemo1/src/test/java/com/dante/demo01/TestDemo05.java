package com.dante.demo01;

import com.dante.demo05.BookService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestDemo05 {

    @Test
    public void testDemo() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring01.xml");
        BookService bookService = ctx.getBean("bookService", BookService.class);
        bookService.storeBook("Java");
    }
}
