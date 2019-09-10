package com.abc.raja;

import com.abc.raja.dao.Employee;
import com.abc.raja.repo.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/employee")
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping("/all")
    public Iterable<Employee> getAllUsers() {
        return employeeRepository.findAll();
    }

    @PostMapping("/save")
    public Employee newEmployee(@RequestBody Employee employee) {
        return employeeRepository.save(employee);
    }

    @GetMapping("/{id}")
    public Employee getEmployee(@PathVariable Integer id) {
        return employeeRepository.findById(id).orElseThrow(() -> new EmployeeNotFoundException(id));
    }

    @DeleteMapping("/{id}")
    public void deleteEmployee(@PathVariable Integer id) {
        employeeRepository.deleteById(id);
    }

    @PutMapping("/{id}")
    public Employee updateEmployee(@PathVariable Integer id, @RequestBody Employee employee) {
        Employee existingEmp = employeeRepository.findById(id).orElseThrow(() -> new EmployeeNotFoundException(id));

        existingEmp.setName(employee.getName());
        existingEmp.setJoiningDate(employee.getJoiningDate());
        existingEmp.setSalary(employee.getSalary());
        existingEmp.setSsn(employee.getSsn());

        return employeeRepository.save(existingEmp);
    }

    //@PatchMapping("")
    // Have to explore how to use this patch mapping.....


}
