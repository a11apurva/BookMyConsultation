package com.example.userservice.controller;

import com.example.userservice.dto.userInfoDTO;
import com.example.userservice.entity.S3Repository;
import com.example.userservice.entity.User;
import com.example.userservice.entity.UserRepository;
import com.example.userservice.services.mongoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping(value ="/")
public class UserServiceController {

    @Autowired
    private mongoService mongoservice;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private S3Repository s3Repository ;

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

    /**
     * Endpoint 2: Get User By ID.
     */
    @GetMapping("users/{userId}")
    public ResponseEntity getUserById(@PathVariable("userId") String userId)
    {
        User usr = userRepository.findUserById(userId);

        System.out.println(usr);

        if(usr == null)
        {
            String errorOutput = "{\"errorCode\" : \"ERR_INVALID_USER_ID\" }";
            return new ResponseEntity(errorOutput, HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity(usr, HttpStatus.OK);
    }

    /**
     * Endpoint 3 : Upload Files
     */
    @PostMapping("users/{userId}/documents")
    public ResponseEntity uploadFiles(@PathVariable("userId") String userId, @RequestParam MultipartFile[] files) throws IOException
    {
        for(MultipartFile file: files){
            s3Repository.uploadFiles(userId, file);
        }

        return new ResponseEntity("File(s) uploaded Successfully", HttpStatus.OK);

    }


}
