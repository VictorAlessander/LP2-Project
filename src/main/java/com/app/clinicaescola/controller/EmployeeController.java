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
    
    @RequestMapping(value = "/employees", method = RequestMethod.GET)
    public List<Employee> list() {
        return this.employee.listEmployees();
    }
    
    @RequestMapping(value = "/employees", method = RequestMethod.POST)
    public List<Employee> create(@RequestBody Employee newEmployee) {
        return this.employee.createEmployee(newEmployee);
    }

}