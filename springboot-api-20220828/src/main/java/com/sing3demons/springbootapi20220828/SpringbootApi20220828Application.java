package com.sing3demons.springbootapi20220828;

import com.sing3demons.springbootapi20220828.entity.Employee;
import com.sing3demons.springbootapi20220828.repository.EmployeeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringbootApi20220828Application {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(SpringbootApi20220828Application.class, args);
    }

    @Bean
    public CommandLineRunner initialize(EmployeeRepository employeeRepository) {
        return (args -> {
            {
                Employee employee = new Employee();
                employee.setFirstName("john");
                employee.setLastName("doe");
                employeeRepository.save(employee);
            }
            {
                Employee employee = new Employee();
                employee.setFirstName("john2");
                employee.setLastName("doe2");
                employeeRepository.save(employee);
            }

            {
                Employee employee = new Employee();
                employee.setFirstName("john3");
                employee.setLastName("doe3");
                employeeRepository.save(employee);
            }
        });
    }
}
