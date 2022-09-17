package com.example.demo.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Employee {

    @Id
    private Long employeeId;
    private String employeeFirstName;
    private String employeeLastName;
    private String employeeAddress;
    private String employeeEmail;

}
