package com.example.Students.Repository;

import com.example.Students.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {

    /*
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
