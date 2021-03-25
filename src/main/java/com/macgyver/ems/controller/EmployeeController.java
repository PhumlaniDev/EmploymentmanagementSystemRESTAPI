package com.macgyver.ems.controller;

import com.macgyver.ems.model.Employee;
import com.macgyver.ems.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService service;

    @PostMapping("/add")
    public Employee addEmployee(@RequestBody Employee employee){
        return service.addEmployee(employee);
    }

    @GetMapping
    public List<Employee> getAllEmployee(){
        return service.getAllEmployees();
    }

    @GetMapping("/{id}")
    public Optional<Employee> getAllEmployeeById(@PathVariable Long id){
        return service.getAllEmployeeById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id){
        service.deleteById(id);
    }
}
