package com.createiq.admin.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.createiq.admin.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
