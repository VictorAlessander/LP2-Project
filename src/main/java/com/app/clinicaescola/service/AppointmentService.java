/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.clinicaescola.service;

import com.app.clinicaescola.entity.Appointment;
import com.app.clinicaescola.repository.AppointmentRepository;
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
    AppointmentRepository appointment;
    
    public List<Appointment> listAppointments() {
        return appointment.findAll();
}
    
    public List<Appointment> createAppointment(Appointment newAppointment) {
        appointment.save(newAppointment);
        
        return appointment.findAll();
    }
}
