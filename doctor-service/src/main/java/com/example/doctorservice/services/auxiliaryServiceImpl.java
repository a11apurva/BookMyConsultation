package com.example.doctorservice.services;

import com.example.doctorservice.dto.doctorInfoDTO;
import org.springframework.stereotype.Service;
import org.springframework.util.NumberUtils;

@Service
public class auxiliaryServiceImpl implements auxiliaryService {

    public Boolean validateInput(doctorInfoDTO info){

        if(info.getFirstName().length() > 20 || info.getFirstName().length()<1)
            return false;

        if(info.getLastName().length() > 20)
            return false;

        if(info.getMobile().length() != 10 || !info.getMobile().matches("[0-9]+"))
            return false;

        //if(!info.getPan().matches("^(?=.*[a-zA-Z])(?=.*[0-9])"))
        //    return false;

        return true;

    }

}
