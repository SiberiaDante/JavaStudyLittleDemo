package com.dante.demo01;

import com.dante.demo16.service.TransferAccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring16.xml")
public class TestDemo16 {

    @Resource(name = "accountService")
    TransferAccountService accountService;

    @Test
    public void test1() {
        accountService.transfer("aaa", "bbb", 200d);
    }
}
