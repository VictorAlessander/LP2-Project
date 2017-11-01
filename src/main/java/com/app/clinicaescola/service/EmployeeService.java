/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.clinicaescola.service;

import com.app.clinicaescola.entity.Employee;
import com.app.clinicaescola.repository.EmployeeRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author vagr
 */

@Service
public class EmployeeService {
    
    @Autowired
    EmployeeRepository employee;
    
    public List<Employee> listEmployees() {
        return employee.findAll();
    }
    
    public List<Employee> createEmployee(Employee newEmployee) {
        employee.save(newEmployee);
        
        return employee.findAll();
    }
}
