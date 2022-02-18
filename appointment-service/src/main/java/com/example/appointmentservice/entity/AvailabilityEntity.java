package com.example.appointmentservice.entity;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name="appointment")
public class AvailabilityEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", columnDefinition = "BIGINT")
    private BigInteger id;

    @Column(name = "availability_date", columnDefinition="DATE")
    private String availability_date;

    @Column(name = "doctor_id")
    private String doctor_id;

    @Column(name = "is_booked", columnDefinition="BIT")
    private Boolean is_booked;

    @Column(name = "timeslot")
    private String timeslot;


    public AvailabilityEntity() {}

    public AvailabilityEntity(String availability_date, String doctor_id, Boolean is_booked, String timeslot) {
        this.availability_date = availability_date;
        this.doctor_id = doctor_id;
        this.is_booked = is_booked;
        this.timeslot = timeslot;
    }

    @Override
    public String toString() {
        return "AvailabilityEntity{" +
                "id=" + id +
                ", availability_date=" + availability_date +
                ", doctor_id='" + doctor_id + '\'' +
                ", is_booked=" + is_booked +
                ", timeslot='" + timeslot + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AvailabilityEntity that = (AvailabilityEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(availability_date, that.availability_date) && Objects.equals(doctor_id, that.doctor_id) && Objects.equals(is_booked, that.is_booked) && Objects.equals(timeslot, that.timeslot);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, availability_date, doctor_id, is_booked, timeslot);
    }

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public String getAvailability_date() {
        return availability_date;
    }

    public void setAvailability_date(String availability_date) {
        this.availability_date = availability_date;
    }

    public String getDoctor_id() {
        return doctor_id;
    }

    public void setDoctor_id(String doctor_id) {
        this.doctor_id = doctor_id;
    }

    public Boolean getIs_booked() {
        return is_booked;
    }

    public void setIs_booked(Boolean is_booked) {
        this.is_booked = is_booked;
    }

    public String getTimeslot() {
        return timeslot;
    }

    public void setTimeslot(String timeslot) {
        this.timeslot = timeslot;
    }
}
