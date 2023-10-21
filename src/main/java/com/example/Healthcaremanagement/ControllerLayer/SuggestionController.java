package com.example.Healthcaremanagement.ControllerLayer;

import com.example.Healthcaremanagement.Entities.Doctor;
import com.example.Healthcaremanagement.ServiceLayer.SuggestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/suggestDoctor")
public class SuggestionController {
    @Autowired
    private SuggestionService suggestionService;

    @GetMapping("/suggest-doctor/{patientId}")
    public ResponseEntity suggestDoctor(@PathVariable Integer patientId) {
        try{
            List<Doctor> list= suggestionService.suggestDoctor(patientId);
            return new ResponseEntity<>(list, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }

    }
}
