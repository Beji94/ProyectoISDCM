/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import clases.Video;
import java.io.IOException;
import java.io.PrintWriter;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.VideoDAO;

/**
 *
 * @author Beñat
 */
public class servletRegistroVid extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("text/html;charset=UTF-8");
        long idVideo=0;
         if (request.getSession().getAttribute("identificador")==null) {
            request.setAttribute("noLogin", "true");
            request.setAttribute("mensaje", "Usted no se ha iniciado sesión");
            request.getRequestDispatcher("login.jsp").forward(request, response);
         }
         else if (request.getParameter("videos") != null) {   
             //Obtener el identificador del usuario mediante la sesion
             HttpSession sesion = (HttpSession) request.getSession();
             String idUsuario = (String) sesion.getAttribute("identificador");
             
             VideoDAO video = new VideoDAO();
             
            try {
                //El identificador de video sera la cantidad de videos en la base de datos más 1.
                idVideo = video.contarVideos(idUsuario)+1;
            } catch (SQLException ex) {
                Logger.getLogger(servletRegistroVid.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            try {
                video.registrarVideo(idVideo, request.getParameter("titulo"), request.getParameter("autor"), request.getParameter("duracion"), request.getParameter("descripcion"), request.getParameter("formato"), request.getParameter("url"), idUsuario);
                VideoDAO videoDAO = new VideoDAO();
                Vector<Video> listaVideos = new Vector<Video>();
                try {
                    listaVideos = videoDAO.listaVideos((String) request.getSession().getAttribute("identificador"));
                } catch (SQLException ex) {
                    Logger.getLogger(servletUser.class.getName()).log(Level.SEVERE, null, ex);
                }
                request.setAttribute("listadoVideos", listaVideos);
                request.getRequestDispatcher("lista_videos.jsp").forward(request, response);
                
            } catch (SQLException ex) {
                Logger.getLogger(servletRegistroVid.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ParseException ex) {
                Logger.getLogger(servletRegistroVid.class.getName()).log(Level.SEVERE, null, ex);
            }
            
         }
         
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
