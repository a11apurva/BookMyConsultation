package com.example.doctorservice.dto;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Objects;
import java.util.UUID;

public class doctorInfoDTO {

    private String id;
    private String firstName;
    private String lastName;
    private String mobile;
    private String dob;
    private String emailId;
    private String pan;
    private String specialization;
    private String status;
    private String registrationDate;

    public doctorInfoDTO(){
        this.id = UUID.randomUUID().toString();
        this.specialization = "General Physician";
        this.status = "Pending";
        String timeStamp = new SimpleDateFormat("dd-MM-YYYY").format(Calendar.getInstance().getTime());
        this.registrationDate = timeStamp;
    }

    public doctorInfoDTO(String id, String firstName, String lastName, String mobile, String dob, String emailId, String pan, String specialization, String status, String registrationDate) {
        System.out.println("First Constructor");
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.mobile = mobile;
        this.dob = dob;
        this.emailId = emailId;
        this.pan = pan;
        this.specialization = specialization;
        this.status = status;
        this.registrationDate = registrationDate;
    }

    public doctorInfoDTO(String firstName, String lastName, String mobile, String dob, String emailId, String pan, String specialization) {
        System.out.println("Second Constructor");
        this.firstName = firstName;
        this.lastName = lastName;
        this.mobile = mobile;
        this.dob = dob;
        this.emailId = emailId;
        this.pan = pan;
        this.specialization = specialization;
    }
    public doctorInfoDTO(String firstName, String lastName, String mobile, String dob, String emailId, String pan) {
        System.out.println("Third Constructor");
        this.firstName = firstName;
        this.lastName = lastName;
        this.mobile = mobile;
        this.dob = dob;
        this.emailId = emailId;
        this.pan = pan;
    }

    @Override
    public String toString() {
        return "doctorInfoDTO{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", mobile='" + mobile + '\'' +
                ", dob='" + dob + '\'' +
                ", emailId='" + emailId + '\'' +
                ", pan='" + pan + '\'' +
                ", specialization='" + specialization + '\'' +
                ", status='" + status + '\'' +
                ", registrationDate='" + registrationDate + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        doctorInfoDTO that = (doctorInfoDTO) o;
        return id == that.id && Objects.equals(firstName, that.firstName) && Objects.equals(lastName, that.lastName) && Objects.equals(mobile, that.mobile) && Objects.equals(dob, that.dob) && Objects.equals(emailId, that.emailId) && Objects.equals(pan, that.pan) && Objects.equals(specialization, that.specialization) && Objects.equals(status, that.status) && Objects.equals(registrationDate, that.registrationDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, mobile, dob, emailId, pan, specialization, status, registrationDate);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getPan() {
        return pan;
    }

    public void setPan(String pan) {
        this.pan = pan;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(String registrationDate) {
        this.registrationDate = registrationDate;
    }
}
