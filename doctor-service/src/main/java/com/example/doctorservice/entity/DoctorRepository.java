package com.example.doctorservice.entity;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface DoctorRepository extends MongoRepository<Doctor, String> {

    Doctor findByFirstName(String firstName);

    Doctor findDoctorById(String id);

    List<Doctor> findAllByStatus(String status);

    List<Doctor> findAllByStatusAndSpecialization(String status, String specialization);

}
