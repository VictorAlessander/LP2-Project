/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.clinicaescola.service;

import com.app.clinicaescola.entity.Appointment;
import com.app.clinicaescola.entity.Employee;
import com.app.clinicaescola.enums.SectorEnum;
import com.app.clinicaescola.repository.AppointmentRepository;
import com.app.clinicaescola.repository.EmployeeRepository;
import com.app.clinicaescola.validations.SectorValidation;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author vagr
 */

@Service
public class AppointmentService {
    
    @Autowired
    AppointmentRepository appointmentRepo;
    
    @Autowired
    EmployeeRepository employeeRepo;
    
    public List<Appointment> listAllAppointments(String employeeFirstName) {

        Employee employee = employeeRepo.findByFirstName(employeeFirstName);
       
        String sectorEmployee = employee.getKind().getName();
        
        if(SectorValidation.belongsToSector(
                SectorEnum.OPERATIONAL, sectorEmployee)) {
            return appointmentRepo.findAll();
        }
        
        return null;
    }
    
   public List<Appointment> newAppointment(
           Appointment appointment,
           String employeeFirstName) {

       Employee employee = employeeRepo.findByFirstName(employeeFirstName);
       
        String sectorEmployee = employee.getKind().getName();
        
        if(SectorValidation.belongsToSector(
                SectorEnum.OPERATIONAL, sectorEmployee)) {
            appointmentRepo.save(appointment);
            return appointmentRepo.findAll();
        }
        
        return null;
   }

    public List<Appointment> listAppointmentsAttended(boolean attended) {
        return appointmentRepo.findByAttended(attended);
    }

    public void removeAppointment(String id, String employeeFirstName) {

        Employee employee = employeeRepo.findByFirstName(employeeFirstName);

        String sectorEmployee = employee.getKind().getName();
        
        if(SectorValidation.belongsToSector(
                SectorEnum.OPERATIONAL, sectorEmployee)) {
            this.appointmentRepo.delete(id);
        }
    }
}
