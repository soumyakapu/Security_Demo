package com.security_demo.service;

import com.security_demo.model.Employee;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    private  String COLLECTION_NAME = "Employee_credentials";
    private final MongoTemplate mongoTemplate;
   public EmployeeService(final MongoTemplate mongoTemplate){
       this.mongoTemplate = mongoTemplate;
   }
   public Employee createEmployee(Employee employee){
       return mongoTemplate.save(employee,COLLECTION_NAME);
   }
   public List<Employee> getAllEmployees(Employee employee){
       return mongoTemplate.findAll(Employee.class, COLLECTION_NAME);
   }
}
