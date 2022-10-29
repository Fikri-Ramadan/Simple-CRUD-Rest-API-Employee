package com.fikritech.simplecrudemployee.controller;

import com.fikritech.simplecrudemployee.entity.Employee;
import com.fikritech.simplecrudemployee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping
    public ResponseEntity<List<Employee>> getAll() {
        return ResponseEntity.ok(employeeService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> getOne(@PathVariable Long id) {
        return ResponseEntity.ok(employeeService.getOne(id));
    }

    @PostMapping
    public ResponseEntity<Employee> addOne(@RequestBody Employee employee) {
        return ResponseEntity.ok(employeeService.addOne(employee));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Employee> updateOne(@PathVariable Long id, @RequestBody Employee employee) {
        return ResponseEntity.ok(employeeService.updateOne(id, employee));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteOne(@PathVariable Long id) {
        return ResponseEntity.ok(employeeService.deleteOne(id));
    }

}
