package com.fikritech.simplecrudemployee.repository;

import com.fikritech.simplecrudemployee.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {



}
