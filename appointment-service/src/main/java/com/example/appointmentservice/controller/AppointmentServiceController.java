package com.example.appointmentservice.controller;

import com.example.appointmentservice.dto.AppointmentDTO;
import com.example.appointmentservice.dto.AvailabilityDTO;
import com.example.appointmentservice.entity.AppointmentEntity;
import com.example.appointmentservice.entity.Medicine;
import com.example.appointmentservice.entity.Prescription;
import com.example.appointmentservice.exceptions.PaymentException;
import com.example.appointmentservice.service.AppointmentService;
import com.example.appointmentservice.service.auxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/")
public class AppointmentServiceController {

    @Autowired
    public auxService auxservice;

    @Autowired
    public AppointmentService appointmentService;

    /**
     * Endpoint 1: Doctor Availability
     */
    @PostMapping(value = "doctor/{doctorId}/availability", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity newAvailability(@PathVariable("doctorId") String doctorId,
                                         @RequestBody AvailabilityDTO availabilityDTO) {

        System.out.println(availabilityDTO.toString());

        auxservice.saveAvailability(doctorId, availabilityDTO);

        return ResponseEntity.ok().build();
    }

    /**
     * Endpoint 2: Return Doctor Availability
     */
    @GetMapping(value = "doctor/{doctorId}/availability", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getAvailability(@PathVariable("doctorId") String doctorId) {

        // auxservice.saveAppointments(doctorId, availabilityDTO);

        return ResponseEntity.ok().build();
    }

    /**
     * Endpoint 3: Book Appointment
     */
    @PostMapping(value = "appointments", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity newAppointment(@RequestBody AppointmentDTO inputDTO) {

        AppointmentEntity appointment = auxservice.saveAppointment(inputDTO);

        return new ResponseEntity(appointment, HttpStatus.OK);
    }


    /**
     * Endpoint 4: Return Appointment details based on appointmentId
     */
    @GetMapping(value = "appointments/{appId}", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity fetchAppointment(@PathVariable("appId") String appId) {

        AppointmentEntity appointment = auxservice.findById(appId);

        if(appointment == null)
        {
            String errorOutput = "{\"errorCode\" : \"ERR_INVALID_APPOINTMENT_ID\" }";
            return new ResponseEntity(errorOutput, HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity(appointment, HttpStatus.OK);
    }

    /**
     * Endpoint 5: Return Appointment details based on userId
     */
    @GetMapping(value = "users/{userId}/appointments")
    public ResponseEntity fetchAppointmentByUserId(@PathVariable("userId") String userId) {

        List<AppointmentEntity> appointment = appointmentService.findByUserId(userId);
        System.out.println(appointment);

        if(appointment == null)
        {
            String errorOutput = "{\"errorCode\" : \"ERR_INVALID_APPOINTMENT\" }";
            return new ResponseEntity(errorOutput, HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity(appointment, HttpStatus.OK);
    }

    /**
     * Endpoint 6: Prescription
     */
    @PostMapping(value = "prescriptions", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity newPrescription(@RequestBody Prescription prescription) {

        prescription =  auxservice.newPrescription(prescription);

        if(prescription == null)
            throw new PaymentException("errorCode: ERROR_IN_CONNECTION", 400);

        return new ResponseEntity(prescription, HttpStatus.OK);
    }


}
