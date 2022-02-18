package com.example.appointmentservice.service;

import com.example.appointmentservice.dto.AvailabilityDTO;
import com.example.appointmentservice.entity.AvailabilityEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class auxServiceImpl implements  auxService {

    @Autowired
    private AvailabilityService availabilityService;

    public boolean saveAppointments(String doctorId, AvailabilityDTO availabilityDTO)
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

}
