package com.example.appointmentservice.service;

import com.example.appointmentservice.entity.AppointmentEntity;
import com.example.appointmentservice.entity.AvailabilityEntity;

public interface AppointmentService {

    public AppointmentEntity saveAppointment(AppointmentEntity appointment);
}
