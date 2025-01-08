package com.example.spring_boot.service;

import com.example.spring_boot.entity.Patient;

import java.util.List;

public interface PatientService {
    public List<Patient> getPatients();
    public Patient getPatientById(String id);
    public Patient addPatient(Patient patient);
    public Patient updatePatient(Patient patient);
    public void deletePatient(String id);
}
