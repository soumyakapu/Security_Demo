package com.security_demo.controller;

import com.security_demo.model.Employee;
import com.security_demo.service.EmployeeService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/")
public class EmployeeController {
    private final EmployeeService employeeService;
    public EmployeeController(final  EmployeeService employeeService){
        this.employeeService= employeeService;
    }
//    @GetMapping("/get")
//    public String get(){
//
//        return "fetching the data";
//    }
//    @GetMapping("/getted")
//    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN')")
//    public String gett(){
//        return "frm gett";
//    }
    @PostMapping("/createEmployee")
//    @PreAuthorize("hasRole('SUPERADMIN')")
    public Employee createEmployee(@RequestBody Employee employee){
        return employeeService.createEmployee(employee);
    }
    @GetMapping("/getAllEmployees")
    @PreAuthorize("hasRole('SUPERADMIN')")
    public List<Employee> getAll(Employee employee){
        return employeeService.getAllEmployees(employee);
    }
}
