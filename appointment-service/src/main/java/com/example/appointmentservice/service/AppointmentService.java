package com.example.appointmentservice.service;

import com.example.appointmentservice.entity.AppointmentEntity;
import com.example.appointmentservice.entity.AvailabilityEntity;
import com.example.appointmentservice.entity.Prescription;
import com.example.appointmentservice.entity.PrescriptionRepository;

import java.util.List;

public interface AppointmentService {

    public AppointmentEntity saveAppointment(AppointmentEntity appointment);

    public AppointmentEntity findById(String id);

    public List<AppointmentEntity> findByUserId(String id);

    Prescription saveOrUpdatePrescription(Prescription prescription);

}
