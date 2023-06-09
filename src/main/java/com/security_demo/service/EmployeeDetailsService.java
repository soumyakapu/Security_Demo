package com.security_demo.service;

import com.security_demo.model.Employee;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmployeeDetailsService implements UserDetailsService {
    private final MongoTemplate mongoTemplate;
    public EmployeeDetailsService(final MongoTemplate mongoTemplate){
        this.mongoTemplate= mongoTemplate;
    }

    /**
     *
     *
     *
     *
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Query query = new Query();
        query.addCriteria(Criteria.where("username").is(username));
      Optional<Employee> employees= Optional.ofNullable(mongoTemplate.findOne(query, Employee.class));
//        return new EmployeeDetails(employees);
    return employees.map(EmployeeDetails::new)
            .orElseThrow(()->new UsernameNotFoundException("Employee not found"+ username));
    }
}
