package com.example.appointmentservice.dto;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Objects;
import java.util.UUID;

public class userInfoDTO {

    private String id;
    private String firstName;
    private String lastName;
    private String mobile;
    private String dob;
    private String emailId;
    private String createdDate;

    public userInfoDTO(){
        this.id = UUID.randomUUID().toString();
        this.createdDate = new SimpleDateFormat("dd-MM-YYYY").format(Calendar.getInstance().getTime());
    }

    public userInfoDTO(String id, String firstName, String lastName, String mobile, String dob, String emailId, String createdDate) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.mobile = mobile;
        this.dob = dob;
        this.emailId = emailId;
        this.createdDate = createdDate;
    }

    @Override
    public String toString() {
        return "userInfoDTO{" +
                "id='" + id + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", mobile='" + mobile + '\'' +
                ", dob='" + dob + '\'' +
                ", emailId='" + emailId + '\'' +
                ", createdDate='" + createdDate + '\'' +
                '}';
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

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        userInfoDTO that = (userInfoDTO) o;
        return Objects.equals(id, that.id) && Objects.equals(firstName, that.firstName) && Objects.equals(lastName, that.lastName) && Objects.equals(mobile, that.mobile) && Objects.equals(dob, that.dob) && Objects.equals(emailId, that.emailId) && Objects.equals(createdDate, that.createdDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, mobile, dob, emailId, createdDate);
    }
}
