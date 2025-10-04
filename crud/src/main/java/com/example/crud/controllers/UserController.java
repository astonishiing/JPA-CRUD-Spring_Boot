package com.example.crud.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
public class UserController {

    @GetMapping
    public ResponseEntity getAllProduct(){
        return ResponseEntity.ok("deu ok");
    }
}
