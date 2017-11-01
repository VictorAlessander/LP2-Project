/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.clinicaescola.entity;

import javax.persistence.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 *
 * @author vagr
 */

@Document
public class Appointment {
    
    @Id
    private String id;
    
    private String medical_specialty;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMedical_specialty() {
        return medical_specialty;
    }

    public void setMedical_specialty(String medical_specialty) {
        this.medical_specialty = medical_specialty;
    }
    
}
