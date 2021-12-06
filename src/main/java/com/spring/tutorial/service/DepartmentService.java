package com.spring.tutorial.service;

import java.util.List;

import com.spring.tutorial.entity.Department;
import com.spring.tutorial.error.DepartmentNotFoundException;

public interface DepartmentService {

    Department saveDepartment(Department department);

    List<Department> fetchAllDepartments();

   Department fetchDepartmentById(Long id) throws DepartmentNotFoundException;

   Department fetchDepartmentByName(String departmentName);

    void deleteDepartmentById(Long departmentId) throws DepartmentNotFoundException;

     Department  updateDepartmentById(Long departmentId, Department department);
}


