package com.example.doctorservice.controller;

import com.example.doctorservice.dto.doctorInfoDTO;
import com.example.doctorservice.entity.Doctor;
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

    @PostMapping("/doctors/{doctorId}/documents")
    public void uploadFiles(@PathVariable("doctorId") String doctorId, @RequestParam MultipartFile[] files) throws IOException
    {
        for(MultipartFile file: files){
            s3Repository.uploadFiles(doctorId, file);
        }
    }

}
