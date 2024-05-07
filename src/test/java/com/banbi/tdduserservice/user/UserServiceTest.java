package com.banbi.tdduserservice.user;

import com.banbi.tdduserservice.Exception.UserErrorResult;
import com.banbi.tdduserservice.Exception.UserException;
import com.banbi.tdduserservice.dto.User;
import com.banbi.tdduserservice.repository.UserRepository;
import com.banbi.tdduserservice.service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @InjectMocks
    private UserService userService;
    @Mock
    private UserRepository userRepository;

    private final String userId = "test";
    private final String userPw = "test";

    @Test
    public void 사용자등록성공(){
        doReturn(null).when(userRepository).findByUserId(userId);
        doReturn(User()).when(userRepository).save(any(User.class));
    }
}
