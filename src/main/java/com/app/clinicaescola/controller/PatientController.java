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
    
    @RequestMapping(value = "/patients", method = RequestMethod.GET)
    public List<Patient> list() {
        return this.patient.listPatients();
    }
    
    @RequestMapping(value = "/patients", method = RequestMethod.POST)
    public List<Patient> create(@RequestBody Patient newPatient) {
        return this.patient.createPatient(newPatient);
    }
}
