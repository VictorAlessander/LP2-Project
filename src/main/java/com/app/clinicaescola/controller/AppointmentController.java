/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.clinicaescola.controller;

import com.app.clinicaescola.entity.Appointment;
import com.app.clinicaescola.service.AppointmentService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author vagr
 */

@RestController
public class AppointmentController {
    
    @Autowired
    AppointmentService appointment;
    
    @RequestMapping(value = "/appointments", method = RequestMethod.GET)
    public List<Appointment> list() {
        return this.appointment.listAppointments();
    }
    
    @RequestMapping(value = "/appointments", method = RequestMethod.POST)
    public List<Appointment> create(@RequestBody Appointment newAppointment) {
        return this.appointment.createAppointment(newAppointment);
    }

}
