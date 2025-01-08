package com.example.spring_boot.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

//this entity as orm for mongodb
@Data
@AllArgsConstructor
@Document(collection = "patients")
public class Patient {
    private String id;
    private String name;
    private String email;
    private int age;

    public Patient() {

    }
}

