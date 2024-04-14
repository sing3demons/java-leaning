package com.sing3demons.springbootapi20220828.controller;

import com.sing3demons.springbootapi20220828.entity.Employee;
import com.sing3demons.springbootapi20220828.repository.EmployeeRepository;
import com.sing3demons.springbootapi20220828.service.EmployeeService;
import com.sing3demons.springbootapi20220828.service.MyConfigPropeties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private MyConfigPropeties propeties;

    @PostMapping("/employees")
    public void createEmployee(@RequestBody Employee request) {
        System.out.println("id: " + request.getId());
        System.out.println("firstName: " + request.getFirstName());
        System.out.println("lastName: " + request.getLastName());
        System.out.println("request: " + request);
        employeeService.createEmployee(request);

    }

    @GetMapping("/employees")
    public List<Employee> listAllEmployee() {
//        List<Employee> datas = new ArrayList<>();
//        Employee employee = new Employee();
//        datas.add(employee);
        System.out.println(propeties.getMessage());

        List<Employee> employee = employeeService.listAllEmployee();
        return employee;
    }

    @GetMapping("/employee/{id}")
    public Employee getEmployee(@PathVariable int id) {
//        Employee employee = new Employee();
//        System.out.println("id: " + id);
//        employee.setId(id);
        Employee employee = employeeService.getEmployee(id);
        return employee;
    }

    @PutMapping("/employees/{id}")
    public void updateEmployee(@PathVariable int id, @RequestBody Employee request) {
        employeeService.updateEmployee(id, request);

    }

    @DeleteMapping("/employees/{id}")
    public void deleteEmployee(@PathVariable int id) {
        employeeService.deleteEmployee(id);
    }

    @PostMapping("/employees/search")
    public List<Employee> search(@RequestBody Employee request) {
        return employeeService.searchByFirstName(request);
    }
}
