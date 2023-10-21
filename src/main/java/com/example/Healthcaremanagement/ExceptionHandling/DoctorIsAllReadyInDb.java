package com.example.Healthcaremanagement.ExceptionHandling;

public class DoctorIsAllReadyInDb extends Exception{
    public DoctorIsAllReadyInDb(String message){
        super(message);
    }
}
