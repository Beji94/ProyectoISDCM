/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.IOException;
import java.io.PrintWriter;

import java.sql.SQLException;
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

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet servletRegistroVid</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet servletRegistroVid at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("text/html;charset=UTF-8");
        long idVideo=0;
         if (request.getParameter("videos") != null) {
             
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
                video.registrarVideo(idVideo, request.getParameter("titulo"), request.getParameter("autor"), request.getParameter("fecha"), request.getParameter("duracion"), request.getParameter("descripcion"), request.getParameter("formato"), request.getParameter("url"), idUsuario);
            
                try (PrintWriter out = response.getWriter()) {
                    /* TODO output your page here. You may use following sample code. */
                    out.println("<!DOCTYPE html>");
                    out.println("<html>");
                    out.println("<head>");
                    out.println("<title>ServletRegistroVid</title>");            
                    out.println("</head>");
                    out.println("<body>");
                    out.println("<h1>El video se ha guardado</h1>");
                    out.println("</body>");
                    out.println("</html>");
                }
                
            } catch (SQLException ex) {
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
