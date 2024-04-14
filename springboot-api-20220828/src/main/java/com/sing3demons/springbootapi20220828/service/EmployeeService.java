package com.sing3demons.springbootapi20220828.service;

import com.sing3demons.springbootapi20220828.entity.Employee;
import com.sing3demons.springbootapi20220828.exception.DataNotFoundException;
import com.sing3demons.springbootapi20220828.exception.UnprocessableException;
import com.sing3demons.springbootapi20220828.model.MessageInfo;
import com.sing3demons.springbootapi20220828.repository.EmployeeDataRepository;
import com.sing3demons.springbootapi20220828.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private EmployeeDataRepository repository;

    public void save(Employee employee) {
        if (employee == null) {
            throw new UnprocessableException(new MessageInfo("402", "unprocess"));
        }
        employeeRepository.save(employee);
    }

    public List<Employee> listAllEmployee() {
//        return employeeRepository.listAllEmployee();
        return repository.findAll();
    }


    public Employee getEmployee(int id) {
//        Employee employee = employeeRepository.getEmployee(id);
//        if (employee == null) {
//            throw new DataNotFoundException(new MessageInfo("404", "not found"));
//        }
//        return employee;
        return repository.findById(id).orElseThrow(() -> new DataNotFoundException(new MessageInfo("404", "not found")));
    }

    public void updateEmployee(int id, Employee request) {
        Employee employee = employeeRepository.getEmployee(id);
        employee.setFirstName(request.getFirstName());
        employee.setLastName(request.getLastName());
//        employeeRepository.save(employee);
        repository.save(employee);


    }

    public List<Employee> searchByFirstName(Employee request) {
//        return employeeRepository.searchByFirstName(request);
        return repository.findByFirstName(request.getFirstName());
    }


    public void deleteEmployee(int id) {
//        Optional<Employee> employee = repository.findById(id);
        repository.deleteById(id);
    }

    public void createEmployee(Employee request) {
        employeeRepository.save(request);
    }
}
