package com.fikritech.simplecrudemployee.service.impl;

import com.fikritech.simplecrudemployee.entity.Employee;
import com.fikritech.simplecrudemployee.exception.ResourceNotFoundException;
import com.fikritech.simplecrudemployee.repository.EmployeeRepository;
import com.fikritech.simplecrudemployee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public Employee getOne(Long id) {
        return employeeRepository.findById(id).orElseThrow(()->
                new ResourceNotFoundException("Employee", "id", id));
    }

    @Override
    public List<Employee> getAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee addOne(Employee employee) {
        Employee emp = Employee.builder()
                .firstName(employee.getFirstName())
                .lastName(employee.getLastName())
                .email(employee.getEmail())
                .build();

        employeeRepository.save(emp);

        return emp;
    }

    @Override
    public Employee UpdateOne(Long id, Employee employee) {
        return null;
    }

    @Override
    public Boolean deleteOne(Long id) {
        boolean deleteStatus = false;

        if (employeeRepository.existsById(id)) {
            employeeRepository.deleteById(id);
            deleteStatus = true;
        }

        return deleteStatus;
    }
}
