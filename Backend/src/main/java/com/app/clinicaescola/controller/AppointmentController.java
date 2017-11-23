/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.clinicaescola.controller;

import com.app.clinicaescola.entity.Appointment;
import com.app.clinicaescola.service.AppointmentService;
import com.app.clinicaescola.service.EmployeeService;
import java.io.IOException;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author TI
 */

@RestController
public class AppointmentController {
    
    @Autowired
    AppointmentService appointment;
    
    @Autowired
    EmployeeService employee;
    
    @RequestMapping(value = "/appointments/{firstName}",
            method = RequestMethod.GET)
    public List<Appointment> list(
            @PathVariable("firstName") String employeeFirstName) {
        
        if(this.appointment.listAllAppointments(employeeFirstName) == null) {
            throw new SectorException();
        }
        else {
            return this.appointment.listAllAppointments(employeeFirstName);
        }
    }
    
    @RequestMapping(value = "/appointments/{firstName}",
            method = RequestMethod.POST)
    public List<Appointment> create(
            @RequestBody Appointment newAppointment,
            @PathVariable("firstName") String employeeFirstName) {
        
        if(this.appointment.newAppointment(newAppointment, employeeFirstName) == null) {
            throw new SectorException();
        }
        else {
            return this.appointment.newAppointment(
                newAppointment, employeeFirstName);
        }
    }
    
    @RequestMapping(value = "/appointments/{firstName}",
            method = RequestMethod.PUT)
    public List<Appointment> update(
            @RequestBody Appointment appointment,
            @PathVariable("firstName") String employeeFirstName) {
    
        if(this.appointment.newAppointment(appointment, employeeFirstName) == null) {
            throw new SectorException();
        }
        else{
            return this.appointment.newAppointment(
                    appointment, employeeFirstName);
        }
    }
    
    @RequestMapping(value = "/appointments/{id}/{firstName}",
            method = RequestMethod.DELETE)
    public void delete(
            @PathVariable("id") String id,
            @PathVariable("firstName") String employeeFirstName) {

        this.appointment.removeAppointment(
                id, employeeFirstName);
    }
    
    @RequestMapping(value = "/appointments/filter/{attended}/{firstName}", method = RequestMethod.GET)
    public List<Appointment> listAppointmentsbyAttended(
            @PathVariable("attended") boolean flag,
            @PathVariable("firstName") String employeeFirstName) {
        
        return this.appointment.listAppointmentsAttended(flag);
    }
    
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public void handleBadRequest(
            HttpServletResponse response) throws IOException {
        response.sendError(
                HttpStatus.BAD_REQUEST.value(),
                "Insert a date with format 'dd-MM-yyyy'");
    }
}
