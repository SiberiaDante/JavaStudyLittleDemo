package com.dante.demo01;

import org.junit.Test;

public class TestDemo01 {

    @Test
    public void testDemo01(){
        BookService service = new BookService();
        service.storeBook("HXM");
    }
}
