package com.xinghuan.mars.code.aop.jdk;

public class RealSubject implements Subject {

    @Override
    public Integer result(Integer param) {
        System.out.println("real Subject........ -> " + param);
        return param + 1;    
    }
    
}
