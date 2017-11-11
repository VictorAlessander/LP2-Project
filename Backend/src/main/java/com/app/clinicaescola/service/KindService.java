/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.clinicaescola.service;

import com.app.clinicaescola.entity.Kind;
import com.app.clinicaescola.repository.KindRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author vagr
 */

@Service
public class KindService {
    
    @Autowired
    KindRepository type;
    
    public List<Kind> listKinds() {
        return type.findAll();
    }
    
    public List<Kind> createKind(Kind newKind) {
        type.save(newKind);
        
        return type.findAll();
    }
}
