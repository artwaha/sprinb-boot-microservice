package com.atwaha.student;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    private String email;
    private Integer schoolId;
}
