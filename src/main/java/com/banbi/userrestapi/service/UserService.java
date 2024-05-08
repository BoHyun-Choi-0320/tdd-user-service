package com.banbi.userrestapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.banbi.userrestapi.dto.User;
import com.banbi.userrestapi.repository.UserRepository;

import lombok.NoArgsConstructor;

@Service
@NoArgsConstructor
public class UserService {

    private UserRepository userRepository;

    @Transactional
    public Object findAllUser(){
        List<User> users = userRepository.findAll();
        return users;
    }

    @Transactional
    public User findUserById(String userId){
        User user = userRepository.findByUserId(userId);
        return user;
    }

    @Transactional
    public void createUser(String userId, String userPw, String userName){
        User user = User.builder()
        .userId(userId)
        .userPw(userPw)
        .userName(userName)
        .build();
        userRepository.save(user);
    }

    @Transactional
    public void updateUser(String userPw, String userName){

    }

    @Transactional
    public void deleteUser(String userId){
        User user = userRepository.findByUserId(userId);
        if(user!=null){
            userRepository.delete(user);
        }
    }

    
}
