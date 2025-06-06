package com.companyname.employee_department.service;

import com.companyname.employee_department.dto.EmployeeDTO;

import java.util.List;

public interface EmployeeService {
    List<EmployeeDTO> getAllEmployees();
    List<EmployeeDTO> getEmployeesByDepartment(String departmentId);
    EmployeeDTO addEmployee(EmployeeDTO employeeDTO);
    void deleteEmployee(String employeeId);
    EmployeeDTO updateEmployee(EmployeeDTO employeeDTO);
}

