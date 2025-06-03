package com.companyname.employee_department.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmployeeDTO {
    private String id;
    private String name;
    private String email;
    private String position;
    private double salary;
    private String departmentId;


}

