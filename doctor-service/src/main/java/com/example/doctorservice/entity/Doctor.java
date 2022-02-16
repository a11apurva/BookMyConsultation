package com.example.doctorservice.entity;

import com.example.doctorservice.dto.doctorInfoDTO;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Document(collection = "Doctor")
public class Doctor {

    @Id
    private String id;

    private String firstName;
    private String lastName;
    private String mobile;
    private String dob;
    private String emailId;
    private String pan;
    private String specialization;

    private String status;
    private String registrationDate;

    private String approvedBy;
    private String approverComments;
    private String verificationDate;

    public Doctor(String id, String firstName, String lastName, String mobile, String dob, String emailId, String pan, String specialization, String status, String registrationDate, String approvedBy, String approverComments, String verificationDate) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.mobile = mobile;
        this.dob = dob;
        this.emailId = emailId;
        this.pan = pan;
        this.specialization = specialization;
        this.status = status;
        this.registrationDate = registrationDate;
        this.approvedBy = approvedBy;
        this.approverComments = approverComments;
        this.verificationDate = verificationDate;
    }

    public Doctor(doctorInfoDTO doctorInfoDTO) {
        this.id = doctorInfoDTO.getId();
        this.firstName = doctorInfoDTO.getFirstName();
        this.lastName = doctorInfoDTO.getLastName();
        this.mobile = doctorInfoDTO.getMobile();
        this.dob = doctorInfoDTO.getDob();
        this.emailId = doctorInfoDTO.getEmailId();
        this.pan = doctorInfoDTO.getPan();
        this.specialization = doctorInfoDTO.getSpecialization();
        this.status = doctorInfoDTO.getStatus();
        this.registrationDate = doctorInfoDTO.getRegistrationDate();
        this.approvedBy = "Pending";
        this.approverComments = "Pending";
        this.verificationDate = "Pending";
    }



}
