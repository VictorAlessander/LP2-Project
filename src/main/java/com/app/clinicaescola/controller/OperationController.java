/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.clinicaescola.controller;

import com.app.clinicaescola.entity.Appointment;
import com.app.clinicaescola.service.OperationService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author vagr
 */

@RestController
public class OperationController {
    
    @Autowired
    OperationService operation;
    
    @RequestMapping(value = "/operation/appointments", method = RequestMethod.GET)
    public List<Appointment> list() {
        return this.operation.listAllAppointments();
    }    
    
    @RequestMapping(value = "/operation/appointments/{status}", method = RequestMethod.GET)
    public List<Appointment> listSelected(@PathVariable("status") boolean attended) {
        return this.operation.listAppointments(attended);
    }
    
    @RequestMapping(value = "/operation/appointments/{firstname}", method = RequestMethod.POST)
    public List<Appointment> createAppointment(
            @RequestBody Appointment newAppointment,
            @PathVariable("firstname") String employeeFirstName) {
        
        return this.operation.newAppointment(newAppointment, employeeFirstName);
    }

}
