package com.example.Healthcaremanagement.ControllerLayer;

import com.example.Healthcaremanagement.Entities.Patient;
import com.example.Healthcaremanagement.ServiceLayer.PatientService;
import com.fasterxml.jackson.databind.introspect.TypeResolutionContext;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patient")
public class PatientController {
    @Autowired
    private PatientService patientService;

    @PostMapping("/add-patient")
    public ResponseEntity<String> addPatient(@Valid @RequestBody Patient patient){
        String result=patientService.addPatient(patient);
        return new ResponseEntity<String>(result, HttpStatus.OK);
    }


    @GetMapping("/get-patient/{id}")
    public  ResponseEntity getPatientById(@PathVariable("id") Integer id){
        try{
            Patient patient=patientService.getPatientById(id);
            return new ResponseEntity<Patient>(patient, HttpStatus.OK);
        }
        catch(Exception e){
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/getAllPatients")
    public ResponseEntity getAllPatients(){
        try{
            List<Patient> patientList= patientService.getAllPatients();
            return new ResponseEntity<>(patientList, HttpStatus.OK);
        }
        catch(Exception e){
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/remove-patient/{patientId}")
    public ResponseEntity<String> removePatient(@PathVariable("patientId") Integer patientId){
        try{
            String result=patientService.removePatient(patientId);
            return new ResponseEntity<String>(result, HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }

    }
}
