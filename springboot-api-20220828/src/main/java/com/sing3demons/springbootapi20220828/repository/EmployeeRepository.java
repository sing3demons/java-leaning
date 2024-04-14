package com.sing3demons.springbootapi20220828.repository;

import com.sing3demons.springbootapi20220828.entity.Employee;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class EmployeeRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void save(Employee employee) {
        entityManager.persist(employee);
    }


    public List listAllEmployee() {
        Query query = entityManager.createQuery("from Employee", Employee.class);

        return query.getResultList();
    }

    public Employee getEmployee(int id) {

        return entityManager.find(Employee.class, id);
    }

    public void deleteEmployee(int id) {
        Employee query = entityManager.find(Employee.class, id);
        entityManager.remove(query);
    }

    public List<Employee> searchByFirstName(Employee request) {
        Query query = entityManager.createQuery("from Employee e where e.firstName = :first_name ", Employee.class);
        query.setParameter("first_name", request.getFirstName());
        return query.getResultList();
    }
}
