package com.enset.ensetdemopaymentstudent.entities;

import jakarta.persistence.*;
import lombok.*;

import java.lang.reflect.Type;
import java.time.LocalDate;
import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class Payment {

    //id, son code, sa date, son type (CASH, CHECK,TRANSFER), son status
    // (CREATED, VALIDATED, REJECTED), file (fichier pdf représentant le reçu de payement)

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate date;
    private PaymentType type;
    private PaymentStatus status;
    private String file;
    private double amount;
    @ManyToOne
    private Student student;
}
