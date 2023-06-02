package com.xinghuan.mars.code.aop.cglib;

import java.lang.reflect.Method;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

public class CglibProxy implements MethodInterceptor {

    private Enhancer enhancer = new Enhancer();

    public Object getProxy(Class<?> clazz) {
        enhancer.setSuperclass(clazz);
        enhancer.setCallback(this);
        return enhancer.create();
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy)
            throws Throwable {
        System.out.println("代理执行前：" + o.getClass().getName() + "----" + method.getName());
        Object result = methodProxy.invokeSuper(o, objects);
        System.out.println("代理执行结束......");
        return result;
    }

    public static void main(String[] args) {
        CglibProxy cglibProxy = new CglibProxy();
        Person person = (Person) cglibProxy.getProxy(Person.class);
        System.out.println(person.getClass().getName());
        System.out.println(person.getClass().getSuperclass().getName());
        Integer result = person.result(10);
        System.out.println(result);
    }

}
