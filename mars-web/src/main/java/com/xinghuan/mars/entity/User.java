package com.xinghuan.mars.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @author xinghuan
 * @version 1.0
 * @date 2021/12/20 3:34 下午
 */
@Data
public class User implements Serializable {

    private Integer id;

    private String username;

    private String password;

    private String realName;

}
