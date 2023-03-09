package com.smsc.core.service.user;

import com.smsc.core.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IUserService {

    List<User> getAll();

    List<User> getAllByRole(User.Role role);

    Page<User> getPage(Pageable pageable);

    Page<User> getPageByRole(User.Role role, Pageable pageable);

    User getOneById(Long userId);

    User create(User user);

    User update(User user);

    void delete(Long userId);

    Boolean existsByUsername(String username);

    Boolean existsByEmail(String email);
}
