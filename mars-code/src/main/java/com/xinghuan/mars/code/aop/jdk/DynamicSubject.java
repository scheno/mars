package com.xinghuan.mars.code.aop.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class DynamicSubject implements InvocationHandler {

    private Object subject;

    public DynamicSubject(Object subject) {
        this.subject = subject;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("proxy before...." + method.toString());
        Object invoke = method.invoke(subject, args);
        System.out.println("proxy before...." + method.toString());
        return invoke;
    }
    
}
