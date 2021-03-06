/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.clinicaescola.service;

import com.app.clinicaescola.entity.Appointment;
import com.app.clinicaescola.entity.Employee;
import com.app.clinicaescola.entity.Patient;
import com.app.clinicaescola.enums.SectorEnum;
import com.app.clinicaescola.repository.AppointmentRepository;
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
public class PatientReportService {
    
    @Autowired
    PatientRepository patientRepo;

    @Autowired
    AppointmentRepository appointmentRepo;
    
    @Autowired
    EmployeeRepository employeeRepo;

    public List<Appointment> showReport(
            String patientName, String employeeFirstName) {
        Patient patient = patientRepo.findByFirstName(patientName);
        
        Employee employee = employeeRepo.findByFirstName(employeeFirstName);
        
        String sectorEmployee = employee.getKind().getName();
        
        if(SectorValidation.belongsToSector(
                SectorEnum.ADMINISTRATIVE, sectorEmployee)) {
            return appointmentRepo.findByPatient(patient);
        }
        
        return null;
    }
}
