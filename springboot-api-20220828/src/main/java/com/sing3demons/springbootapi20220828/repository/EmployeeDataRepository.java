package com.sing3demons.springbootapi20220828.repository;

import com.sing3demons.springbootapi20220828.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmployeeDataRepository extends JpaRepository<Employee, Integer> {
    @Query("select o from Employee o where o.firstName = ?1")
//    @Query(value = "select * from Employee where FIRST_NAME = ?1",nativeQuery = true)
    List<Employee> findByFirstName(String firstName);

}
