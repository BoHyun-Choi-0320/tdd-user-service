package com.banbi.tdduserservice.user;

import com.banbi.tdduserservice.dto.User;
import com.banbi.tdduserservice.repository.UserRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@AutoConfigureMockMvc
@SpringBootTest
@RunWith(SpringRunner.class)
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    ObjectMapper objectMapper;

    @BeforeEach
    public void insertData() throws Exception {
        for(int i =1 ; i<=10; i++){
            User user = User.builder()
                    .userId("아이디"+i)
                    .userPw("비밀번호"+i)
                    .userName("이름"+i)
                    .build();
            userRepository.save(user);
        }
        this.findUserAll();
    }

    @Test
    public void findUserAll() throws Exception{
        mockMvc.perform(get("/api/users/findUserAll")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .accept(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void findUserById() throws Exception{
        mockMvc.perform(get("/api/users/아이디1")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .accept(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void createUser() throws Exception{
        User user = User.builder()
                .userId("아이디추가")
                .userPw("비밀번호추가")
                .userName("이름추가")
                .build();

        mockMvc.perform(post("/api/users/createUser")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .accept(MediaType.APPLICATION_JSON_VALUE)
                .content(objectMapper.writeValueAsString(user)))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();
    }

    @Test
    public void updateUser() throws Exception{
        User user = User.builder()
                .userId("아이디수정")
                .userPw("비밀번호수정")
                .userName("이름수정").build();

        mockMvc.perform(put("/api/users/update/아이디3")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .accept(MediaType.APPLICATION_JSON_VALUE)
                .content(objectMapper.writeValueAsString(user)))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void deleteUser() throws Exception{
        mockMvc.perform(delete("/api/users/아이디4")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .accept(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isOk());

        this.findUserAll();
    }

}
