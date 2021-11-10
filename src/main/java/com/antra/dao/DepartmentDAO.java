package com.antra.dao;

import com.antra.entity.Department;

import java.util.List;

public interface DepartmentDAO {
    List<Department> findAllDepartment();
    Department findDepartmentById(Integer id);
}
