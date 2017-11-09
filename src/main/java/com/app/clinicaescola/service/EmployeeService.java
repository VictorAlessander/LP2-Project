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
    EmployeeRepository employeeRepo;
    
    public List<Employee> listEmployees(String employeeFirstName) {
        Employee employee = employeeRepo.findByFirstName(employeeFirstName);

        if(employee != null && "administrative".equals(
                employee.getKind().getName())) {
            return employeeRepo.findAll();
        }
        else if("admin".equals(employeeFirstName)) {
            return employeeRepo.findAll();
        }
        else {
            return null;
        }
    }
    
    public List<Employee> createEmployee(
            Employee newEmployee,
            String employeeFirstName) {

        Employee employee = employeeRepo.findByFirstName(employeeFirstName);

        if(employee != null && "administrative".equals(
                employee.getKind().getName())) {
            employeeRepo.save(newEmployee);
            return employeeRepo.findAll();
        }
        else if("admin".equals(employeeFirstName)) {
            employeeRepo.save(newEmployee);
            return employeeRepo.findAll();
        }
        else {
            return null;
        }
    }
    
    public void deleteEmploye(String id, String employeeFirstName) {
        Employee employee = employeeRepo.findByFirstName(employeeFirstName);

        if(employee != null && "administrative".equals(
                employee.getKind().getName())) {
            employeeRepo.delete(id);
        }
        else if("admin".equals(employeeFirstName)) {
            employeeRepo.delete(id);
        }
    }
}
