package com.example.Healthcaremanagement.ExceptionHandling;

public class PatientNotFoundException extends   Exception {

    public PatientNotFoundException(String message) {
        super(message);
    }
}
