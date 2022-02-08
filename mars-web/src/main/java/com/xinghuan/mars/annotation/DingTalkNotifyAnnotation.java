package com.xinghuan.mars.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author shenchen
 * @version 1.0
 * @date 2022/2/8 3:51 下午
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface DingTalkNotifyAnnotation {

    /**
     * 钉钉通知
     *
     * @return
     */
    String message();

}
