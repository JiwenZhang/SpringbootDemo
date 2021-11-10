package com.antra.service;

import com.antra.dao.DepartmentDAO;
import com.antra.entity.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    private final DepartmentDAO departmentDAO;

    @Autowired
    public DepartmentServiceImpl(DepartmentDAO departmentDAO) {
        this.departmentDAO = departmentDAO;
    }

    @Override
    public List<Department> findAllDepartment() {
        return departmentDAO.findAllDepartment();
    }

    @Override
    public Department findDepartmentById(Integer id) {
        return departmentDAO.findDepartmentById(id);
    }
}
