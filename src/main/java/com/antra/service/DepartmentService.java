package com.antra.service;

import com.antra.entity.Department;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DepartmentService {
    List<Department> findAllDepartment();
    Department findDepartmentById(Integer id);
}
