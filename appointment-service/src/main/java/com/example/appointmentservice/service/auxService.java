package com.example.appointmentservice.service;

import com.example.appointmentservice.dto.AppointmentDTO;
import com.example.appointmentservice.dto.AvailabilityDTO;
import com.example.appointmentservice.entity.AppointmentEntity;
import com.example.appointmentservice.entity.AvailabilityEntity;
import com.example.appointmentservice.entity.Prescription;

import java.util.List;

public interface auxService {

    public boolean saveAvailability(String doctorId, AvailabilityDTO availabilityDTO);

    public List<AvailabilityEntity> getAppointments(String doctorId);

    public AppointmentEntity saveAppointment(AppointmentDTO appointmentDTO);

    public AppointmentEntity findById(String id);

    public Prescription newPrescription(Prescription prescription);

}
