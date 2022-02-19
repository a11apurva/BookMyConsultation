package com.example.appointmentservice.service;

import com.example.appointmentservice.dao.AppointmentDAO;
import com.example.appointmentservice.dao.AvailabilityDao;
import com.example.appointmentservice.entity.AppointmentEntity;
import com.example.appointmentservice.entity.AvailabilityEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AppointmentServiceImpl implements AppointmentService{

    @Autowired
    public AppointmentDAO _appointmentDao;

    public AppointmentEntity saveAppointment(AppointmentEntity appointment){
        return _appointmentDao.save(appointment);
    }

    public AppointmentEntity findById(String id) {

        Optional<AppointmentEntity> obj = _appointmentDao.findById(id);

        if(!obj.isPresent())
            return null;

        return obj.get();
    }
}
