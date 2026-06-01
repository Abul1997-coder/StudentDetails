package com.example.Students.Controller;


import com.example.Students.Entity.Student;
import com.example.Students.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController              // Rest Api
@RequestMapping("/student")  // Base URL
public class StudentController {

   /* private final StudentService service;

  This is called Constructor Injection
    public StudentController(StudentService service){         //

        this.service=service;
    }

   */


    @Autowired
    private StudentService service;

    //Create or Added Student APi
    @PostMapping("/Add")
    public Student create(@RequestBody Student stu){

        return service.createStudent(stu);

    }


    //Fatch all records
    @GetMapping("/All")
    public List<Student> getAll(){
        return service.getAllStudent();
    }

    //Fetch By Id records
    @GetMapping("/ById")
    public Student ById(@PathVariable Long id){
        return service.getById(id);
    }

    //Update by Id
    @PutMapping("/update")
    public Student update(@PathVariable Long id,@RequestBody Student stu){
        return service.updateById(id,stu);
    }

    @DeleteMapping("/delete")
    public String delete(Long id){
        service.deleteById(id);
        return "Student deleted successfully";
    }




}


/**
 * @PathVariable is used to get value from URL like id.
 * PUT /employees/5
 *
 * @RequestBody takes data from client(request) and puts it into object.”
 *Client sends:
 * {
 *   "name": "Rahul",
 *   "salary": 50000
 * }
 *
 * @RequestBody Employee emp
 * Spring creates:
 *
 * emp.name = "Rahul"
 * emp.salary = 50000
 *
 *
 * @Autowired====Spring injects dependency directly into the field/variable
 *Constructor Injection=====Dependency is passed through constructor, so it is called Constructor Injection.
 * public StudentController(StudentService service)      //This is a constructor of EmployeeController.
 * EmployeeService service                                 // passed so the controller can use service methods.
 * this.service = service;    //storing the incoming EmployeeService object into the controller variable
 *                           //After storing it, I can use service.createEmployee(), service.getAllEmployees() inside controller methods
 *
 *
 *
 *
 *
 *
 */
