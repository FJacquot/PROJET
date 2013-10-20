/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.utbm.lo54.projet.database;

import com.utbm.lo54.projet.model.Client;
import com.utbm.lo54.projet.model.CourseSession;
import com.utbm.lo54.projet.model.Location;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 *
 * @author JFWIN7
 */
public class dbQuery {
    
    public static final String JNDI_NAME = "java:/lo54";
    
    private Connection getConnection(){
        Connection con = null;
        try {
            Context namingContext = new InitialContext();
            DataSource dataSource = (DataSource) namingContext.lookup(JNDI_NAME);
            con = dataSource.getConnection();
        } catch (NamingException ex) {
            Logger.getLogger(dbQuery.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(dbQuery.class.getName()).log(Level.SEVERE, null, ex);
        }        
        return con;
    }
    
    public ArrayList<CourseSession> searchCourseSession(CourseSession crs){
        ArrayList<CourseSession> crss = new ArrayList<CourseSession>();
        Connection con = this.getConnection();
        if(con != null){
            try {          
                Statement st = con.createStatement();
            
                if(st != null){
                    String sQuery = "SELECT CSS.ID, CRS.TITLE, LOC.CITY, CSS.START, CSS.END FROM COURSE_SESSION CSS, COURSE CRS, LOCATION LOC WHERE CSS.COURSE_CODE = CRS.CODE AND CSS.LOCATION_ID = LOC.ID";

                    if(!crs.getTitle().isEmpty())
                        sQuery += " AND UPPER(CRS.TITLE) REGEXP '"+crs.getTitle().toUpperCase()+"' ";
                    if(!crs.getLocation().isEmpty())
                        sQuery += " AND UPPER(LOC.CITY) = '"+crs.getLocation().toUpperCase()+"' ";
                    if(crs.getStart() != null)
                        sQuery += " AND CSS.START = '"+new SimpleDateFormat("yyyy-MM-dd").format(crs.getStart())+"' ";
                    else
                        sQuery += " AND CSS.START >= '"+new SimpleDateFormat("yyyy-MM-dd").format(new Date())+"' ";
                    
                    sQuery+= " ORDER BY CSS.START";
                    
                    //System.out.println(sQuery);

                    ResultSet result = st.executeQuery(sQuery);

                    while(result.next()){
                        CourseSession courseSession = new CourseSession();
                        courseSession.setId(result.getInt("ID"));
                        courseSession.setTitle(result.getString("TITLE"));
                        courseSession.setEnd(result.getDate("END"));
                        courseSession.setStart(result.getDate("START"));
                        courseSession.setLocation(result.getString("CITY"));
                        crss.add(courseSession);
                    }
                    st.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(dbQuery.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return crss;
    }

    public ArrayList<Location> getCities() {
       ArrayList<Location> cities = new ArrayList<Location>();
        Connection con = this.getConnection();
        if(con != null){
            try {          
                Statement st = con.createStatement();
            
                if(st != null){
                    String sQuery = "SELECT * FROM LOCATION";

                    ResultSet result = st.executeQuery(sQuery);
                    
                    while(result.next()){
                        Location city = new Location();
                        city.setId(result.getInt("ID"));
                        city.setCity(result.getString("CITY"));
                        cities.add(city);
                    }
                    st.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(dbQuery.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return cities;        
    }
    
     public void inscription(Client cli, int crssId) {
        
        Connection con = this.getConnection();
       
        if(con != null){
            try {          
                Statement st = con.createStatement();
                if(st != null){
                    st.executeUpdate("INSERT INTO CLIENT (LASTNAME, FIRSTNAME, ADDRESS, PHONE, EMAIL, SESSION_ID) VALUES ('"+cli.getLastname()+"', '"+cli.getFirstname()+"', '"+cli.getAddress()+"', '"+cli.getPhone()+"', '"+cli.getEmail()+"', '"+crssId+"')");

                }
                st.close();
            } catch (SQLException ex) {
                Logger.getLogger(dbQuery.class.getName()).log(Level.SEVERE, null, ex);
            }
        }   
     }


}
