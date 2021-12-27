package com.xinghuan.mars.repository;

import com.xinghuan.mars.entity.User;
import org.springframework.stereotype.Repository;

/**
 * @author xinghuan
 * @version 1.0
 * @date 2021/12/20 3:31 下午
 */
@Repository
public interface UserRepository {

    /**
     * 根据用户ID查询用户
     *
     * @param id
     * @return
     */
    User getUserById(int id);

    /**
     * 添加用户
     *
     * @param user
     * @return
     */
    int saveUser(User user);

    /**
     * 更新用户
     *
     * @param user
     * @return
     */
    int updateUser(User user);

}
