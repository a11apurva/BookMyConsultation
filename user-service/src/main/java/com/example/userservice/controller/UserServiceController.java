package com.example.userservice.controller;

import com.example.userservice.dto.userInfoDTO;
import com.example.userservice.entity.User;
import com.example.userservice.services.mongoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value ="/")
public class UserServiceController {

    @Autowired
    private mongoService mongoservice;

    /**
     * Endpoint 1 : Register New Doctor
     */
    @PostMapping(value = "users")
    public ResponseEntity newDoctorRegistration(@RequestBody userInfoDTO inputDTO){
        System.out.println("Reached Here");
        System.out.println(inputDTO);

        User newUser =  new User(inputDTO);
        User savedUser = mongoservice.saveOrUpdateUser(newUser);
        System.out.println(savedUser);

        return new ResponseEntity(inputDTO, HttpStatus.OK);
    }


}
