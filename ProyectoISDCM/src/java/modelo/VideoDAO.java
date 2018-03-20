/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;
import clases.Video;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.text.DateFormat;
import java.util.Vector;

import java.util.logging.Level;
import java.util.logging.Logger;

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

        ResultSet res = sta.executeQuery("SELECT IDENTIFICADOR FROM ROOT.VIDEOS");
        while (res.next()) {
 
                cont++;                      
        }

        return cont;
    }
    
    public void registrarVideo(long idVideo, String titulo, String autor, String fecha, String duracion, String descripcion, String formato, String url, String id_usuario) throws SQLException {
        
        int reproduccion = 0;
        Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/dbISDCM", "root", "root");
        Statement sta = con.createStatement(); 
        
        String SQL = "INSERT INTO ROOT.USUARIOS VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement pstmt = con.prepareStatement(SQL);
        pstmt.setLong(1, idVideo);
        pstmt.setString(2, titulo);
        pstmt.setString(3, autor);
        pstmt.setDate(4, Date.valueOf(fecha));
        pstmt.setTime(5, Time.valueOf(duracion));
        pstmt.setInt(6, reproduccion);
        pstmt.setString(7, descripcion);
        pstmt.setString(8, formato);
        pstmt.setString(9, url);
        pstmt.setString(10, id_usuario);
        pstmt.executeUpdate();
        pstmt.close();
    }
    
    public Vector<Video> listaVideos(String identificador) throws SQLException {
        
        Vector<Video> lista = new Vector<Video>();
        
        try {
            Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/dbISDCM", "root", "root");

            Statement sta = con.createStatement(); 

            String SQL = ("SELECT * FROM ROOT.VIDEOS WHERE ID_USUARIO=?");
            PreparedStatement pstmt = con.prepareStatement(SQL);
            pstmt.setString(1, identificador);
            ResultSet res = pstmt.executeQuery();    

            while (res.next()) {
                if (res.getString("ID_USUARIO").equals(identificador)) {

                    //Crear nuevo video por cada iteración
                    Video video = new Video(res.getString("TITULO"), res.getString("AUTOR"), 
                                  Date.valueOf(res.getString("FECHA")), res.getString("DURACION"), 
                                  res.getInt("REPRODUCCION"), res.getString("DESCRIPCION"), 
                                  res.getString("FORMATO"), res.getString("url"), res.getString("ID_USUARIO"));
                    lista.addElement(video);
                }           
            }
        }
        catch(Exception e) {
            System.out.println(e);
        }
        
        return lista;
    }
}
