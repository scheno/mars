package com.xinghuan.mars.code.aop.aspectj;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author shenchen
 * @version 1.0
 * @date 2023/6/1 17:01
 */
public class Test {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(FruitsServiceImpl.class);
        context.register(FruitsAspect.class);
        context.register(AopConfig.class);
        context.refresh();
        FruitsService fruitsService = context.getBean(FruitsService.class);
        System.out.println(fruitsService.getName("苹果"));
    }

}
