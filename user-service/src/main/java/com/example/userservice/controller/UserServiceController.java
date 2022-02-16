package com.example.userservice.controller;

import com.example.userservice.dto.userInfoDTO;
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

    /**
     * Endpoint 1 : Register New Doctor
     */
    @PostMapping(value = "users")
    public ResponseEntity newDoctorRegistration(@RequestBody userInfoDTO inputDTO){
        System.out.println("Reached Here");
        System.out.println(inputDTO);
        return new ResponseEntity(inputDTO, HttpStatus.OK);
    }


}
