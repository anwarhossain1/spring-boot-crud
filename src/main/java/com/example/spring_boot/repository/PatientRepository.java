package com.example.spring_boot.repository;

import com.example.spring_boot.entity.Patient;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PatientRepository extends MongoRepository<Patient, UUID> {

}
