/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.clinicaescola.validations;

import com.app.clinicaescola.enums.SectorEnum;

/**
 *
 * @author vagr
 */

public class SectorValidation {


    public static boolean belongsToSector(
            SectorEnum enumType, String employeeSector) {
        
        return enumType.toString().equalsIgnoreCase(employeeSector);
    }
}
