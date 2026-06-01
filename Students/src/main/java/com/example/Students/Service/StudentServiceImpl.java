package com.example.Students.Service;
import com.example.Students.Entity.Student;
import com.example.Students.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements  StudentService{

    @Autowired
    private StudentRepository repository;


    /**Create or added the student
     * @param stu
     * @return
     */
    @Override
    public Student createStudent(Student stu) {
        return repository.save(stu);
    }


    /** Fectc the all Record Student or Student List
     * @return
     */
    @Override
    public List<Student> getAllStudent() {
        return repository.findAll();
    }

    /**Fetch by Id Record Student
     * @param id
     * @return
     */
    @Override
    public Student getById(Long id) {
        return repository.findById(id)
                .orElseThrow(()-> new RuntimeException("Employee Not Fpund"));
    }

    /**Update the value
     * @param id
     * @param stu
     * @return
     */
    @Override
    public Student updateById(Long id, Student stu) {
        Student existing =getById(id);  //Fetching existing student

        existing.setName(stu.getName());
        existing.setEmail(stu.getEmail());
        existing.setDepartment(stu.getDepartment());
        return repository.save(existing);  // update and save


    }

    /** Delete by id
     * @param id
     * @return
     */
    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
