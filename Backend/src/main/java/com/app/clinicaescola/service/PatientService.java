/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.clinicaescola.service;

import com.app.clinicaescola.entity.Employee;
import com.app.clinicaescola.entity.Patient;
import com.app.clinicaescola.enums.SectorEnum;
import com.app.clinicaescola.repository.EmployeeRepository;
import com.app.clinicaescola.repository.PatientRepository;
import com.app.clinicaescola.validations.SectorValidation;
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
    
    public List<Patient> listPatients(String employeeFirstName) {
        Employee employee = employeeRepo.findByFirstName(employeeFirstName);
        
        String sectorEmployee = employee.getKind().getName();
        
        if(SectorValidation.belongsToSector(
                SectorEnum.CLINIC, sectorEmployee)) {
            return patientRepo.findAll();
        }
        
        return null;
    }
    
    public List<Patient> createPatient(Patient newPatient, String employeeFirstName) {
        Employee employee = employeeRepo.findByFirstName(employeeFirstName);
        
        String sectorEmployee = employee.getKind().getName();
        
        if(SectorValidation.belongsToSector(
                SectorEnum.CLINIC, sectorEmployee)) {
            patientRepo.save(newPatient);
            return patientRepo.findAll();
        }
        
        return null;
    }
    
    public void removePatient(String employeeFirstName, String id) {
        Employee employee = employeeRepo.findByFirstName(employeeFirstName);
        
        String sectorEmployee = employee.getKind().getName();
        
        if(SectorValidation.belongsToSector(
                SectorEnum.CLINIC, sectorEmployee)) {
            patientRepo.delete(id);
        }
    }
    
}
