/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.utbm.lo54.projet.manager;

import com.utbm.lo54.projet.model.CourseSession;
import com.utbm.lo54.projet.model.Location;
import com.utbm.lo54.projet.qualifier.LocationQualifier;
import com.utbm.lo54.projet.qualifier.CourseSessionQualifier;
import java.io.Serializable;
import java.util.ArrayList;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.enterprise.inject.Instance;
import javax.inject.Inject;
import javax.inject.Named;
/**
 *
 * @author JFWIN7
 */
@RequestScoped
@Named
public class CourseManager implements Serializable {
    @Inject @CourseSessionQualifier Instance<ArrayList<CourseSession>> crss;
    private ArrayList<CourseSession> crssList;
      
 
    CourseManager(){
    }
        
    public void manage(){
        this.crssList = crss.get();
    }

    public Instance<ArrayList<CourseSession>> getCrss() {
        return this.crss;
    }

    public void setCrss(Instance<ArrayList<CourseSession>> crss) {
        this.crss = crss;
    }

    public ArrayList<CourseSession> getCrssList() {
        return this.crssList;
    }
 
}
