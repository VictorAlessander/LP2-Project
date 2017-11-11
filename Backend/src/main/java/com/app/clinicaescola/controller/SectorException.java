/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.clinicaescola.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *
 * @author vagr
 */

@ResponseStatus(
        value = HttpStatus.NOT_ACCEPTABLE,
        reason="This Employee doesn't have access to make this request")
public class SectorException extends RuntimeException {
}
