package com.sing3demons.backend.controller;

import com.sing3demons.backend.business.UserBusiness;
import com.sing3demons.backend.exception.BaseException;
import com.sing3demons.backend.models.LoginRequest;
import com.sing3demons.backend.models.MRegisterResponse;
import com.sing3demons.backend.models.RegisterRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
public class UserController {


    private final UserBusiness userBusiness;

    public UserController(UserBusiness userBusiness) {
        this.userBusiness = userBusiness;
    }

    @PostMapping("/register")
    public ResponseEntity<MRegisterResponse> register(@RequestBody RegisterRequest userRequest) throws BaseException {
        MRegisterResponse response = userBusiness.register(userRequest);

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginRequest request) throws BaseException {
        String response = userBusiness.login(request);
        return ResponseEntity.ok(response);
    }
}
