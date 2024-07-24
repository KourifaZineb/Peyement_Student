package com.enset.ensetdemopaymentstudent.repository;

import com.enset.ensetdemopaymentstudent.entities.Payment;
import com.enset.ensetdemopaymentstudent.entities.PaymentStatus;
import com.enset.ensetdemopaymentstudent.entities.PaymentType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PaymentRepository extends JpaRepository<Payment, Long> {

    List<Payment> findByStudentCode(String code);
    List<Payment> findByStatus(PaymentStatus status);
    List<Payment> findByType(PaymentType type);
}
