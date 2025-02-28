package com.example.atividade3.controller;

import com.example.atividade3.domain.Employee;
import com.example.atividade3.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class GerenciadorFuncionarios {

    @Autowired
    private EmployeeRepository repository;

    @PostMapping("/create")
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {
        Employee savedEmployee = repository.save(employee);
        return ResponseEntity.ok(savedEmployee);
    }

    @GetMapping
    public ResponseEntity<List<Employee>> getAllEmployees() {
        List<Employee> employees = repository.findAll();
        return ResponseEntity.ok(employees);
    }

    @PutMapping("/{id}")
    public Employee updateEmployee(@PathVariable Integer id, @RequestBody Employee employeeDetails) {
        Employee updateEmployee = repository.findById(id).orElse(null);

        updateEmployee.setSalary(employeeDetails.getSalary());
        return repository.save(updateEmployee);
    }

    @DeleteMapping("/{id}")
    public void deleteEmployee(@PathVariable Integer id) {
            repository.deleteById(id);
    }
}
