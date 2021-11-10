package com.antra.dao;

import com.antra.entity.Department;
import com.antra.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Repository
public class DepartmentDAOImpl implements DepartmentDAO {

    private final EntityManager entityManager;

    @Autowired
    public DepartmentDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Department> findAllDepartment() {
        return entityManager.createQuery("select d from Department d").getResultList();
    }

    @Override
    public Department findDepartmentById(Integer id) {
        return entityManager.find(Department.class, id);
    }

}
