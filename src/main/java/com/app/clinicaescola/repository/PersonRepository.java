/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.clinicaescola.repository;

import com.app.clinicaescola.entity.Person;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 *
 * @author vagr
 */

public interface PersonRepository extends MongoRepository<Person, String> {}
