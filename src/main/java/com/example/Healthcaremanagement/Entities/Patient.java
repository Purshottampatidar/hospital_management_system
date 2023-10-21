package com.example.Healthcaremanagement.Entities;

import com.example.Healthcaremanagement.Enums.City;
import com.example.Healthcaremanagement.Enums.Symptom;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer patientId;

    @Column(name="patientName",nullable = false)
    @Size(min=3,message = "name should be at least 3 characters")
    private String patientName;

//    @Column(name="city", nullable = false)
    @Enumerated(value = EnumType.STRING)
    private City city;

    @Column(name="patientEmailId", nullable = false)
    @Email(message = "Email should be a valid email address")
    private String patientEmailId;

    @Column(name="patientPhoneNumber", nullable = false)
    @Size(min=10,message = "Phone number should be at least 10 characters")
    private String patientPhoneNumber;

    @Column(name="symptom" ,nullable = false)
    @Enumerated(value = EnumType.STRING)
    private Symptom symptom;


}
