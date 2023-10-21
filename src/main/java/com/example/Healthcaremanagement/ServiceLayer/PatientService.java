package com.example.Healthcaremanagement.ServiceLayer;

import com.example.Healthcaremanagement.Entities.Patient;
import com.example.Healthcaremanagement.ExceptionHandling.PatientNotFoundException;
import com.example.Healthcaremanagement.RepositoryLayer.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatientService {
    @Autowired
    private PatientRepository patientRepository;
    public String addPatient(Patient patient) {
        patientRepository.save(patient);
        return "Patient added to DataBase";
    }

    public Patient getPatientById(Integer id) throws PatientNotFoundException {
        Optional<Patient> optionalPatient=patientRepository.findById(id);
        if(!optionalPatient.isPresent()) {
            throw new PatientNotFoundException("Patient not found");
        }
        return optionalPatient.get();
    }

    public List<Patient> getAllPatients() throws PatientNotFoundException {
        List<Patient> patientList=patientRepository.findAll();
        if(patientList.isEmpty()){
            throw new PatientNotFoundException("patient not found");
        }
        return patientList;

    }

    public String removePatient(Integer patientId) throws PatientNotFoundException{
        Optional<Patient> optionalPatient=patientRepository.findById(patientId);
        if(!optionalPatient.isPresent()){
            throw new PatientNotFoundException("patient not found in database");
        }
        Patient patient=optionalPatient.get();
        patientRepository.delete(patient);
        return "Patient removed from DataBase";
    }
}
