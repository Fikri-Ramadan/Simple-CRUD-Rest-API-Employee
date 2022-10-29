package com.fikritech.simplecrudemployee.service.impl;

import com.fikritech.simplecrudemployee.entity.Employee;
import com.fikritech.simplecrudemployee.exception.ResourceNotFoundException;
import com.fikritech.simplecrudemployee.repository.EmployeeRepository;
import com.fikritech.simplecrudemployee.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public Employee getOne(Long id) {
        return employeeRepository.findById(id).orElseThrow(()->
                new ResourceNotFoundException("Employee", "Id", id));
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
    public Employee updateOne(Long id, Employee employee) {
        Employee employeeTemp = employeeRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Employee", "Id", id));

        if (Objects.nonNull(employee.getFirstName())
                && !"".equalsIgnoreCase(employee.getFirstName())) {
            employeeTemp.setFirstName(employee.getFirstName());
        }
        if (Objects.nonNull(employee.getLastName())
                && !"".equalsIgnoreCase(employee.getLastName())) {
            employeeTemp.setLastName(employee.getLastName());
        }
        if (Objects.nonNull(employee.getEmail())
                && !"".equalsIgnoreCase(employee.getEmail())) {
            employeeTemp.setEmail(employee.getEmail());
        }

        employeeRepository.save(employeeTemp);

        return employeeTemp;
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
