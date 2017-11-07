/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.clinicaescola.controller;

import com.app.clinicaescola.entity.Appointment;
import com.app.clinicaescola.service.AppointmentService;
import com.app.clinicaescola.service.EmployeeService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
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
    
    @RequestMapping(value = "/appointments/{firstName}", method = RequestMethod.GET)
    public List<Appointment> list(@PathVariable("firstName") String employeeFirstName) {
        return this.appointment.listAllAppointments();
    }
    
    @RequestMapping(value = "/appointments/{firstName}", method = RequestMethod.POST)
    public List<Appointment> create(
            @RequestBody Appointment newAppointment,
            @PathVariable("firstName") String employeeFirstName)
}
