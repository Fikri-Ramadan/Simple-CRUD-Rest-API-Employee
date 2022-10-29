package com.fikritech.simplecrudemployee.service;

import com.fikritech.simplecrudemployee.entity.Employee;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EmployeeService {

    public Employee getOne(Long id);
    public List<Employee> getAll();
    public Employee addOne(Employee employee);
    public Employee UpdateOne(Long id, Employee employee);
    public Boolean deleteOne(Long id);

}
