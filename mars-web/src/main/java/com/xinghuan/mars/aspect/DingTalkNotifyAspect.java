package com.xinghuan.mars.aspect;

import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @author shenchen
 * @version 1.0
 * @date 2022/2/8 3:51 下午
 */
@Aspect
@Component
public class DingTalkNotifyAspect {

    /**
     * 声明切入点，所有使用该注解的方法
     */
    @Pointcut(value = "@annotation(com.xinghuan.mars.annotation.DingTalkNotifyAnnotation)")
    public void pointCut() {}

    @Before("")
    public void doBefore() {

    }

    @Around("")
    public void around() {

    }

    @After("")
    public void doAfter() {

    }

}
