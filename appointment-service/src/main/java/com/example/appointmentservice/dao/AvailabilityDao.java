package com.example.appointmentservice.dao;

import com.example.appointmentservice.entity.AvailabilityEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AvailabilityDao extends JpaRepository<AvailabilityEntity, Integer> {

}
