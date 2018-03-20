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
import java.util.Date;

/**
 *
 * @author Beñat
 */
public class VideoDAO {
    
    public VideoDAO() {
        
    }
    
    public int contarVideos(String identificador) throws SQLException {
        int cont=0;
        
        Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/dbISDCM", "root", "root");
        
        Statement sta = con.createStatement(); 

        ResultSet res = sta.executeQuery("SELECT ID_USUARIO FROM ROOT.VIDEOS");
        while (res.next()) {
            if (res.getString("ID_USUARIO").equals(identificador)) {
                cont++;             
            }           
        }

        return cont;
    }
    
    public void registrarVideo(String titulo, String autor, Date fecha, float duracion, String descripcion, String url, String id_usuario) {
        
    }
}
