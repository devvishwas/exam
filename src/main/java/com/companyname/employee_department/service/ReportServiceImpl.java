package com.companyname.employee_department.service;

import com.companyname.employee_department.model.Department;
import com.companyname.employee_department.model.Employee;
import com.companyname.employee_department.repository.DepartmentRepository;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.*;

@Service
public class ReportServiceImpl implements ReportService {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public byte[] generateEmployeesByDepartmentReport() throws Exception {

        // Load JRXML template
        InputStream reportStream = getClass().getResourceAsStream("/employees_by_department.jrxml");
        JasperReport jasperReport = JasperCompileManager.compileReport(reportStream);

        // Prepare data for report
        List<Map<String, Object>> reportData = new ArrayList<>();

        List<Department> departments = departmentRepository.findAll();
        for (Department dept : departments) {
            for (Employee emp : dept.getEmployees()) {
                Map<String, Object> row = new HashMap<>();
                row.put("departmentName", dept.getName());
                row.put("employeeName", emp.getName());
                row.put("employeePosition", emp.getPosition());
                row.put("employeeEmail", emp.getEmail());
                row.put("employeeSalary", emp.getSalary());
                reportData.add(row);
            }
        }

        // Fill report
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(reportData);
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, new HashMap<>(), dataSource);

        // Export to PDF
        ByteArrayOutputStream pdfStream = new ByteArrayOutputStream();
        JasperExportManager.exportReportToPdfStream(jasperPrint, pdfStream);

        return pdfStream.toByteArray();
    }
}
