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

/*
Purpose: Represents a database table.


* Simple Interview Answer:
Entity is a Java class that represents a database table.

Class = Table
Object = Row/Record
Fields = Columns

Student class → student table
name, email → table columns

We use @Entity annotation to tell Spring Boot/JPA that this class should be mapped to a database table.*/