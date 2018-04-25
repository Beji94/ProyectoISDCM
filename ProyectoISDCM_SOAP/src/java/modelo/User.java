/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Beñat
 */
public class User {
    public void User () {
        
    }
    
    public int login(String id, String passwd) throws SQLException {
        int nick = 0;
        int pass = 0;
        int ok = 0;
        Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/dbISDCM", "root", "root");
        
        Statement sta = con.createStatement(); 

        ResultSet res = sta.executeQuery("SELECT IDENTIFICADOR FROM ROOT.USUARIOS");
        while (res.next()) {
            if (res.getString("IDENTIFICADOR").equals(id)) {
                nick = 1;
                
            }
        }
        res = sta.executeQuery("SELECT PASSWD FROM ROOT.USUARIOS");
        
        while (res.next()) {
            if (res.getString("PASSWD").equals(passwd)) {
                pass = 1;
                
            }
        }
        
        if (nick==1 & pass==1) {
            ok=1; //Login correto
        }
        else if (nick==0 || pass==0) {
            ok=0; //Nick o contraseña erronea
        }
        return ok;
    }
 
    public int userExist(String email, String id){
        int exist = 0;

        try{
            Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/dbISDCM", "root", "root");
            Statement sta = con.createStatement(); 

            ResultSet res = sta.executeQuery("SELECT EMAIL FROM ROOT.USUARIOS");
            while(res.next()){
                if (res.getString("EMAIL").equals(email)){
                    exist = 1;
                }
               //System.out.println("REEEES: "+res.getString("email"));  
            }
            res = sta.executeQuery("SELECT IDENTIFICADOR FROM ROOT.USUARIOS");
            while(res.next()){
                if(res.getString("IDENTIFICADOR").equals(id)){
                    exist = 2;
                }
            }

            }catch(Exception e) {
                System.out.println(e);
            }
        return exist;
    }
    
    public void crearUsuario(String nombre, String apellidos, String email, String identificador, String passwd){
        try{
            Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/dbISDCM", "root", "root");
            Statement sta = con.createStatement(); 
            
            String SQL = "INSERT INTO ROOT.USUARIOS VALUES (?, ?, ?, ?, ?)";
            PreparedStatement pstmt = con.prepareStatement(SQL);
            pstmt.setString(1, nombre.toLowerCase());
            pstmt.setString(2, apellidos.toLowerCase());
            pstmt.setString(3, email);
            pstmt.setString(4, identificador);
            pstmt.setString(5, passwd);
            pstmt.executeUpdate();
            pstmt.close();
            
        }catch(Exception e) {
            System.out.println(e);
        } 
    }
    
}
