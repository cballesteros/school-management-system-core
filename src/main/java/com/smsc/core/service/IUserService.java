package com.smsc.core.service;

import com.smsc.core.model.User;

import java.util.List;

public interface IUserService {

    List<User> getAll();

    User getOneById(Long userId);

    User create(User user);

    User update(User user);

    void delete(Long userId);
}
