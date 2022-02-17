package com.example.userservice.services;

import com.example.userservice.entity.User;

public interface mongoService {

    User saveOrUpdateUser(User usr);

}
