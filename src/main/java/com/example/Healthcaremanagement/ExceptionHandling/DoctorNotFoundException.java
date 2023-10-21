package com.example.Healthcaremanagement.ExceptionHandling;

public class DoctorNotFoundException extends Exception {
    public DoctorNotFoundException(String message) {
        super(message);
    }
}
