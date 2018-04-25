/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;


import java.io.IOException;
import java.io.PrintWriter;

import java.util.ArrayList;
import java.util.Vector;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.ws.WebServiceRef;
import org.me.busqueda.BusquedaWS_Service;
import org.me.busqueda.Date;
import org.me.busqueda.Video;

/**
 *
 * @author Beñat
 */
public class servletBusqueda extends HttpServlet {

    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/localhost_8080/BusquedaWS/BusquedaWS.wsdl")
    private BusquedaWS_Service service;

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
        //response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet servletBusqueda</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet servletBusqueda at " + request.getContextPath() + "</h1>");
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
        //processRequest(request, response);
        
        response.setContentType("text/html;charset=UTF-8");

        ArrayList<Video> listaVideos = new ArrayList<Video>();
        
        if (request.getParameter("filtrar") != null) {
            HttpSession sesion = (HttpSession) request.getSession();
            String idUsuario = (String) sesion.getAttribute("identificador");
            String autor = request.getParameter("autor");
            String titulo = request.getParameter("titulo");
            String apubliDesde = request.getParameter("apubliDesde");
            String apubliHasta = request.getParameter("apubliHasta");
            
            //System.out.println(autor + " " + titulo+" " + apubliDesde+ " " + apubliHasta + " "+ idUsuario);
            
            try {
                listaVideos = (ArrayList<Video>) busqueda(autor, titulo, apubliDesde, apubliHasta, idUsuario);
            }
            catch (Exception e) {
                System.out.println(e);
            }
            
            
            //System.out.println(listaVideos.get(0).getAutor() + " " + listaVideos.get(0).getTitulo() +" "+listaVideos.get(0).getAPubli());
            //System.out.println(listaVideos.get(0).getFechaXML());
            /*Vector<Video> vecVideos = new Vector<Video>();
            Video v = new Video();
            Date date;
            for(int i=0; i<listaVideos.size();i++) {
                v.setTitulo(listaVideos.get(i).getTitulo());
                v.setAutor(listaVideos.get(i).getAutor());
                v.setDuracion(listaVideos.get(i).getDuracion());
                v.setReproduccion(listaVideos.get(i).getReproduccion());
                v.setDescripcion(listaVideos.get(i).getDescripcion());
                v.setFormato(listaVideos.get(i).getFormato());
                v.setUrl(listaVideos.get(i).getUrl());
                v.setIdUsuario(listaVideos.get(i).getIdUsuario());
                v.setApubli(listaVideos.get(i).getApubli());
                date = (listaVideos.get(i).getFechaXML().replace("/", "-"));
                v.setFecha(date);
            }*/
            
            //request.getSession().setAttribute("listadoVideos", listaVideos);
            request.getSession().setAttribute("listadoVideos", listaVideos);
            request.getRequestDispatcher("lista_videos.jsp").forward(request, response);
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

    private java.util.List<org.me.busqueda.Video> busqueda(java.lang.String autor, java.lang.String titulo, java.lang.String apubliDesde, java.lang.String apubliHasta, java.lang.String usuario) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        org.me.busqueda.BusquedaWS port = service.getBusquedaWSPort();
        return port.busqueda(autor, titulo, apubliDesde, apubliHasta, usuario);
    }

}
