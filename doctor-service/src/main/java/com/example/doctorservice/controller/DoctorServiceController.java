package com.example.doctorservice.controller;

import com.example.doctorservice.dto.approvalDTO;
import com.example.doctorservice.dto.doctorInfoDTO;
import com.example.doctorservice.entity.Doctor;
import com.example.doctorservice.entity.DoctorRepository;
import com.example.doctorservice.entity.S3Repository;
import com.example.doctorservice.services.auxiliaryServiceImpl;
import com.example.doctorservice.services.mongoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.doctorservice.services.auxiliaryService;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping(value = "/")
public class DoctorServiceController {

    @Autowired
    private auxiliaryServiceImpl auxServices;

    @Autowired
    private S3Repository s3Repository ;

    @Autowired
    private mongoService mongoservice;

    @Autowired
    private DoctorRepository doctorRepository;

    /**
     * Endpoint 1 : Register New Doctor
     */
    @PostMapping(value = "doctors", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity newDoctorRegistration(@RequestBody doctorInfoDTO inputDTO){

        if(!auxServices.validateInput(inputDTO)) {
            String errorOutput = "{\"errorCode\" : \"ERR_INVALID_INPUT\" }";
            return new ResponseEntity(errorOutput, HttpStatus.BAD_REQUEST);
        }

        System.out.println("***********Here*************");

        Doctor newDoc = new Doctor(inputDTO);
        Doctor savedDoc = mongoservice.saveOrUpdateDoctor(newDoc);
        System.out.println(savedDoc);

        return new ResponseEntity(inputDTO, HttpStatus.OK);
    }

    /**
     * Endpoint 2 : Upload Files
     */
    @PostMapping("/doctors/{doctorId}/documents")
    public void uploadFiles(@PathVariable("doctorId") String doctorId, @RequestParam MultipartFile[] files) throws IOException
    {
        for(MultipartFile file: files){
            s3Repository.uploadFiles(doctorId, file);
        }
    }

    /**
     * Endpoint 3: Approve Doctor
     */
    @PutMapping("/doctors/{doctorId}/approve")
    public ResponseEntity approveDoctor(@PathVariable("doctorId") String doctorId, @RequestBody approvalDTO inputDTO) throws IOException
    {
        System.out.println("*** INSIDE APPROVE ***");

        Doctor doc = doctorRepository.findDoctorById(doctorId);

        System.out.println(doc);

        if(doc==null)
        {
            String errorOutput = "{\"errorCode\" : \"ERR_INVALID_DOCTOR_ID\" }";
            return new ResponseEntity(errorOutput, HttpStatus.BAD_REQUEST);
        }

        doc.approveDoctor(inputDTO.getApprovedBy(), inputDTO.getApproverComments());
        Doctor savedDoc = mongoservice.saveOrUpdateDoctor(doc);

        return new ResponseEntity(doc, HttpStatus.OK);
    }

    /**
     * Endpoint 4: Reject Doctor
     */
    @PutMapping("/doctors/{doctorId}/reject")
    public ResponseEntity rejectDoctor(@PathVariable("doctorId") String doctorId, @RequestBody approvalDTO inputDTO) throws IOException
    {
        System.out.println("*** INSIDE APPROVE ***");

        Doctor doc = doctorRepository.findDoctorById(doctorId);

        System.out.println(doc);

        if(doc==null)
        {
            String errorOutput = "{\"errorCode\" : \"ERR_INVALID_DOCTOR_ID\" }";
            return new ResponseEntity(errorOutput, HttpStatus.BAD_REQUEST);
        }

        doc.rejectDoctor(inputDTO.getApprovedBy(), inputDTO.getApproverComments());
        Doctor savedDoc = mongoservice.saveOrUpdateDoctor(doc);

        return new ResponseEntity(doc, HttpStatus.OK);
    }

    /**
     * Endpoint 5: Return List of doctors sorted by ratings.
     */
    @GetMapping("/doctors")
    public ResponseEntity getDoctorByStatusAndSpeciality(
            @RequestParam(name="status", required = false) String status,
            @RequestParam(name="speciality", required = false) String speciality)
    {
        if(status == null)
        {
            String errorOutput = "{\"errorCode\" : \"ERR_INVALID_STATUS\" }";
            return new ResponseEntity(errorOutput, HttpStatus.BAD_REQUEST);
        }


        if(speciality == null)
        {
            String errorOutput = "{\"errorCode\" : \"ERR_INVALID_SPECIALITY\" }";
            return new ResponseEntity(errorOutput, HttpStatus.BAD_REQUEST);
        }

        System.out.println(status);
        System.out.println(speciality);

        return new ResponseEntity(HttpStatus.OK);
    }



    /**
     * Endpoint 6: Get Doctors By ID.
     */
    @GetMapping("/doctors/{doctorId}")
    public ResponseEntity getDoctorById(@PathVariable("doctorId") String doctorId)
    {
        Doctor doc = doctorRepository.findDoctorById(doctorId);

        System.out.println(doc);

        if(doc==null)
        {
            String errorOutput = "{\"errorCode\" : \"ERR_INVALID_DOCTOR_ID\" }";
            return new ResponseEntity(errorOutput, HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity(doc, HttpStatus.OK);
    }

}
