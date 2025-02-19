package com.example.spring_boot.controller;

import com.example.spring_boot.DTO.PatientDTO;
import com.example.spring_boot.entity.Patient;
import com.example.spring_boot.service.PatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/patients")
public class PatientController {
    private final PatientService patientService;
    @GetMapping
    public ResponseEntity<Flux<PatientDTO>> getPatients() {
        return ResponseEntity.ok(patientService.getPatients());
    }

    @PostMapping
    public ResponseEntity<Patient> addPatient(@RequestBody Patient patient) {
        return ResponseEntity.ok(patientService.addPatient(patient));
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
    @PutMapping("/{id}")
    public ResponseEntity<Object> updatePatientById(@PathVariable String id, @RequestBody Patient patient) {
        patientService.updatePatient(id, patient);
        Map<String, String> customResponse = new HashMap<>();
        customResponse.put("message", "Updated " + id + " Successfully");
        return ResponseEntity.ok(customResponse);
    }
}
