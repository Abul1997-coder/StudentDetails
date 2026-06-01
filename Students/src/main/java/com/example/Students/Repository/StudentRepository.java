package com.example.Students.Repository;

import com.example.Students.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {

    /*




Purpose:-Repository is the layer that communicates with the database.

Simple Interview Answer:-
It is used to perform CRUD operations (Create, Read, Update, Delete) on data.

By extending JpaRepository, Spring Boot provides built-in methods such as:

save() → Insert/Update data
findAll() → Get all records
findById() → Get record by ID
deleteById() → Delete record by ID


    * Gives build in methods
    * save()
    * findAll()
    * findById()
    * deleteById()
    *
    *
    *
    * */


}
