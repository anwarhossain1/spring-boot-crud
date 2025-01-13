package com.example.spring_boot.service;

import com.example.spring_boot.CustomNotFoundException;
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
    if (optionalPatient.isPresent()) {
      return modelMapper.map(optionalPatient.get(), Patient.class);
    }
    throw new CustomNotFoundException("Patient with ID " + id + " not found.");
  }

  @Override
  public Patient addPatient(Patient patient) {
    patientRepository.save(patient);
    return patient;
  }

  @Override
  public Patient updatePatient(String id, Patient patient) {
    Optional<Patient> optionalPatient = patientRepository.findById(id);
    System.out.println("dd" + " " + optionalPatient);
    if (optionalPatient.isPresent()) {
      patientRepository.save(patient);
    }
     throw new CustomNotFoundException("Patient with ID " + id + " not found.");
  }

  @Override
  public void deletePatient(String id) {
    patientRepository.deleteById(id);
  }
}
