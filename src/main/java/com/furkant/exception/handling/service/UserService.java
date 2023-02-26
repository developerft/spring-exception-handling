package com.furkant.exception.handling.service;

import com.furkant.exception.handling.exception.UserAlreadySavedException;
import com.furkant.exception.handling.model.User;
import com.furkant.exception.handling.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    @Transactional
    public void createUser(String userName, String password) {
        var isExistUser = isExistUserByUserName(userName);
        if (isExistUser) {
            throw new UserAlreadySavedException("user already saved. UserId: " + userName);
        } else {
            userRepository.save(getUserEntity(userName, password));
        }
    }

    private boolean isExistUserByUserName(String userName) {
        var user = findByUserName(userName);
        if (Objects.isNull(user)) {
            return false;
        }
        return true;
    }

    private User findByUserName(String userName) {
        return userRepository.findByUserName(userName).orElse(null);
    }

    private User getUserEntity(String userName, String password) {
        return User.builder()
                .userName(userName)
                .password(password)
                .build();
    }
}
