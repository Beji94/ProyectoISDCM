/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Beñat
 */
public class Usuario {
    
    private String nombre;
    private String apellidos;
    private String correo;
    private String identificador;
    private String passwd;    
    private String direccion;
    private String telefono;

    public Usuario (String nombre, String apellidos, String correo, String identificador, String passwd,
                String direccion, String telefono) {
    this.nombre = nombre;
    this.apellidos = apellidos;
    this.correo = correo;
    this.identificador = identificador;
    this.passwd = passwd;
    this.direccion = direccion;
    this.telefono = telefono;
    }
    
    public Usuario (String identificador, String passwd) {
        this.identificador = identificador;
        this.passwd = passwd;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    

    
}
