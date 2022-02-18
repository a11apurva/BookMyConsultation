package com.example.appointmentservice.service;

import com.example.appointmentservice.dto.AvailabilityDTO;
import com.example.appointmentservice.entity.AvailabilityEntity;

import java.util.List;

public interface auxService {

    public boolean saveAppointments(String doctorId, AvailabilityDTO availabilityDTO);

    public List<AvailabilityEntity> getAppointments(String doctorId);

}
