package com.xinghuan.mars.code.aop.aspectj;

import org.springframework.stereotype.Service;

/**
 * @author shenchen
 * @version 1.0
 * @date 2023/6/1 16:37
 */
//@Service
public class FruitsServiceImpl implements FruitsService {

    /**
     * 获取水果名称
     *
     * @param name 水果名称
     * @return 水果名称
     */
    @Override
    public String getName(String name) {
        return name;
    }

}
