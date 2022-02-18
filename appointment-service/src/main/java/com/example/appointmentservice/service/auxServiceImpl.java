package com.example.appointmentservice.service;

import com.example.appointmentservice.dto.AppointmentDTO;
import com.example.appointmentservice.dto.AvailabilityDTO;
import com.example.appointmentservice.entity.AppointmentEntity;
import com.example.appointmentservice.entity.AvailabilityEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import com.example.appointmentservice.dto.userInfoDTO;
import org.springframework.web.client.RestTemplate;

@Service
public class auxServiceImpl implements  auxService {

    @Autowired
    private AvailabilityService availabilityService;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private AppointmentService appointmentService;

    public boolean saveAvailability(String doctorId, AvailabilityDTO availabilityDTO)
    {

        Map<String, List<String>> availabilityMap = availabilityDTO.getAvailabilityMap();

        System.out.println(doctorId);

        availabilityMap.forEach((date, timingList) -> {

            for (String time : timingList) {

                AvailabilityEntity availability = new AvailabilityEntity(
                        date, doctorId, false, time);

                availability = availabilityService.saveAvailability(availability);

                System.out.println(availability.toString());
            }

        });

        return true;
    }

    @Override
    public List<AvailabilityEntity> getAppointments(String doctorId) {
        return null;
    }

    @Override
    public AppointmentEntity saveAppointment(AppointmentDTO appointmentDTO) {

        String docId = appointmentDTO.getDoctorId();
        String userId = appointmentDTO.getUserId();

        String paymentUri = "http://localhost:8083/users/" + appointmentDTO.getUserId();;

        userInfoDTO userDTO = restTemplate.getForObject(paymentUri, userInfoDTO.class);
        if(userDTO == null)
            return null;

        AppointmentEntity appointment = new AppointmentEntity(
                appointmentDTO.getAppointmentDate(),
                appointmentDTO.getDoctorId(),
                appointmentDTO.getTimeSlot(),
                appointmentDTO.getUserId(),
                userDTO.getEmailId(),
                userDTO.getFirstName()+" "+userDTO.getLastName(),
                appointmentDTO.getDoctorName());

        appointment = appointmentService.saveAppointment(appointment);

        return appointment;
    }

}
