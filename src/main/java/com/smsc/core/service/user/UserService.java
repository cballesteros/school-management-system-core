package com.smsc.core.service.user;

import com.smsc.core.model.User;
import com.smsc.core.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUserService {

    @Autowired private UserRepository userRepository;
    @Autowired private PasswordEncoder passwordEncoder;

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public List<User> getAllByRole(User.Role role) {
        return userRepository.findByRole(role);
    }

    @Override
    public Page<User> getPage(Pageable pageable) {
        return  userRepository.findAll(pageable);
    }

    @Override
    public Page<User> getPageByRole(User.Role role, Pageable pageable) {
        return  userRepository.findByRole(role, pageable);
    }

    @Override
    public User getOneById(Long userId) {
        return userRepository.findById(userId).orElse(null);
    }

    @Override
    public User create(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    @Override
    public User update(User user) {
        User oldUser = getOneById(user.getId());
        if (!oldUser.getPassword().equals(user.getPassword())) {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
        }
        return userRepository.saveAndFlush(user);
    }

    @Override
    public void delete(Long userId) {
        userRepository.deleteById(userId);
    }

    @Override
    public Boolean existsByUsername(String username) {
        return userRepository.existsByUsername(username);
    }

    @Override
    public Boolean existsByEmail(String email) {
        return userRepository.existsByEmail(email);
    }
}
