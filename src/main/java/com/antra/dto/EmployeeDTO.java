package com.antra.dto;

import java.util.Set;

public class EmployeeDTO {
    private String name;
    private Double salary;
    private Set<String> department;

    public EmployeeDTO(String name, Double salary, Set<String> department) {
        this.name = name;
        this.salary = salary;
        this.department = department;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public Set<String> getDepartment() {
        return department;
    }

    public void setDepartment(Set<String> department) {
        this.department = department;
    }
}
