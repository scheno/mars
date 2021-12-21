package com.xinghuan.mars.service.impl;

import com.xinghuan.mars.entity.User;
import com.xinghuan.mars.repository.UserRepository;
import com.xinghuan.mars.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.redisson.api.RBucket;
import org.redisson.api.RMap;
import org.redisson.api.RObject;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

/**
 * @author shenchen
 * @version 1.0
 * @date 2021/12/20 3:40 下午
 */
@Slf4j
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RedissonClient redissonClient;

    @Override
    public Integer createUser(User user) {
        return null;
    }

    @Override
    public Integer deleteUser(int id) {
        RBucket<User> userRBucket = redissonClient.getBucket("user:" + id);
        if (userRBucket.isExists()) {
            userRBucket.delete();
        }
        return null;
    }

    @Override
    public Integer updateUser(User user) {
        return null;
    }

    @Override
    public User getUserById(int id) {
        RBucket<User> userRBucket = redissonClient.getBucket("user:" + id);
        long startTime = System.currentTimeMillis();
        if (userRBucket.isExists()) {
            log.info("使用了缓存,消耗时间{}ms", System.currentTimeMillis() - startTime);
            return userRBucket.get();
        }
        User user = userRepository.getUserById(id);
        if (user != null) {
            userRBucket.set(user);
        }
        long endTime = System.currentTimeMillis();
        log.info("未使用缓存,消耗时间{}ms", endTime - startTime);
        return user;
    }
}
