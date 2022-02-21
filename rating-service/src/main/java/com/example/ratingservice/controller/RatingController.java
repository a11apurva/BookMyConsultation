package com.example.ratingservice.controller;

import com.example.ratingservice.dto.RatingDTO;
import com.example.ratingservice.entity.Rating;
import com.example.ratingservice.entity.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/")
public class RatingController {

    @Autowired
    public RatingRepository _ratingRepository;

    /**
     * Endpoint 1: Doctor Availability
     */
    @PostMapping(value = "ratings", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity newRating(@RequestBody RatingDTO ratingDTO) {

        System.out.println(ratingDTO.toString());

        Rating newRating = new Rating(ratingDTO);
        Rating savedRating = _ratingRepository.save(newRating);

        return new ResponseEntity<Rating>(savedRating, HttpStatus.OK) ;
    }


}
