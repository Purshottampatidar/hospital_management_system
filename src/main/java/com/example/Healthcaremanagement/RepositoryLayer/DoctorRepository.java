package com.example.Healthcaremanagement.RepositoryLayer;

import com.example.Healthcaremanagement.Entities.Doctor;
import com.example.Healthcaremanagement.Enums.City;
import com.example.Healthcaremanagement.Enums.Speciality;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor,Integer> {
    List<Doctor> findBySpecialityAndCity(Speciality speciality, City city);

}
