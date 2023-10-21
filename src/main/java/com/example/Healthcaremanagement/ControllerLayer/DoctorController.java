package com.example.Healthcaremanagement.ControllerLayer;

import com.example.Healthcaremanagement.Entities.Doctor;
import com.example.Healthcaremanagement.ServiceLayer.DoctorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/doctor")
public class DoctorController {
    @Autowired
    private DoctorService doctorService;

    @PostMapping("/add-doctor")
    public ResponseEntity<String> addDoctor(@Valid @RequestBody Doctor doctor){

            try{
                String result=doctorService.addDoctor(doctor);
                return new  ResponseEntity<>(result, HttpStatus.OK);
            }
            catch (Exception e){
                return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
            }
    }

    @GetMapping("/getDoctor/{id}")
    public ResponseEntity getDoctor(@PathVariable("id") Integer id){
        try{
            Doctor doctor=doctorService.getDoctor(id);
            return new  ResponseEntity(doctor, HttpStatus.OK);
        }
        catch(Exception e){
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }

    }


    @GetMapping("/listOfAllDoctor")
    public ResponseEntity<List<Doctor>> listOfAllDoctor(){
        List<Doctor> listDoctor=doctorService.listOfAllDoctor();
        return new ResponseEntity<>(listDoctor, HttpStatus.OK);
    }

    @DeleteMapping("/remove-doctor/{id}")
    public ResponseEntity<String> removeDoctor(@PathVariable("id") Integer id){
        try{
            String result=doctorService.removeDoctor(id);
            return new  ResponseEntity<>(result, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }

    }
}
