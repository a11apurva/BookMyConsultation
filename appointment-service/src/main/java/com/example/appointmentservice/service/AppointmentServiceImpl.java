package com.example.appointmentservice.service;

import com.example.appointmentservice.dao.AppointmentDAO;
import com.example.appointmentservice.dao.AvailabilityDao;
import com.example.appointmentservice.entity.AppointmentEntity;
import com.example.appointmentservice.entity.AvailabilityEntity;
import com.example.appointmentservice.entity.Prescription;
import com.example.appointmentservice.entity.PrescriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AppointmentServiceImpl implements AppointmentService{

    @Autowired
    public AppointmentDAO _appointmentDao;

    @Autowired
    public PrescriptionRepository prescriptionRepository;

    public AppointmentEntity saveAppointment(AppointmentEntity appointment){
        return _appointmentDao.save(appointment);
    }

    public AppointmentEntity findById(String id) {

        Optional<AppointmentEntity> obj = _appointmentDao.findById(id);

        if(!obj.isPresent())
            return null;

        return obj.get();
    }

    public List<AppointmentEntity> findByUserId(String id){
        return _appointmentDao.findByUserid(id);
    }

    public Prescription saveOrUpdatePrescription(Prescription prescription){
        return prescriptionRepository.save(prescription);
    }
}
