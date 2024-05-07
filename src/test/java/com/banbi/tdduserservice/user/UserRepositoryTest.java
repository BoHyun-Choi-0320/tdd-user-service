package com.banbi.tdduserservice.user;

import com.banbi.tdduserservice.dto.User;
import com.banbi.tdduserservice.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

//    @Test
//    public void UserRepository가Null이아님(){
//        assertThat(userRepository).isNotNull();
//    }

    @Test
    public void 사용자입력(){
        final User user = User.builder()
                .userId("test")
                .userPw("test")
                .build();

        final User result = userRepository.save(user);

        assertThat(result.getId()).isNotNull();
        assertThat(result.getUserId()).isEqualTo("test");
        assertThat(result.getUserPw()).isEqualTo("test");
    }

}
