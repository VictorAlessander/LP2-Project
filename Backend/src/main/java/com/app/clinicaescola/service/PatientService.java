/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.clinicaescola.service;

import com.app.clinicaescola.entity.Employee;
import com.app.clinicaescola.entity.Patient;
import com.app.clinicaescola.repository.EmployeeRepository;
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
    PatientRepository patientRepo;
    
    @Autowired
    EmployeeRepository employeeRepo;
    
    public List<Patient> listPatients() {
        return patientRepo.findAll();
    }
    
    public List<Patient> createPatient(Patient newPatient, String employeeFirstName) {
        Employee employee = employeeRepo.findByFirstName(employeeFirstName);
        
        if("clinic".equals(employee.getKind().getName())) {
            patientRepo.save(newPatient);
            return patientRepo.findAll();
        }
        else{
            return null;
        }
    }
    
    public void removePatient(String id) {
        patientRepo.delete(id);
    }
    
}
