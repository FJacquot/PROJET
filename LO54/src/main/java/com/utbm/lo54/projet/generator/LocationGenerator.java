/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.utbm.lo54.projet.generator;

import com.utbm.lo54.projet.database.dbQuery;
import com.utbm.lo54.projet.model.Location;
import com.utbm.lo54.projet.qualifier.LocationQualifier;
import java.io.Serializable;
import java.util.ArrayList;
import javax.enterprise.context.SessionScoped;
import javax.enterprise.inject.Produces;

/**
 *
 * @author JFWIN7
 */
@SessionScoped
public class LocationGenerator implements Serializable{
    @Produces @LocationQualifier ArrayList<Location> getCities(){
        return new dbQuery().getCities();
    }
}
