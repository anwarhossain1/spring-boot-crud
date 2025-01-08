package com.example.spring_boot.controller;

import com.example.spring_boot.entity.Patient;
import com.example.spring_boot.service.PatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    @PutMapping("/{id}")
    public ResponseEntity<Object> updatePatientById(@PathVariable String id, @RequestBody Patient patient) {
        patientService.updatePatient(id, patient);
        Map<String, String> response = new HashMap<>();
        response.put("message", "Updated " + id + " Successfully");
        return ResponseEntity.ok(response);
    }
    @PostMapping
    public ResponseEntity<Patient> addPatient(@RequestBody Patient patient) {
        return ResponseEntity.ok(patientService.addPatient(patient));
    }


}
