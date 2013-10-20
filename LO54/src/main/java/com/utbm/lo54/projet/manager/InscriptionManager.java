/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.utbm.lo54.projet.manager;

import com.utbm.lo54.projet.database.dbQuery;
import com.utbm.lo54.projet.model.Client;
import com.utbm.lo54.projet.model.CourseSession;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author JFWIN7
 */
@Named
@SessionScoped
public class InscriptionManager implements Serializable {
    private @Inject Client cli;
    private CourseSession crs;
    private static final String INSCRIPTION_URI ="inscription";
   
    InscriptionManager() {
    }
 
    public String submit(CourseSession crs){
        this.crs = crs;
        return INSCRIPTION_URI;
    }
    
    public void inscription(){
        if(cli.getFirstname().isEmpty() ||cli.getLastname().isEmpty() || cli.getAddress().isEmpty() || cli.getPhone().isEmpty() || cli.getEmail().isEmpty()){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Incorrect form"));
        }
        else{
            new dbQuery().inscription(cli, crs.getId());
        }
    }
    
    public Client getCli() {
        return cli;
    }

    public void setCli(Client cli) {
        this.cli = cli;
    }

    public CourseSession getCrs() {
        return crs;
    }

    public void setCrs(CourseSession crs) {
        this.crs = crs;
    }
    
}
