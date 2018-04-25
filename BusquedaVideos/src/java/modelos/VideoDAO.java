/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;
import modelos.Video;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
     public int verificarURL(String identificador, String url) throws SQLException {
        int cont = 0;
        Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/dbISDCM", "root", "root");
        
        String SQL = ("SELECT URL FROM ROOT.VIDEOS WHERE ID_USUARIO=?");
        PreparedStatement pstmt = con.prepareStatement(SQL);
        pstmt.setString(1, identificador);
        ResultSet res = pstmt.executeQuery();
        
        while(res.next()){
            if(res.getString("URL").equals(url)) {
                cont++;
            }
        }
        return cont;
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
    
    public void registrarVideo(long idVideo, String titulo, String autor, String duracion, String descripcion, String formato, String url, String id_usuario) throws SQLException, ParseException {
        
        int reproduccion = 0;
        Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/dbISDCM", "root", "root");
        Statement sta = con.createStatement(); 
        
        java.util.Date utilDate = new java.util.Date();
        java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
        
        
        String SQL = "INSERT INTO ROOT.VIDEOS (IDENTIFICADOR, TITULO, AUTOR, FECHA, DURACION, REPRODUCCION, DESCRIPCION, FORMATO, URL, ID_USUARIO) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement pstmt = con.prepareStatement(SQL);
        pstmt.setLong(1, idVideo);
        pstmt.setString(2, titulo);
        pstmt.setString(3, autor);
        pstmt.setDate(4, sqlDate);
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
                                  res.getString("FORMATO"), res.getString("url"), res.getString("ID_USUARIO"),
                                  res.getInt("APUBLI"));
                    lista.addElement(video);
                }           
            }
        }
        catch(Exception e) {
            System.out.println(e);
        }
        
        return lista;
    }
    public Vector<Video> busqueda(String autor, String titulo, int apubliDesde, 
            int apubliHasta, String idUsuario) throws SQLException {
        
        Vector<Video> lista = new Vector<Video>();
        autor = autor + "%";
        titulo = titulo + "%"; 
        java.util.Date utilDate = new java.util.Date();
        java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
        if(apubliDesde==0) {
            apubliDesde=1950;
        }
        if(apubliHasta==0) {
            apubliHasta = 2500;
        }
        if(apubliHasta < apubliDesde) {
            int x = apubliHasta;
            apubliHasta = apubliDesde;
            apubliDesde = x;
        }
        
        try {
            Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/dbISDCM", "root", "root");

            Statement sta = con.createStatement(); 
            
            String SQL = ("SELECT * FROM ROOT.VIDEOS WHERE ID_USUARIO=? AND AUTOR LIKE ? AND TITULO LIKE ? AND APUBLI BETWEEN ? AND ? ");
            
            PreparedStatement pstmt = con.prepareStatement(SQL);
            pstmt.setString(1, idUsuario);
            pstmt.setString(2, autor);
            pstmt.setString(3, titulo);
            pstmt.setInt(4, apubliDesde);
            pstmt.setInt(5, apubliHasta);
            
            ResultSet res = pstmt.executeQuery();    

            while (res.next()) {
                
                //Crear nuevo video por cada iteración
                Video video = new Video(res.getString("TITULO"), res.getString("AUTOR"), 
                              Date.valueOf(res.getString("FECHA")), res.getString("DURACION"), 
                              res.getInt("REPRODUCCION"), res.getString("DESCRIPCION"), 
                              res.getString("FORMATO"), res.getString("url"), res.getString("ID_USUARIO"),
                              res.getInt("APUBLI"));
                lista.addElement(video);
                
            }
            
            if (lista.isEmpty()) {
                Video v1 = new Video("TITULO", "AUTOR", 
                              sqlDate, "DURACION", 
                              0, "DESCRIPCION", 
                              "FORMATO", "url", "ID_USUARIO",
                              1950);
            }
        }
        catch(Exception e) {
            System.out.println(e);
        }
        
        
        
        return lista;
    }
}
