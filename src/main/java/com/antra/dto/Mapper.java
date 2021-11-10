package com.antra.dto;

import com.antra.entity.Department;
import com.antra.entity.Employee;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.stream.Collectors;

@Component
public class Mapper {
    public EmployeeDTO toDto(Employee employee) {
        String name = employee.getFirstName() + employee.getLastName();
        Double salary = employee.getSalary();
        Set<String> department = employee
                .getDepartmentSet()
                .stream()
                .map(Department::getName)
                .collect(Collectors.toSet());
        return new EmployeeDTO(name, salary, department);
    }
}
