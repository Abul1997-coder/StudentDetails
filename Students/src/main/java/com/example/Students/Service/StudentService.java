package com.example.Students.Service;

import com.example.Students.Entity.Student;

import java.util.List;

public interface StudentService {


    Student createStudent (Student stu);
    List<Student> getAllStudent();
    Student getById(Long id);
    Student updateById(Long id, Student stu);
    void deleteById(Long id);
/*
Why Interface?

👉 Loose Coupling

Controller depends on interface, not implementation
Easy to change logic later









* Employee createEmployee(Employee emp);  why give Employee parameter

    List<Employee> getAllEmployees(); why not give parameter

    Employee getEmployeeById(Long id); why give id parameter

    Employee updateEmployee(Long id, Employee emp); why give id and  Employee parameter

    void deleteEmployee(Long id);


explaine why give parameter and working

Great question. Understanding why we pass parameters makes CRUD much easier.

Let’s go one by one with a real example using Employee.

Suppose Employee table:

id	name	email
1	Abul	abul@gmail.com
2	Rahul	rahul@gmail.com
1. Create
Employee createEmployee(Employee emp);
Why Employee emp parameter?

Because when creating a new employee, we need employee data from user.

Example:

{
  "name": "Abul",
  "email": "abul@gmail.com"
}

That data comes inside:

Employee emp
Working

Controller receives:

@PostMapping
public Employee createEmployee(@RequestBody Employee emp) {
    return employeeService.createEmployee(emp);
}

Then service:

employeeRepository.save(emp);

Saved in DB.

Without parameter?

If:

Employee createEmployee();

then Java doesn't know:

name?
email?
department?

Nothing to save.

So parameter required.

2. Get All
List<Employee> getAllEmployees();
Why NO parameter?

Because:

"Give me all employees"

No need specific employee.

We want whole table.

SQL:

select * from employee;

No input needed.

Working
employeeRepository.findAll();

returns:

[
  Employee1,
  Employee2,
  Employee3
]
3. Get By Id
Employee getEmployeeById(Long id);
Why Long id parameter?

Because we need to tell Java:

Which employee do you want?

Example:

id = 2

Then Java fetches:

select * from employee where id=2;

returns Rahul.

Without id?

If:

getEmployeeById();

Java will ask:

"Which employee? 1? 2? 5?"

So id required.

4. Update
Employee updateEmployee(Long id, Employee emp);

This one needs 2 parameters.

Why id?

To find existing employee.

Example:

id = 1

means:

update employee 1

Why Employee emp?

Because we also need new updated data.

Example:

Old:

Name = Abul
Email = abul@gmail.com

New request:

{
  "name":"Abul Ahmad",
  "email":"abulahmad@gmail.com"
}

This comes in:

Employee emp
Working

Step 1:

find employee using id

Employee existing = repository.findById(id).get();

Step 2:

replace old values

existing.setName(emp.getName());
existing.setEmail(emp.getEmail());

Step 3:

save again

repository.save(existing);
5. Delete
void deleteEmployee(Long id);
Why id?

Because we must tell:

Delete which employee?

Example:

delete employee 2

SQL:

delete from employee where id=2;
Without id?

Java doesn't know what to delete.

Could delete wrong record.

So id needed.

Easy Memory Trick

Think like this:

Method	Parameter Needed?	Why
Create	✅ Employee	Need employee data to save
Get All	❌ No	Want all records
Get By Id	✅ id	Need specific record
Update	✅ id + Employee	Need which record + new data
Delete	✅ id	Need which record to remove
Real Life Example

Imagine employee register notebook:

CREATE

Add new employee
→ need full details

GET ALL

Show all employees
→ no details needed

GET BY ID

Show employee #5
→ need ID

UPDATE

Update employee #5 with new email
→ need:

which employee → id
what new data → Employee
DELETE

Delete employee #5
→ need ID

That’s the reason parameters are different in each CRUD method.
* */

}
