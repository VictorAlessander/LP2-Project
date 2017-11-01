/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.clinicaescola.entity;

import java.util.Collection;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 *
 * @author vagr
 */

// @Document(collection = "person")
@Document
public class Employee extends Person {
    
    @DBRef
    private Collection<Kind> kinds;

    public Collection<Kind> getKinds() {
        return kinds;
    }

    public void setKinds(Collection<Kind> kinds) {
        this.kinds = kinds;
    }
    
}
