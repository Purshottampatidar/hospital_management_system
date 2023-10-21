package com.example.Healthcaremanagement.Entities;

import com.example.Healthcaremanagement.Enums.City;
import com.example.Healthcaremanagement.Enums.Speciality;
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
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer doctorId;

    @Column(name="doctorName",nullable = false)
    @Size(min=3,message = "name should be at least 3 characters")
    private String doctorName;

    @Column(name="emailId",nullable = false)
    @Email(message ="Email should be a valid email address")
    private String emailId;

    @Column(name="phoneNumber",nullable = false)
    @Size(min=10,message = "phone number should be at least 10 characters")
    private String phoneNumber;

    @Column(name="city",nullable = false)
    @Enumerated(value = EnumType.STRING)
    private City city;

    @Column(name="speciality",nullable = false)
    @Enumerated(value = EnumType.STRING)
    private Speciality speciality;



}
