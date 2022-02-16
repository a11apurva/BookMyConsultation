package com.example.doctorservice.services;

import com.example.doctorservice.entity.Doctor;

import java.util.List;

public interface mongoService {

    Doctor findByFirstName(String firstName);
    Doctor saveOrUpdateDoctor(Doctor doctor);
    List<Doctor> findByStatus(String status);
    List<Doctor> findAllByStatusAndSpecialization(String status, String specialization);

}
