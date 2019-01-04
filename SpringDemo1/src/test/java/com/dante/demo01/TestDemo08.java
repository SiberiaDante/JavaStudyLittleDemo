package com.dante.demo01;

import com.dante.demoaop08.*;
import org.junit.Test;
import org.springframework.aop.framework.ProxyFactory;

public class TestDemo08 {

    @Test
    public void test() {
        IMath math = new MathProxy();
        int n1 = 100, n2 = 5;
        math.add(n1, n2);
        math.sub(n1, n2);
        math.mut(n1, n2);
        math.div(n1, n2);
    }

    @Test
    public void test1() {
        IMath math = (IMath) new DynamicProxy().getProxyObject(new Maths());
        int n1 = 100, n2 = 5;
        math.add(n1, n2);
        math.sub(n1, n2);
        math.mut(n1, n2);
        math.div(n1, n2);
    }

    @Test
    public void test2() {
        IMath math = (IMath) new DynamicProxyCglib().getProxyObject(new Maths());
        int n1 = 100, n2 = 5;
        math.add(n1, n2);
        math.sub(n1, n2);
        math.mut(n1, n2);
        math.div(n1, n2);
    }

    @Test
    public void test3() {
        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.setTarget(new Maths());
        proxyFactory.addAdvice(new BeforeAdvice());
        proxyFactory.addAdvice(new AfterAdvice());
        proxyFactory.addAdvice(new SurroundAdvice());
        IMath math = (IMath) proxyFactory.getProxy();
        int n1 = 100, n2 = 5;
        math.add(n1, n2);
        math.sub(n1, n2);
        math.mut(n1, n2);
        math.div(n1, n2);
    }
}
