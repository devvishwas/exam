package com.companyname.employee_department.repository;

import com.companyname.employee_department.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, String> {
}

