package com.medeirosdev.desafio_picpay.controller;


import com.medeirosdev.desafio_picpay.dtos.UserCreateDTO;
import com.medeirosdev.desafio_picpay.dtos.UserResponseDTO;
import com.medeirosdev.desafio_picpay.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<List<UserResponseDTO>> createUser(@RequestBody List<UserCreateDTO> dtos){

        return ResponseEntity.ok(userService.createUser(dtos));

    }

    @GetMapping
    public ResponseEntity<List<UserResponseDTO>> getAllUsers(){

        return ResponseEntity.ok(userService.getAllUser());

    }

}
