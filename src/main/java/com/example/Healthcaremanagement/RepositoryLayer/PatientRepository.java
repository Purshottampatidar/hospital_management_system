package com.example.Healthcaremanagement.RepositoryLayer;

import com.example.Healthcaremanagement.Entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends JpaRepository<Patient,Integer> {

}

