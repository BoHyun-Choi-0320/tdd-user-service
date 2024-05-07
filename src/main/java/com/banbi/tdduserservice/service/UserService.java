package com.banbi.tdduserservice.service;

import com.banbi.tdduserservice.Exception.UserErrorResult;
import com.banbi.tdduserservice.Exception.UserException;
import com.banbi.tdduserservice.dto.User;
import com.banbi.tdduserservice.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public User addUser(final String userId, final String userPw){
        final User result = userRepository.findByUserId(userId);
        if(result!=null){
            throw new UserException(UserErrorResult.DUPLICATED_USER_REGISTER);
        }
        return null;
    }
}
