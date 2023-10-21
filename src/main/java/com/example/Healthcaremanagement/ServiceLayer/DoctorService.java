package com.example.Healthcaremanagement.ServiceLayer;

import com.example.Healthcaremanagement.Entities.Doctor;
import com.example.Healthcaremanagement.ExceptionHandling.DoctorIsAllReadyInDb;
import com.example.Healthcaremanagement.ExceptionHandling.DoctorNotFoundException;
import com.example.Healthcaremanagement.RepositoryLayer.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DoctorService {
    @Autowired
    private DoctorRepository doctorRepository;

    public String addDoctor(Doctor doctor)  throws DoctorIsAllReadyInDb  {
        doctorRepository.save(doctor);
        return "Doctor Added to DataBase";
    }


    public String removeDoctor(Integer doctorId) throws DoctorNotFoundException {
        Optional<Doctor> optionalDoctor=doctorRepository.findById(doctorId);
        if(!optionalDoctor.isPresent()){
            throw new DoctorNotFoundException("Doctor not found in DataBase");
        }
        doctorRepository.delete(optionalDoctor.get());
        return "Doctor Deleted from DataBase";
    }

    public List<Doctor> listOfAllDoctor() {
         return doctorRepository.findAll();
    }

    public Doctor getDoctor(Integer doctorId) throws DoctorNotFoundException {
        Optional<Doctor> optionalDoctor=doctorRepository.findById(doctorId);
        if(!optionalDoctor.isPresent()){
            throw new DoctorNotFoundException("Doctor not found in DataBase");
        }
        return optionalDoctor.get();
    }

}
