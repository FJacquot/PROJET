/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.utbm.lo54.projet.manager;

import com.utbm.lo54.projet.model.Location;
import com.utbm.lo54.projet.qualifier.LocationQualifier;
import java.io.Serializable;
import java.util.ArrayList;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.enterprise.inject.Instance;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author JFWIN7
 */
@Named
@SessionScoped
public class LocationManager implements Serializable{
    @Inject @LocationQualifier Instance<ArrayList<Location>> cities;
    private ArrayList<Location> citiesList;
    
    LocationManager(){
    }
        
    @PostConstruct
    public void manage(){
        this.citiesList = cities.get();
    }
    
    public ArrayList<Location> getCitiesList() {
        return citiesList;
    }

    public void setCitiesList(ArrayList<Location> citiesList) {
        this.citiesList = citiesList;
    }   
}
