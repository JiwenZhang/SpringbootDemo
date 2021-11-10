package com.antra.service;

import com.antra.dao.EmployeeRepository;
import com.antra.dto.EmployeeDTO;
import com.antra.dto.Mapper;
import com.antra.entity.Employee;
import com.antra.exception.NoSuchEmployeeFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final Mapper mapper;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository, Mapper mapper) {
        this.employeeRepository = employeeRepository;
        this.mapper = mapper;
    }

    public Set<EmployeeDTO> findAllEmployee() {
        return employeeRepository
                .findAllEmployee()
                .stream()
                .map(mapper::toDto)
                .collect(Collectors.toSet());
    }

    public String findEmployeeById(Integer id) throws NoSuchEmployeeFoundException {
        Employee employee = employeeRepository.findEmployeeById(id);
        if (employee == null) {
            throw new NoSuchEmployeeFoundException("No Such Employee!");
        } else {
            return employee.getFirstName() + employee.getLastName();
        }
    }

    public void addNewEmployee(Employee employee) {
        employeeRepository.addEmployee(employee.getFirstName(), employee.getLastName(), employee.getSalary());
    }
}
