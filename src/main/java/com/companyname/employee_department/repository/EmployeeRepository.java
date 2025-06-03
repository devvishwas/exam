package com.companyname.employee_department.repository;

import com.companyname.employee_department.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, String> {
    List<Employee> findByDepartmentId(String departmentId);
}

