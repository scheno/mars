package com.xinghuan.mars.web;

import com.xinghuan.mars.entity.User;
import com.xinghuan.mars.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author xinghuan
 * @version 1.0
 * @date 2021/12/20 3:31 下午
 */
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/user")
    public Integer createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    @GetMapping("/user/{id}")
    public User getUserById(@PathVariable int id) {
        return userService.getUserById(id);
    }

    @PutMapping("/user")
    public Integer updateUser(@RequestBody User user) {
        return userService.updateUser(user);
    }

    @DeleteMapping("/user/{id}")
    public Integer deleteUser(@PathVariable int id) {
        return userService.deleteUser(id);
    }

}
