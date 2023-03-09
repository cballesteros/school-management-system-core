package com.smsc.core.controller;

import com.smsc.core.model.User;
import com.smsc.core.service.user.UserService;
import jakarta.annotation.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.Param;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/user")
@CrossOrigin(origins = "*", maxAge = 3600)
public class UserController {

    @Autowired private UserService userService;

    @GetMapping("/id")
    public User getOne(@Param("userId") String userId) {
        return userService.getOneById(Long.parseLong(userId));
    }

    @GetMapping("/all")
    @PreAuthorize("hasAuthority('ADMINISTRATOR')")
    public List<User> getAll(@Nullable @RequestParam String role) {
        if (role != null && !role.isBlank()) {
            User.Role roleRequest;
            try {
                roleRequest = User.Role.valueOf(role);
            } catch (IllegalArgumentException e) {
                roleRequest = User.Role.ADMINISTRATOR;
            }
            return userService.getAllByRole(roleRequest);
        }
        return userService.getAll();
    }

    @GetMapping()
    public Page<User> getAll(
            @Nullable @RequestParam String page,
            @Nullable @RequestParam String size,
            @Nullable @RequestParam String sort,
            @Nullable @RequestParam String role,
            @Nullable @RequestParam String orderBy) {
        int pageRequest = Integer.parseInt(Optional.ofNullable(page).orElse("1")) - 1;
        int pageSize = Integer.parseInt(Optional.ofNullable(size).orElse("10"));
        Sort.Direction direction = Sort.Direction.fromString(Optional.ofNullable(sort).orElse("ASC"));
        String property = Optional.ofNullable(orderBy).orElse("id");
        User.Role roleRequest = User.Role.valueOf(Optional.ofNullable(role).orElse(User.Role.ADMINISTRATOR.name()));
        PageRequest request = PageRequest.of(pageRequest, pageSize, direction, property);
        return userService.getPageByRole(roleRequest, request);
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
