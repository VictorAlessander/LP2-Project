/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.clinicaescola.service;

import com.app.clinicaescola.entity.Appointment;
import com.app.clinicaescola.entity.Employee;
import com.app.clinicaescola.repository.AppointmentRepository;
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
public class OperationService {
    
    @Autowired
    EmployeeRepository employeeRepo;
    
    @Autowired
    AppointmentRepository appointmentRepo;
    
   public List<Appointment> newAppointment(
           Appointment appointment,
           String employeeFirstName) {
       Employee employee = employeeRepo.findByFirstName(employeeFirstName);
       
       if("operational".equals(employee.getKind().getName())) {
           appointmentRepo.save(appointment);
           return appointmentRepo.findAll();
       }
       else{
           return null;
       }
   }
        
    public List<Appointment> listAppointments(boolean attended) {
        return appointmentRepo.findByAttended(attended);
    }
    
    public List<Appointment> listAllAppointments() {
        return appointmentRepo.findAll();
    }

}
