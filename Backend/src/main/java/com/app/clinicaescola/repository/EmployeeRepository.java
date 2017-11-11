/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.clinicaescola.repository;

import com.app.clinicaescola.entity.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 *
 * @author vagr
 */
public interface EmployeeRepository extends MongoRepository<Employee, String> {
    public Employee findByFirstName(String firstName);
    
    // public void makeAppointment(Employee employee, )
}
