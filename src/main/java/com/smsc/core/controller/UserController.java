package com.smsc.core.controller;

import com.smsc.core.model.User;
import com.smsc.core.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    @Autowired private UserService userService;

    @GetMapping
    public User getUser(@Param("userId") String userId) {
        return userService.getOneById(Long.parseLong(userId));
    }

    @GetMapping("/all")
    public List<User> getAll() {
        return userService.getAll();
    }

    @PostMapping
    public User create(@RequestBody User user) {
        return userService.create(user);
    }

    @PutMapping
    public User update(@RequestBody User user) {
        return userService.update(user);
    }

    @DeleteMapping
    public void delete(@Param("userId") String userId) {
        userService.delete(Long.parseLong(userId));
    }
}
