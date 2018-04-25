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

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.User;
import clases.Usuario;
import clases.Video;
import java.util.Vector;
import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;
import modelo.VideoDAO;

/**
 *
 * @author Beñat
 */
public class servletUser extends HttpServlet {

    int verificarLogin(String identificador, String passwd) throws SQLException {
        int ok = 0;       
        User u = new User();
        
        ok = u.login(identificador, passwd);
        
        return ok;
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
                //El usuario se ha logeado correctamente, crear una nueva sesión.
                request.getSession().setAttribute("identificador", request.getParameter("id"));
                
                VideoDAO videoDAO = new VideoDAO();
                Vector<Video> listaVideos = new Vector<Video>();
                try {
                    listaVideos = videoDAO.listaVideos((String) request.getSession().getAttribute("identificador"));
                } catch (SQLException ex) {
                    Logger.getLogger(servletUser.class.getName()).log(Level.SEVERE, null, ex);
                }
                request.getSession().setAttribute("listadoVideos", listaVideos);
                
                request.getRequestDispatcher("lista_videos.jsp").forward(request, response);
               
            }
            else if (log==0){
                request.setAttribute("valorLogin", "error");
                request.setAttribute("mensaje", "Usuario o contraseña erroneo");
                request.getRequestDispatcher("login.jsp").forward(request, response);
            }
        }
             
        else if (request.getParameter("registro") != null) {
            User user = new User();
            exist = user.userExist(request.getParameter("email"), request.getParameter("id"));
            String pass1 = request.getParameter("passwd");
            String pass2 = request.getParameter("passwd2");
            
            if (!pass1.equals(pass2)) {
                request.setAttribute("valorPass", "error");
                request.setAttribute("mensaje", "Las contraseñas que ha introducido no coinciden");
                request.getRequestDispatcher("registroUsuario.jsp").forward(request, response);
            }
            
            else if(exist==1) { //email
                request.setAttribute("valorMail", "error");
                request.setAttribute("mensaje", "El email que ha introducido ya está en uso");
                request.getRequestDispatcher("registroUsuario.jsp").forward(request, response);
            }
            else if (exist==2){ //identificador
                request.setAttribute("valorID", "error");
                request.setAttribute("mensaje", "El identificador que ha introducido ya está en uso");
                request.getRequestDispatcher("registroUsuario.jsp").forward(request, response);
            }
            else if (exist==0) {
                user.crearUsuario(request.getParameter("nombre"), request.getParameter("apellidos"), 
                        request.getParameter("email"), request.getParameter("id"), request.getParameter("passwd"));
                
                request.setAttribute("registro", "true");
                request.setAttribute("mensaje", "Se ha registrado satisfactoriamente, ahora debe logearse para entrar en la página");
                request.getRequestDispatcher("login.jsp").forward(request, response);
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
