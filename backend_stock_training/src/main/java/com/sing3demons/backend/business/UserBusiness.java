package com.sing3demons.backend.business;

import com.sing3demons.backend.entity.User;
import com.sing3demons.backend.exception.BaseException;
import com.sing3demons.backend.exception.UserException;
import com.sing3demons.backend.mapper.UserMapper;
import com.sing3demons.backend.models.LoginRequest;
import com.sing3demons.backend.models.MRegisterResponse;
import com.sing3demons.backend.models.RegisterRequest;
import com.sing3demons.backend.service.UserService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserBusiness {
    private final UserService userService;
    private final UserMapper userMapper;

    public UserBusiness(UserService userService, UserMapper userMapper) {
        this.userService = userService;
        this.userMapper = userMapper;
    }

    public MRegisterResponse register(RegisterRequest request) throws BaseException {
        User user = userService.create(request);
        return userMapper.toRegisterResponse(user);
    }

    public String login(LoginRequest request) throws BaseException {
        Optional<User> opt = userService.findByEmail(request.getEmail());

        if (opt.isEmpty()) {
            throw UserException.loginFailEmailNotFound();
        }

        User user = opt.get();
        if (!userService.matchPassword(request.getPassword(), user.getPassword())) {
            throw UserException.loginFailPasswordIncorrect();
        }


        String token = "jwt";
        return token;
    }
}
