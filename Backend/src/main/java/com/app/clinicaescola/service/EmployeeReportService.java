/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.clinicaescola.service;

import com.app.clinicaescola.entity.Employee;
import com.app.clinicaescola.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.app.clinicaescola.enums.SectorEnum;
import com.app.clinicaescola.validations.SectorValidation;

/**
 *
 * @author vagr
 */

@Service
public class EmployeeReportService {
    
    @Autowired
    EmployeeRepository employeeRepo;
    
    public Employee showReport(
            String employeeRequest, String employeeFirstName) {
        
        Employee employee = employeeRepo.findByFirstName(employeeRequest);

        String sectorEmployee = employee.getKind().getName();

        if (SectorValidation.belongsToSector(SectorEnum.ADMINISTRATIVE, sectorEmployee)) {
            return employeeRepo.findByFirstName(employeeFirstName);
        }
        else {
            return null;
        }
    }
}
