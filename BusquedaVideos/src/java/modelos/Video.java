/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

import java.sql.Date;

/**
 *
 * @author Beñat
 */
public class Video {
    
    private String titulo;
    private String autor;
    private Date fecha;
    private String fechaxml;
    private String duracion;
    private int reproduccion;
    private String descripcion;
    private String formato;
    private String url;
    private String idUsuario;
    private int aPubli;


    
    public Video(String titulo, String autor, Date fecha, String duracion, int reproduccion, String descripcion, String formato, String url, String idUsuario, int aPubli ) {
        this.titulo = titulo;
        this.autor = autor;
        this.fecha = fecha;
        this.duracion = duracion;
        this.reproduccion = reproduccion;
        this.descripcion = descripcion;
        this.formato = formato;
        this.url = url;
        this.idUsuario = idUsuario;
        this.aPubli = aPubli;
        this.fechaxml=fecha.toString().replace("-", "/");
    } 
    
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha =  fecha;
    }

    public void setFechaxml(String fechaxml) {
        this.fechaxml = fecha.toString();
       
        
    }
     public String getFechaxml() {
            
          return this.fechaxml;
          
    }
    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    public int getReproduccion() {
        return reproduccion;
    }

    public void setReproduccion(int reproduccion) {
        this.reproduccion = reproduccion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFormato() {
        return formato;
    }

    public void setFormato(String formato) {
        this.formato = formato;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }
    
    public int getaPubli() {
        return aPubli;
    }

    public void setaPubli(int aPubli) {
        this.aPubli = aPubli;
    }
}
