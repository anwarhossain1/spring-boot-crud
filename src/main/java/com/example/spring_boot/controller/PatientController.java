package com.example.spring_boot.controller;

import com.example.spring_boot.entity.Patient;
import com.example.spring_boot.service.PatientService;
import com.example.spring_boot.service.PatientServiceImplements;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    @GetMapping("/{id}")
    public ResponseEntity<Patient> getPatientById(@PathVariable String id) {
        return ResponseEntity.ok(patientService.getPatientById(id));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePatientById(@PathVariable String id) {
        patientService.getPatientById(id);
        return ResponseEntity.ok("Deleted " + id + " Successfully");
    }

}
