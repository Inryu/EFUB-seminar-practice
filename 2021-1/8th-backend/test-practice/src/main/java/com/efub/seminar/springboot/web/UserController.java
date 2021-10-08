package com.efub.seminar.springboot.web;

import com.efub.seminar.springboot.domain.User;
import com.efub.seminar.springboot.domain.UserType;
import com.efub.seminar.springboot.service.UserService;
import com.efub.seminar.springboot.web.dto.UserResponseDto;
import com.efub.seminar.springboot.web.dto.UserSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class UserController {
    private final UserService userService;

    @PostMapping("/test/{name}")
    private User save(@PathVariable String name){

        UserSaveRequestDto requestDto=UserSaveRequestDto.builder()
                .name(name)
                .type(UserType.NORMAL)
                .build();

        return userService.save(requestDto);
    }

    @GetMapping("/test/{id}")
    private UserResponseDto findById(@PathVariable Long id){
        return userService.findById(id);
    }

    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    private void userNotFoundHandler(IllegalArgumentException e){}
}
