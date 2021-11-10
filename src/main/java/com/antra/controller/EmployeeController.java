package com.antra.controller;

import com.antra.dao.EmployeeRepository;
import com.antra.dto.EmployeeDTO;
import com.antra.entity.Employee;
import com.antra.exception.NoSuchEmployeeFoundException;
import com.antra.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
public class EmployeeController {
    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping(value = "/employee")
    public ResponseEntity<Set<EmployeeDTO>> employeeList() {
        return new ResponseEntity(employeeService.findAllEmployee(), HttpStatus.OK);
    }

    @GetMapping(value = "/employee/{id}")
    public ResponseEntity<String> employeeFind(@PathVariable Integer id) {
        try {
            return new ResponseEntity(employeeService.findEmployeeById(id), HttpStatus.OK);
        } catch(NoSuchEmployeeFoundException exception) {
            return new ResponseEntity(exception.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping(value = "/employee")
    public void saveEmployee(@RequestBody Employee employee) {
        employeeService.addNewEmployee(employee);
    }
    /*
    @PostMapping(value = "/employee/{firstName}/{lastName}/{salary}") request body
    private void employeeAdd(@PathVariable String firstName,
                                 @PathVariable String lastName,
                                 @PathVariable Double salary) {
        employeeRepository.addEmployee(firstName, lastName, salary);
    }
    */
}
