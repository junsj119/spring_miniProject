package com.hanghae.spring_miniProject.controller;

import com.hanghae.spring_miniProject.dto.SignupRequestDto;
import com.hanghae.spring_miniProject.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class UserController {

    private final UserService userService;


    //회원가입
    @PostMapping("/user/signup")
    public String registerUser(@RequestBody SignupRequestDto requestDto) {
        try{
            userService.registerUser(requestDto);
            return "Success";
        }
        catch(IllegalArgumentException e){
            return e.getMessage();

        }
    }
}
