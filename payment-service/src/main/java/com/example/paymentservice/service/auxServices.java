package com.example.paymentservice.service;

import com.example.paymentservice.dto.PaymentReturnDTO;

import java.io.IOException;

public interface auxServices {

    PaymentReturnDTO makePayment(String id);

}
