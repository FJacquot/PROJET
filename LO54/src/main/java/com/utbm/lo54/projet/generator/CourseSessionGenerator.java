/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.utbm.lo54.projet.generator;

import com.utbm.lo54.projet.database.dbQuery;
import com.utbm.lo54.projet.model.CourseSession;
import com.utbm.lo54.projet.qualifier.CourseSessionQualifier;
import java.util.Date;
import java.util.ArrayList;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author JFWIN7
 */

@Named
@RequestScoped
public class CourseSessionGenerator{
    
    private String title;
    private String location;
    private Date start;
    private @Inject CourseSession crs;
    
   
    @Produces @CourseSessionQualifier ArrayList<CourseSession> getCrss(){
        return new dbQuery().searchCourseSession(this.crs);
    }

    public String getTitle() {
        return this.title;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }

    public String getLocation() {
        return this.location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Date getStart() {
        return this.start;
    }

    public void setStart(Date start) {
        this.start = start;
    }  
    
}
