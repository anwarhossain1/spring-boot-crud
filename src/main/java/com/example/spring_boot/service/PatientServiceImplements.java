package com.example.spring_boot.service;

import com.example.spring_boot.entity.Patient;
import com.example.spring_boot.repository.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@RequiredArgsConstructor
@Service

public class PatientServiceImplements implements PatientService {
    private final PatientRepository patientRepository;
    @Override
    public List<Patient> getPatients() {
        return patientRepository.findAll() ;
    }

    @Override
    public Patient getPatientById(String id) {
        return null;
    }

    @Override
    public Patient addPatient(Patient patient) {
        return null;
    }

    @Override
    public Patient updatePatient(Patient patient) {
        return null;
    }

    @Override
    public void deletePatient(String id) {

    }
}
