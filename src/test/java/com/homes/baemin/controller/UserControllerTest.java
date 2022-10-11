package com.homes.baemin.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.homes.baemin.domain.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@ExtendWith(SpringExtension.class)
@AutoConfigureMockMvc //mockMvc 주입시 필요
@SpringBootTest
class UserControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    void 없는_유저_찾기_statusCode_검사() throws Exception {
        mockMvc.perform(get("/users/1"))
                .andExpect(status().isNotFound())
                .andDo(print());
    }

    @Test
    @Transactional
    void 유저_생성_및_찾기_statusCode_검사() throws Exception {
        //given
        User user = new User();
        user.setName("homes");
        user.setPhone(1051939519);

        ObjectMapper objectMapper = new ObjectMapper();
        String userStr = objectMapper.writeValueAsString(user);

        //when
        mockMvc.perform(
                    post("/users")
                    .contentType(MediaType.APPLICATION_JSON)
                    .accept(MediaType.APPLICATION_JSON)
                    .content(userStr)
                )
                .andExpect(status().isCreated())
                .andDo(print());
    }
}