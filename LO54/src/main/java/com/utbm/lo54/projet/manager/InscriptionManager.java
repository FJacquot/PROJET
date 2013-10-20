/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.utbm.lo54.projet.manager;

import com.utbm.lo54.projet.model.Client;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author JFWIN7
 */
@Named
@RequestScoped
public class InscriptionManager {
    private Client cli;
    private int crssId;
    private String address;
    private String city;
    private String postcode;
   
    
    InscriptionManager() {
    }

    public void inscription() {
        
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public Client getCli() {
        return cli;
    }

    public void setCli(Client cli) {
        this.cli = cli;
    }

    public int getCrssId() {
        return crssId;
    }

    public void setCrssId(int crssId) {
        this.crssId = crssId;
    }
}
