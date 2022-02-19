package com.example.appointmentservice.service;

import com.example.appointmentservice.dao.AvailabilityDao;
import com.example.appointmentservice.dto.AvailabilityReturnDTO;
import com.example.appointmentservice.entity.AvailabilityEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AvailabilityServiceImpl implements AvailabilityService{

    @Autowired
    public AvailabilityDao _availabilityDao;

    public AvailabilityEntity saveAvailability(AvailabilityEntity availability){
        return _availabilityDao.save(availability);
    }

    @Override
    public AvailabilityReturnDTO findAllAvailabilityByDoctorid(String id) {

        List<AvailabilityEntity> availabilityEntities= _availabilityDao.findAllByDoctorid(id);

        AvailabilityReturnDTO returnDTO = new AvailabilityReturnDTO();

        returnDTO.setDoctorId(id);

        String date;
        String time;

        for(AvailabilityEntity e : availabilityEntities)
        {
            System.out.println(e);
            date = e.getAvailability_date();
            time = e.getTimeslot();

            if(returnDTO.getAvailabilityMap() == null)
            {
                List<String> timing = new ArrayList<String>();
                timing.add(time);
                Map<String, List<String>> availablityMap = new HashMap<>();
                availablityMap.put(date, timing);
                returnDTO.setAvailabilityMap(availablityMap);
            }
            else
            {
                if(returnDTO.getAvailabilityMap().get(date) == null)
                {
                    List<String> timing = new ArrayList<String>();
                    timing.add(time);
                    returnDTO.getAvailabilityMap().put(date, timing);
                }
                else
                {
                    returnDTO.getAvailabilityMap().get(date).add(time);
                }
            }

            System.out.println(returnDTO);
            System.out.println("---------------------------");
        }

        System.out.println("FINAL DTO:" + returnDTO.toString());

        return returnDTO;
    }


}
