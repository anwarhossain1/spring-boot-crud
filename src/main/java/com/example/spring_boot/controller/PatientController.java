package com.example.spring_boot.controller;

import com.example.spring_boot.entity.Patient;
import com.example.spring_boot.service.PatientService;
import com.example.spring_boot.service.PatientServiceImplements;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class PatientController {
    private final PatientService patientService;
    @GetMapping
    public ResponseEntity<List<Patient>> getPatients() {
        return ResponseEntity.ok(patientService.getPatients());
    }
}
