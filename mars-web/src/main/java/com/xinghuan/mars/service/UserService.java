package com.xinghuan.mars.service;

import com.xinghuan.mars.entity.User;

/**
 * @author xinghuan
 * @version 1.0
 * @date 2021/12/20 3:31 下午
 */
public interface UserService {

    /**
     * 创建用户
     *
     * @param user
     * @return
     */
    Integer createUser(User user);

    /**
     * 根据用户ID删除用户
     *
     * @param id
     * @return
     */
    Integer deleteUser(int id);

    /**
     * 更新用户
     *
     * @param user
     * @return
     */
    Integer updateUser(User user);

    /**
     * 根据用户ID查询用户
     *
     * @param id
     * @return
     */
    User getUserById(int id);

}
