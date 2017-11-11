/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.clinicaescola.controller;

import com.app.clinicaescola.entity.Employee;
import com.app.clinicaescola.service.EmployeeService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author vagr
 */

@RestController
public class EmployeeController {
    
    @Autowired
    EmployeeService employee;
    
    @RequestMapping(value = "/employees/{firstName}", method = RequestMethod.GET)
    public List<Employee> list(@PathVariable("firstName") String employeeFirstName) {
        return this.employee.listEmployees(employeeFirstName);
    }
    
    @RequestMapping(
            value = "/employees/{firstName}",
            method = RequestMethod.POST)
    public List<Employee> create(
            @RequestBody Employee newEmployee,
            @PathVariable("firstName") String firstNameEmployee) {

        return this.employee.createEmployee(newEmployee, firstNameEmployee);
    }
    
    @RequestMapping(value = "/employees/{firstName}/{id}", method = RequestMethod.DELETE)
    public void delete(
            @PathVariable("firstName") String employeeFirstName,
            @PathVariable("id") String employeeId) {
        this.employee.deleteEmploye(employeeId, employeeFirstName);
    }

    @RequestMapping(
            value = "/employees/{firstName}",
            method = RequestMethod.PUT)
    public List<Employee> update(
            @RequestBody Employee newEmployee,
            @PathVariable("firstName") String firstNameEmployee) {

        return this.employee.createEmployee(newEmployee, firstNameEmployee);
    }
}