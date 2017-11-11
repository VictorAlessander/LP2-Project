/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.clinicaescola.controller;

import com.app.clinicaescola.entity.Kind;
import com.app.clinicaescola.service.KindService;
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
public class KindController {
    
    @Autowired
    KindService kind;
    
    @RequestMapping(value = "/kinds", method = RequestMethod.GET)
    public List<Kind> list() {
        return this.kind.listKinds();
    }
    
    @RequestMapping(value = "/kinds", method = RequestMethod.POST)
    public List<Kind> create(@RequestBody Kind newKind) {
        return this.kind.createKind(newKind);
    }
    
    @RequestMapping(value = "/kinds", method = RequestMethod.PUT)
    public List<Kind> update(@RequestBody Kind kind) {
        return this.kind.createKind(kind);
    }
    
    @RequestMapping(value = "/kinds/{id}", method = RequestMethod.DELETE)
    public void remove(@PathVariable("id") String kindId) {
        this.kind.removeKind(kindId);
    }
}
