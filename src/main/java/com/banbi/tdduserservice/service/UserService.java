package com.banbi.tdduserservice.service;

import com.banbi.tdduserservice.dto.User;
import com.banbi.tdduserservice.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }


    @Transactional
    public Object findUserAll(){
        List<User> users = userRepository.findAll();
        return users;
    }

    @Transactional
    public Object findUserById(String userId){
        Optional<User> user = userRepository.findByUserId(userId);
        return user;
    }

    @Transactional
    public Object createUser(User user){
        return userRepository.save(user);
    }

    @Transactional
    public Object updateUser(User user){
        return userRepository.save(user);
    }

    @Transactional
    public void delete(String userId){
        userRepository.deleteByUserId(userId);
    }
}
