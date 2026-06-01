package com.example.Students.Entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data       // @Getter and @Setter
@Entity    // class become a database table(student is table name)
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) //Audto Increment
    private Long id;
    private String name;
    private String email;
    private String department;

}
