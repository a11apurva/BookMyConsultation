package com.example.appointmentservice.service;

import com.example.appointmentservice.entity.AppointmentEntity;
import com.example.appointmentservice.entity.AvailabilityEntity;

import java.util.List;

public interface AppointmentService {

    public AppointmentEntity saveAppointment(AppointmentEntity appointment);

    public AppointmentEntity findById(String id);

    public List<AppointmentEntity> findByUserId(String id);

}
