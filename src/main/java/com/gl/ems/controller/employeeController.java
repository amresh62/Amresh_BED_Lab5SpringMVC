package com.gl.ems.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.gl.ems.entity.employeeMaster;
import com.gl.ems.service.employeeService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class employeeController {

    private final employeeService empService;

    @GetMapping("/employees")
    public String getAllEmployees(Model model) {
        model.addAttribute("employees", empService.getEmployee());
        return "employees";
    }

    @GetMapping("/employees/new")
    public String addEmployee(Model model) {
        employeeMaster emp = new employeeMaster();
        model.addAttribute("employee", emp);
        return "create_employee";
    }

    @PostMapping("/employees")
    public String addEmployee(@ModelAttribute("employee") employeeMaster empData) {
        empService.addEmployeeMaster(empData);
        return "redirect:/employees";
    }

    @GetMapping("/employees/edit/{id}")
    public String editemployeeForm(@PathVariable Long id, Model model) {
        model.addAttribute("employee", empService.getEmployeeById(id));
        return "edit_employee";
    }

    @PostMapping("/employees/{id}")
    public String postMethodName(@PathVariable Long id, @ModelAttribute("employee") employeeMaster employee,
            Model model) {
        employeeMaster empData = empService.getEmployeeById(id);
        empData.setId(id);
        empData.setEmpFirstname(employee.getEmpFirstname());
        empData.setEmpLastname(employee.getEmpLastname());
        empData.setEmail(employee.getEmail());
        empService.updateEmployeeMaster(empData);
        return "redirect:/employees";
    }

    @GetMapping("/employees/{id}")
    public String getMethodName(@PathVariable Long id) {
        empService.deleteEmployeebyId(id);
        return "redirect:/employees";
    }

}
