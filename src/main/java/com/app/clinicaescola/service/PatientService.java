/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.clinicaescola.service;

import com.app.clinicaescola.entity.Patient;
import com.app.clinicaescola.repository.PatientRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author vagr
 */

@Service
public class PatientService {
    
    @Autowired
    PatientRepository patient;
    
    public List<Patient> listPatients() {
        return patient.findAll();
    }
    
    public List<Patient> createPatient(Patient newPatient) {
        patient.save(newPatient);
        
        return patient.findAll();
    }
    
}
