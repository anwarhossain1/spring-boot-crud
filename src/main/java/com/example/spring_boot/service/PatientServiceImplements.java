package com.example.spring_boot.service;

import com.example.spring_boot.DTO.PatientDTO;
import com.example.spring_boot.entity.Patient;
import com.example.spring_boot.repository.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;


@RequiredArgsConstructor
@Service
public class PatientServiceImplements implements PatientService {
  private final PatientRepository patientRepository;
  private final ModelMapper modelMapper;
  @Override
  public List<PatientDTO> getPatients() {

    return patientRepository.findAll().stream().map(x -> modelMapper.map(x, PatientDTO.class)).collect(Collectors.toList());
  }

  @Override
  public Patient getPatientById(String id) {
    Optional<Patient> optionalPatient = patientRepository.findById(id);
    if (!optionalPatient.isPresent()) {
      throw new NoSuchElementException("Patient with ID " + id + " not found.");
    }
    return optionalPatient.orElse(null); // Return null if not found
  }

  @Override
  public Patient addPatient(Patient patient) {
    patientRepository.save(patient);
    return patient;
  }

  @Override
  public Patient updatePatient(String id, Patient patient) {
    Optional<Patient> optionalPatient = patientRepository.findById(id);
    if (optionalPatient.isPresent()) {
      patientRepository.save(patient);
    }
    return null;
  }

  @Override
  public void deletePatient(String id) {
    patientRepository.deleteById(id);
  }
}
