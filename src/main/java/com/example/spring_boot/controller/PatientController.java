package com.example.spring_boot.controller;

import com.example.spring_boot.entity.Patient;
import com.example.spring_boot.service.PatientService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@RequestMapping("/api")
public class PatientController {
    private PatientService patientService;
    @GetMapping
    //ResponseEntity<List<Patient>>
    public String getPatients() {
        return "patients";
        //return ResponseEntity.ok(patientService.getPatients());
    }
}
