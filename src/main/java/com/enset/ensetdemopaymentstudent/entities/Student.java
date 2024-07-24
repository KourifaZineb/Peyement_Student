package com.enset.ensetdemopaymentstudent.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class Student {

    //id, firstName, lastName, email, sa filière, sa photo
    @Id
    private String id;
    @Column(unique = true)
    private String code;
    private String firstName;
    private String lastName;
    private String email;
    private String programId;
    private String photo;
}
