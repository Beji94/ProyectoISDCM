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
import java.util.Vector;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.logging.Level;
import java.util.logging.Logger;
   
import javax.servlet.http.HttpSession;
import modelo.VideoDAO;


/**
 *
 * @author User
 */
@WebServlet(name = "servletListavideo", urlPatterns = {"/servletListavideo"})
public class servletListavideo extends HttpServlet {

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
            out.println("<title>Servlet servletListavideo</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet servletListavideo at " + request.getContextPath() + "</h1>");
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
         
        
            //Obtener el identificador del usuario mediante la sesion
            HttpSession sesion = (HttpSession) request.getSession();
            String idUsuario = (String) sesion.getAttribute("identificador");

            VideoDAO video = new VideoDAO();
            Vector<Video> listado_videos = new Vector<Video>();

            try {
                idUsuario="john.ballestas";
                listado_videos = video.listaVideos(idUsuario);
                try (PrintWriter out = response.getWriter()) {
                    /* TODO output your page here. You may use following sample code. */
                    out.println("<!DOCTYPE html>");
                    out.println("<html>");
                    out.println("<head>");
                    out.println("<title>ServletRegistroVid</title>");
                    out.println("</head>");
                    out.println("<body>");

                    out.println("<table>");

                    out.println("<tr>");
                    out.println("<th>titulo</th>");
                    out.println("<th>fecha</th>");
                    out.println("<th>duracion</th>");
                    out.println("<th>No reproducciones</th>");
                    out.println("<th>formato</th>");
                    out.println("<th>url</th>");

                    for (Video videonode : listado_videos) {
                        out.println(" </tr>");
                        out.println("<tr>");
                        out.println("<td>"+videonode.getTitulo() +"</td>");
                        out.println("<td>"+videonode.getFecha()+"</td>");
                        out.println("<td>"+videonode.getDuracion() +"</td>");
                        out.println("<td>"+videonode.getReproduccion() +"</td>");
                        out.println("<td>"+videonode.getFormato() +"</td>");
                        out.println("<td>"+videonode.getUrl() +"</td>");
                        out.println(" </tr>");

                    }
                    out.println("</table>");

                    out.println("</body>");
                    out.println("</html>");
                }

            } catch (SQLException ex) {
                Logger.getLogger(servletRegistroVid.class.getName()).log(Level.SEVERE, null, ex);
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
