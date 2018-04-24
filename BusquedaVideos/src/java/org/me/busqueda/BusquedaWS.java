/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.me.busqueda;

import java.sql.Date;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.ejb.Stateless;
import modelos.Video;
import modelos.VideoDAO;

/**
 *
 * @author Beñat
 */
@WebService(serviceName = "BusquedaWS")
@Stateless()
public class BusquedaWS {

    /**
     * Web service operation
     */
    @WebMethod(operationName = "busqueda")
    public Vector<modelos.Video> busqueda(@WebParam(name = "autor") String autor, 
            @WebParam(name = "titulo") String titulo, @WebParam(name = "apubliDesde") int apubliDesde, 
            @WebParam(name = "apubliHasta") int apubliHasta,@WebParam(name = "usuario") String usuario) {
        Vector<Video> listaVideo = new Vector<Video>();
        VideoDAO vDAO = new VideoDAO();
        try {
            if(autor.equals(null)) autor = "%";
            if(titulo.equals(null)) titulo = "%";
            if(Integer.toString(apubliDesde).equals(null)) apubliDesde=0;
            if(Integer.toString(apubliHasta).equals(null)) apubliHasta=0;
            
            listaVideo= vDAO.busqueda(autor, titulo, apubliDesde, apubliHasta, usuario);
        } catch (SQLException ex) {
            Logger.getLogger(BusquedaWS.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaVideo;
    }
}
