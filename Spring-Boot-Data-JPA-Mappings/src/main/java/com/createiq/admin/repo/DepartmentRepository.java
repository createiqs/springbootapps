package com.createiq.admin.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.createiq.admin.entity.Department;

public interface DepartmentRepository extends JpaRepository<Department, Integer>{

}