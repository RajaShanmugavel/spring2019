package com.abc.raja;

import com.abc.raja.dao.Employee;
import com.abc.raja.repo.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(path = "/employee")
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping("/all")
    Iterable<Employee> getAllUsers() {
        return employeeRepository.findAll();
    }

    @PostMapping("/save")
    Employee newEmployee(@RequestBody Employee employee) {
        return employeeRepository.save(employee);
    }

    @GetMapping("/{id}")
    Employee getEmployee(@PathVariable Integer id) {
        return employeeRepository.findById(id).orElseThrow(() -> new EmployeeNotFoundException(id));
    }


}
