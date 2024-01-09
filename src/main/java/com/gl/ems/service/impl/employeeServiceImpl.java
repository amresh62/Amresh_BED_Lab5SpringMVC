package com.gl.ems.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.gl.ems.entity.employeeMaster;
import com.gl.ems.repository.employeeRepository;
import com.gl.ems.service.employeeService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class employeeServiceImpl implements employeeService {

    private final employeeRepository empRepository;

    @Override
    public List<employeeMaster> getEmployee() {
        return empRepository.findAll();
    }

    @Override
    public employeeMaster addEmployeeMaster(employeeMaster empData) {
        return empRepository.save(empData);
    }

    @Override
    public employeeMaster updateEmployeeMaster(employeeMaster empData) {
        return empRepository.save(empData);
    }

    @Override
    public employeeMaster getEmployeeById(Long id) {
        return empRepository.findById(id).get();
    }

    @Override
    public void deleteEmployeebyId(Long id) {
        empRepository.deleteById(id);
    }

}
