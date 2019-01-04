package com.dante.demo01;

import com.dante.demo14.service.TransferAccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring14.xml")
public class TestDemo14 {

    @Resource(name = "accountServiceProxy")
    TransferAccountService accountService;

    @Test
    public void test1() {
        accountService.transfer("aaa", "bbb", 800d);
    }
}
