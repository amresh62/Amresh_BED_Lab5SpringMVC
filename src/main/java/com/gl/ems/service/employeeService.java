package com.gl.ems.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.gl.ems.entity.employeeMaster;

@Service
public interface employeeService {
    List<employeeMaster> getEmployee();

    employeeMaster addEmployeeMaster(employeeMaster empData);

    employeeMaster updateEmployeeMaster(employeeMaster empData);

    employeeMaster getEmployeeById(Long id);

    void deleteEmployeebyId(Long id);
}
