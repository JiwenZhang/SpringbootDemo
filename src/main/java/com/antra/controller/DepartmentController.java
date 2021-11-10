package com.antra.controller;

import com.antra.entity.Department;
import com.antra.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DepartmentController {
    private DepartmentService departmentService;

    @Autowired
    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping(value = "/department")
    private ResponseEntity<List<Department>> departmentList() {
        return new ResponseEntity(departmentService.findAllDepartment(), HttpStatus.OK);
    }

    @GetMapping(value = "/department/{id}")
    private ResponseEntity<Department> departmentFind(@PathVariable Integer id) {
        return new ResponseEntity(departmentService.findDepartmentById(id), HttpStatus.OK);
    }
}
