package com.example.spring_boot.repository;

import com.example.spring_boot.entity.Patient;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface PatientRepoReactive extends ReactiveCrudRepository<Patient, Long> {
}
