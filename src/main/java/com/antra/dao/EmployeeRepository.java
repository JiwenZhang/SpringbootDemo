package com.antra.dao;

import com.antra.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    @Query("select e from Employee e")
    List<Employee> findAllEmployee();

    @Query("select e from Employee e where e.id = :id")
    Employee findEmployeeById(@Param("id") Integer id);


    @Transactional
    @Modifying
    @Query(value =
            "insert into employee (first_name, last_name, salary) " +
            "values (:firstName, :lastName, :salary)",
            nativeQuery = true)
    void addEmployee(@Param("firstName") String firstName,
                            @Param("lastName") String lastName,
                            @Param("salary") Double salary);
}
