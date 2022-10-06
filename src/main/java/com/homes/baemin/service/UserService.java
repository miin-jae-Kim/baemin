package com.homes.baemin.service;

import com.homes.baemin.domain.User;
import com.homes.baemin.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class UserService {

    private final UserRepository userRepository;

    @Transactional(readOnly = true)
    public User findUserById(Long userId) {
        return userRepository.findById(userId);
    };

    public void saveUser(User user) {
        userRepository.save(user);
    }
}
