package com.example.paymentservice.dao;

import com.example.paymentservice.entity.AppointmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface AppointmentDAO extends JpaRepository<AppointmentEntity, String> {

    @Modifying
    @Query("update AppointmentEntity app set app.status = 'Confirmed' where app.appointment_id = ?1")
    int updatePaymentStatus(String id);

}
