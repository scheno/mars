package com.xinghuan.mars.code.aop.aspectj;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

/**
 * @author shenchen
 * @version 1.0
 * @date 2023/6/1 16:40
 */
@Aspect
public class FruitsAspect {

    @Pointcut("execution(* com.xinghuan.mars.code.aop.aspectj.*.*(..))")
    public void aop() {

    }

    @Before("aop()")
    public void before() {
        System.out.println("这是前置通知!!");
    }

    @Around("aop()")
    public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("这是环绕通知之前的部分!!");
        //调用目标方法
        Object proceed = proceedingJoinPoint.proceed();
        System.out.println("这是环绕通知之后的部分!!");
        return proceed;
    }

    @After("aop()")
    public void after() {
        System.out.println("这是后置通知!!");
    }

}
