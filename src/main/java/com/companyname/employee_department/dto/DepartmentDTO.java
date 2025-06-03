package com.companyname.employee_department.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class DepartmentDTO {
    private String id;
    private String name;
    private String location;
    private List<EmployeeDTO> employees;
}
