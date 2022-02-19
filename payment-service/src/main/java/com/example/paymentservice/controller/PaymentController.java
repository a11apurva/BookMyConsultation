package com.example.paymentservice.controller;

import com.example.paymentservice.dao.AppointmentDAO;
import com.example.paymentservice.dto.PaymentReturnDTO;
import com.example.paymentservice.service.auxServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/")
public class PaymentController {

    @Autowired
    private auxServices _auxServices;


    /**
     * Endpoint 1: Make Payment
     */
    @GetMapping(value = "payments")
    public ResponseEntity getAvailability(@RequestParam(name="appointmentId", required = true) String appointmentId) {

        PaymentReturnDTO returnDTO = _auxServices.makePayment(appointmentId);

        if(returnDTO == null)
        {
            String errorOutput = "{\"errorCode\" : \"ERR_INVALID_APPOINTMENT_ID\" }";
            return new ResponseEntity(errorOutput, HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<PaymentReturnDTO>(returnDTO, HttpStatus.OK);
    }


}
