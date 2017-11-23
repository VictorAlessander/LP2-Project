/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.clinicaescola.controller;

import com.app.clinicaescola.entity.Appointment;
import com.app.clinicaescola.entity.Employee;
import com.app.clinicaescola.service.EmployeeReportService;
import com.app.clinicaescola.service.PatientReportService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author vagr
 */

@RestController
public class ReportController {
    
    @Autowired
    PatientReportService patientReports;
    
    @Autowired
    EmployeeReportService employeeReports;
    
    @RequestMapping(
            value = "/reports/{patientFirstName}/{employeeFirstName}",
            method = RequestMethod.GET)
    public List<Appointment> getPatientReport(
            @PathVariable("patientFirstName") String patientFirstName,
            @PathVariable("employeeFirstName") String employeeFirstName) {
        
        if(this.patientReports.showReport(
                patientFirstName, employeeFirstName) == null) {
            throw new SectorException();
        }
        else {
            return this.patientReports.showReport(
                patientFirstName, employeeFirstName);
        }
    }

    @RequestMapping(
            value = "/reports/{employeeFirstName}/{employeeRequest}",
            method = RequestMethod.GET)
    public Employee getEmployeeReport(
            @PathVariable("employeeFirstName") String employeeFirstName,
            @PathVariable("employeeRequest") String employeeRequest) {

        return this.employeeReports.showReport(
                employeeRequest, employeeFirstName);
    }
}
