/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.clinicaescola.controller;

import com.app.clinicaescola.entity.Patient;
import com.app.clinicaescola.service.PatientService;
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
public class PatientController {
    
    @Autowired
    PatientService patient;
    
    @RequestMapping(value = "/patients/{firstName}", method = RequestMethod.GET)
    public List<Patient> list(@PathVariable("firstName") String employeeFirstName) {
        return this.patient.listPatients(employeeFirstName);
    }
    
    @RequestMapping(
            value = "/patients/{firstName}",
            method = RequestMethod.POST)
    public List<Patient> create(
            @RequestBody Patient newPatient,
            @PathVariable("firstName") String employeeFirstName) {
        
        return this.patient.createPatient(newPatient, employeeFirstName);
    }
    
    @RequestMapping(value = "/patients/{firstName}/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable("firstName") String employeeFirstName, @PathVariable("id") String id) {
        this.patient.removePatient(employeeFirstName, id);
    }
    
    @RequestMapping(
            value = "/patients/{firstName}",
            method = RequestMethod.PUT)
    public List<Patient> update(
            @RequestBody Patient newPatient,
            @PathVariable("firstName") String employeeFirstName) {

        return this.patient.createPatient(newPatient, employeeFirstName);
    }
}
