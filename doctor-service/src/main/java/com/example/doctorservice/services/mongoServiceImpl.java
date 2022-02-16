package com.example.doctorservice.services;

import com.example.doctorservice.entity.Doctor;
import com.example.doctorservice.entity.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class mongoServiceImpl implements mongoService{

    @Autowired
    private DoctorRepository doctorRepository;

    @Override
    public Doctor saveOrUpdateDoctor(Doctor doctor) {
        return doctorRepository.save(doctor);
    }

    @Override
    public Doctor findByFirstName(String firstName){ return doctorRepository.findByFirstName(firstName);}
}
