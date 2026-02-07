package com.witalo.digitalbank.controller;

import com.witalo.digitalbank.dto.user.CreateUserRequestDTO;
import com.witalo.digitalbank.dto.user.UserResponseDTO;
import com.witalo.digitalbank.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UserResponseDTO create(@Valid @RequestBody CreateUserRequestDTO dto) {
        return userService.create(dto);
    }
}
