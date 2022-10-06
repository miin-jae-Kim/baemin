package com.homes.baemin.service;

import com.homes.baemin.domain.User;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@Transactional
class UserServiceTest {

    @Autowired
    private UserService userService;

    @Test
    void 회원가입() {
        //given
        User user = new User();
        user.setName("homes");
        user.setPhone(1051939519);

        //when
        userService.saveUser(user);

        //then
        User user2 = userService.findUserById(user.getId());
        assertThat(user2.getId()).isEqualTo(1);
        assertThat(user2.getName()).isEqualTo("homes");
        assertThat(user2.getPhone()).isEqualTo(1051939519);
    }
}