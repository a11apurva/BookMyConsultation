package com.example.userservice.services;

import com.example.userservice.entity.User;
import com.example.userservice.entity.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class mongoServiceImpl implements mongoService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User saveOrUpdateUser(User usr){
        return userRepository.save(usr);
    }


}
