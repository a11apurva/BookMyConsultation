package com.example.appointmentservice.controller;

import com.example.appointmentservice.dto.AvailabilityDTO;
import com.example.appointmentservice.service.auxService;
import org.springframework.beans.factory.annotation.Autowired;
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

    /**
     * Endpoint 1: Doctor Availability
     */
    @PostMapping(value = "doctor/{doctorId}/availability", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity newAppointment(@PathVariable("doctorId") String doctorId,
                                         @RequestBody AvailabilityDTO availabilityDTO) {

        System.out.println(availabilityDTO.toString());

        auxservice.saveAppointments(doctorId, availabilityDTO);

        return ResponseEntity.ok().build();
    }

    /**
     * Endpoint 2: Return Doctor Availability
     */
    @GetMapping(value = "doctor/{doctorId}/availability", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity newAppointment2(@PathVariable("doctorId") String doctorId) {

        // auxservice.saveAppointments(doctorId, availabilityDTO);

        return ResponseEntity.ok().build();
    }


}
