package com.companyname.employee_department.controller;

import com.companyname.employee_department.dto.EmployeeDTO;
import com.companyname.employee_department.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    public List<EmployeeDTO> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @GetMapping("/department/{deptId}")
    public List<EmployeeDTO> getEmployeesByDepartment(@PathVariable String deptId) {
        return employeeService.getEmployeesByDepartment(deptId);
    }

    @PostMapping
    public EmployeeDTO addEmployee(@RequestBody EmployeeDTO employeeDTO) {
        return employeeService.addEmployee(employeeDTO);
    }

    @DeleteMapping("/{employeeId}")
    public void deleteEmployee(@PathVariable String employeeId) {
        employeeService.deleteEmployee(employeeId);
    }
}

