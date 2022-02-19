package com.example.appointmentservice.service;

import com.example.appointmentservice.dto.AvailabilityReturnDTO;
import com.example.appointmentservice.entity.AvailabilityEntity;

import java.util.List;

public interface AvailabilityService {

    public AvailabilityEntity saveAvailability(AvailabilityEntity availability);

    public AvailabilityReturnDTO findAllAvailabilityByDoctorid(String id);
}
