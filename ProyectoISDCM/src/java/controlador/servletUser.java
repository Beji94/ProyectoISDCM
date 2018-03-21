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
import modelo.User;
import clases.Usuario;
import clases.Video;
import java.util.Vector;
import javax.servlet.http.HttpSession;
import modelo.VideoDAO;

/**
 *
 * @author Beñat
 */
public class servletUser extends HttpServlet {

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
            out.println("<title>Servlet servletUser</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet servletUser at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    int verificarLogin(String identificador, String passwd) throws SQLException {
        int ok = 0;       
        User u = new User();
        
        ok = u.login(identificador, passwd);
        
        return ok;
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
        //processRequest(request, response);
        response.setContentType("text/html;charset=UTF-8");

        int log = 0;
        int exist = 0;
        
        if (request.getParameter("login") != null) {
            try {
                log = verificarLogin(request.getParameter("id"), request.getParameter("passwd"));
            } catch (SQLException ex) {
                Logger.getLogger(servletUser.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (log==1) {
                //Crear sesion
                //HttpSession sesion= request.getSession(true);
                //sesion.setAttribute("identificador",request.getParameter("id"));
                request.getSession().setAttribute("identificador", request.getParameter("id"));
                
                VideoDAO videoDAO = new VideoDAO();
                Vector<Video> listaVideos = new Vector<Video>();
                try {
                    listaVideos = videoDAO.listaVideos(request.getParameter("identificador"));
                } catch (SQLException ex) {
                    Logger.getLogger(servletUser.class.getName()).log(Level.SEVERE, null, ex);
                }
                request.setAttribute("listadoVideos", listaVideos);
                //response.sendRedirect("lista_videos");
                request.getRequestDispatcher("/servletListavideo").forward(request, response);
               
            }
            else {
                try (PrintWriter out = response.getWriter()) {
                    /* TODO output your page here. You may use following sample code. */
                    out.println("<!DOCTYPE html>");
                    out.println("<html>");
                    out.println("<head>");
                    out.println("<title>ServletUser</title>");            
                    out.println("</head>");
                    out.println("<body>");
                    out.println("<h1>Login incorrecto</h1>");
                    out.println("</body>");
                    out.println("</html>");
                }
            }
        }
             
        else if (request.getParameter("registro") != null) {
            User user = new User();
            exist = user.userExist(request.getParameter("email"), request.getParameter("id"));
            if(exist==1) {
                try (PrintWriter out = response.getWriter()) {
                    /* TODO output your page here. You may use following sample code. */
                    out.println("<!DOCTYPE html>");
                    out.println("<html>");
                    out.println("<head>");
                    out.println("<title>ServletUser</title>");            
                    out.println("</head>");
                    out.println("<body>");
                    out.println("<h1>El email ya está en uso</h1>");
                    out.println("</body>");
                    out.println("</html>");
                }
            }
            else if (exist==2){
                try (PrintWriter out = response.getWriter()) {
                    /* TODO output your page here. You may use following sample code. */
                    out.println("<!DOCTYPE html>");
                    out.println("<html>");
                    out.println("<head>");
                    out.println("<title>ServletUser</title>");            
                    out.println("</head>");
                    out.println("<body>");
                    out.println("<h1>El identificador ya está en uso</h1>");
                    out.println("</body>");
                    out.println("</html>");
                }
            }
            else if (exist==0) {
                user.crearUsuario(request.getParameter("nombre"), request.getParameter("apellidos"), 
                        request.getParameter("email"), request.getParameter("id"), request.getParameter("passwd"));
                
                try (PrintWriter out = response.getWriter()) {
                    /* TODO output your page here. You may use following sample code. */
                    out.println("<!DOCTYPE html>");
                    out.println("<html>");
                    out.println("<head>");
                    out.println("<title>ServletUser</title>");            
                    out.println("</head>");
                    out.println("<body>");
                    out.println("<h1>El usuario se ha creado exitosamente</h1>");
                    out.println("</body>");
                    out.println("</html>");
                }
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
