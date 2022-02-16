package com.example.doctorservice.services;

import com.example.doctorservice.entity.Doctor;
import com.example.doctorservice.entity.DoctorRepository;
import com.mongodb.client.MongoCursor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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

    @Override
    public List<Doctor> findByStatus(String status)
    {
        return doctorRepository.findAllByStatus(status);
    }

    @Override
    public List<Doctor> findAllByStatusAndSpecialization(String status, String specialization)
    {
        return doctorRepository.findAllByStatusAndSpecialization(status, specialization);
    }

}
