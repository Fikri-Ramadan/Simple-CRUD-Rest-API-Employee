package com.fikritech.simplecrudemployee.service;

import com.fikritech.simplecrudemployee.entity.Employee;

import java.util.List;

public interface EmployeeService {

    Employee getOne(Long id);
    List<Employee> getAll();
    Employee addOne(Employee employee);
    Employee updateOne(Long id, Employee employee);
    Boolean deleteOne(Long id);

}
