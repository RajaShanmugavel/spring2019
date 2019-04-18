package com.abc.raja.repo;

import com.abc.raja.dao.Employee;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends CrudRepository<Employee, Integer> {

}
