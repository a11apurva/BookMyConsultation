package com.example.appointmentservice.service;

import com.example.appointmentservice.dao.AvailabilityDao;
import com.example.appointmentservice.entity.AvailabilityEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AvailabilityServiceImpl implements AvailabilityService{

    @Autowired
    public AvailabilityDao _availabilityDao;

    public AvailabilityEntity saveAvailability(AvailabilityEntity availability){
        return _availabilityDao.save(availability);
    }


}
