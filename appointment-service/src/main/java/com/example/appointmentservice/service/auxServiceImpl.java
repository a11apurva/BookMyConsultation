package com.example.appointmentservice.service;

import com.example.appointmentservice.dto.AppointmentDTO;
import com.example.appointmentservice.dto.AvailabilityDTO;
import com.example.appointmentservice.entity.AppointmentEntity;
import com.example.appointmentservice.entity.AvailabilityEntity;
import com.example.appointmentservice.entity.Prescription;
import com.example.appointmentservice.exceptions.PaymentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import com.example.appointmentservice.dto.userInfoDTO;
import org.springframework.web.client.RestTemplate;

@Service
public class auxServiceImpl implements auxService {

    @Autowired
    private AvailabilityService availabilityService;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private AppointmentService appointmentService;

    @Value("${USER_SERVICE_PORT:8082}")
    private String usersvcport;

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

        String userUri = "http://localhost:"+usersvcport+"/users/" + appointmentDTO.getUserId();

        userInfoDTO userDTO;

        try {
            userDTO = restTemplate.getForObject(userUri, userInfoDTO.class);
        }
        catch(Exception e)
        {
            throw new PaymentException("Invalid User", 400);
        }


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

    @Override
    public AppointmentEntity findById(String id) {
        return appointmentService.findById(id);
    }

    @Override
    public Prescription newPrescription(Prescription prescription) {

        AppointmentEntity appointment = findById(prescription.getAppointmentId());

        if(appointment == null)
            throw new PaymentException("errorCode: INVALID_APPOINTMENT_ID", 400);

        System.out.println(appointment.getStatus());

        if(appointment.getStatus().equals("PAYMENT_PENDING"))
            throw new PaymentException("errorCode: PAYMENT_PENDING", 400);

        return appointmentService.saveOrUpdatePrescription(prescription);
    }

}
