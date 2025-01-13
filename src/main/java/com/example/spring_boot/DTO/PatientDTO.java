package com.example.spring_boot.DTO;

import lombok.Data;

@Data
public class PatientDTO {
    private String id;
    private String name;
    private String email;
    private int age;
}
