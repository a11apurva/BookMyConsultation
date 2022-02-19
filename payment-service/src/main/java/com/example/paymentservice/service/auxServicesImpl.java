package com.example.paymentservice.service;

import com.example.paymentservice.dao.AppointmentDAO;
import com.example.paymentservice.dto.PaymentReturnDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.UUID;

@Service
public class auxServicesImpl implements auxServices{

    @Autowired
    private AppointmentDAO _appointmentDAO;

    @Transactional
    @Override
    public PaymentReturnDTO makePayment(String id)
    {
        if(_appointmentDAO.updatePaymentStatus(id) == 1)
        {
            PaymentReturnDTO paymentReturnDTO = new PaymentReturnDTO();
            paymentReturnDTO.setId(UUID.randomUUID().toString());
            paymentReturnDTO.setAppointmentId(id);
            paymentReturnDTO.setCreatedDate(new SimpleDateFormat("dd-MM-YYYY hh:mm:ss").format(Calendar.getInstance().getTime()));
            return paymentReturnDTO;
        }

        return null;
    }

}
