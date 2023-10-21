package com.example.Healthcaremanagement.ServiceLayer;

import com.example.Healthcaremanagement.Entities.Doctor;
import com.example.Healthcaremanagement.Entities.Patient;
import com.example.Healthcaremanagement.Enums.City;
import com.example.Healthcaremanagement.Enums.Speciality;
import com.example.Healthcaremanagement.Enums.Symptom;
import com.example.Healthcaremanagement.ExceptionHandling.DoctorNotFoundException;
import com.example.Healthcaremanagement.ExceptionHandling.InvalidCityException;
import com.example.Healthcaremanagement.ExceptionHandling.PatientNotFoundException;
import com.example.Healthcaremanagement.RepositoryLayer.DoctorRepository;
import com.example.Healthcaremanagement.RepositoryLayer.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SuggestionService {
    @Autowired
    private PatientRepository patientRepository;
    @Autowired
    private DoctorRepository doctorRepository;
    public List<Doctor> suggestDoctor(Integer patientId) throws  PatientNotFoundException ,DoctorNotFoundException,InvalidCityException{
        Optional<Patient> optionalPatient = patientRepository.findById(patientId);
        if(!optionalPatient.isPresent()){
            throw new PatientNotFoundException("First Register the Patient");
        }
        Patient patient =optionalPatient.get();
        City city=patient.getCity();
        Symptom symptom = patient.getSymptom();
        if (!city.toString().equals("Delhi") && !city.toString().equals("Noida") && !city.toString().equals("Faridabad")) {
            // Throw an exception with a message
            throw new InvalidCityException("We are still waiting to expand to your location");
        }

        Speciality speciality = getSpecialityBySymptom(symptom);
        List<Doctor> doctors = doctorRepository.findBySpecialityAndCity( speciality,city);
        if (doctors.isEmpty()) {
            // Throw an exception with a message
            throw new DoctorNotFoundException("There isn't any doctor present at your location for your symptom");
        }

        // Return the list of doctors
        return doctors;



    }
    private Speciality getSpecialityBySymptom(Symptom symptom) {
        switch (symptom) {
            case ARTHRITIS:
            case BACK_PAIN:
            case TISSUE_INJURIES:
                return Speciality.ORTHOPEDIC;
            case DYSMENORRHEA:
                return Speciality.GYNECOLOGY;
            case SKIN_INFECTION:
            case SKIN_BURN:
                return Speciality.DERMATOLOGY;
            case EAR_PAIN:
                return Speciality.ENT_SPECIALIST;
            default:
                return null;
        }
    }
}

