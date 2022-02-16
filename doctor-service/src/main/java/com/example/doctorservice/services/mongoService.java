package com.example.doctorservice.services;

import com.example.doctorservice.entity.Doctor;

public interface mongoService {

    Doctor findByFirstName(String firstName);
    Doctor saveOrUpdateDoctor(Doctor doctor);

}
