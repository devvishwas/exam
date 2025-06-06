package com.companyname.employee_department.service;

import com.companyname.employee_department.dto.EmployeeDTO;
import com.companyname.employee_department.model.Department;
import com.companyname.employee_department.model.Employee;
import com.companyname.employee_department.repository.DepartmentRepository;
import com.companyname.employee_department.repository.EmployeeRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService{



        @Autowired
        private EmployeeRepository employeeRepository;

        @Autowired

        private DepartmentRepository departmentRepository;

        @Override
        public List<EmployeeDTO> getAllEmployees() {
            return employeeRepository.findAll().stream().map(this::convertToDTO).collect(Collectors.toList());
        }

        @Override
        public List<EmployeeDTO> getEmployeesByDepartment(String departmentId) {
            return employeeRepository.findByDepartmentId(departmentId).stream().map(this::convertToDTO).collect(Collectors.toList());
        }

        @Override
        public EmployeeDTO addEmployee(EmployeeDTO employeeDTO) {
            Employee employee = new Employee();
            employee.setId(employeeDTO.getId());
            employee.setName(employeeDTO.getName());
            employee.setEmail(employeeDTO.getEmail());
            employee.setPosition(employeeDTO.getPosition());
            employee.setSalary(employeeDTO.getSalary());
            Department dept = departmentRepository.findById(employeeDTO.getDepartmentId())
                    .orElseThrow(() -> new RuntimeException("Department not found"));
            employee.setDepartment(dept);
            employeeRepository.save(employee);
            return convertToDTO(employee);
        }

        @Override
        public void deleteEmployee(String employeeId) {
            employeeRepository.deleteById(employeeId);
        }

        private EmployeeDTO convertToDTO(Employee employee) {
            EmployeeDTO dto = new EmployeeDTO();
            dto.setId(employee.getId());
            dto.setName(employee.getName());
            dto.setEmail(employee.getEmail());
            dto.setPosition(employee.getPosition());
            dto.setSalary(employee.getSalary());
            dto.setDepartmentId(employee.getDepartment().getId());
            return dto;
        }

    @Override
    @Transactional
    public EmployeeDTO updateEmployee(EmployeeDTO employeeDTO) {
        Employee employee = employeeRepository.findById(employeeDTO.getId())
                .orElseThrow(() -> new RuntimeException("Employee not found"));

        employee.setName(employeeDTO.getName());
        employee.setEmail(employeeDTO.getEmail());
        employee.setPosition(employeeDTO.getPosition());
        employee.setSalary(employeeDTO.getSalary());

        Department dept = departmentRepository.findById(employeeDTO.getDepartmentId())
                .orElseThrow(() -> new RuntimeException("Department not found"));
        employee.setDepartment(dept);

        employeeRepository.save(employee);

        return convertToDTO(employee);
    }

}


