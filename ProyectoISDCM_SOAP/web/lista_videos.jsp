<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%-- 
    Document   : lista_videos
    Created on : 20/03/2018, 05:38:46 PM
    Author     : User
--%>


<%--        Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/dbISDCM", "root", "root");
    --%>    
  
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/logincss.css" rel="stylesheet" />
        <title>Lista de Videos</title>
    </head>
     <body background="css/resources/fondo.jpg">
           <div>   
               <form id="listaVideo" action="servletBusqueda" method="post">
                    <div id ="divbusqueda"    >
                               <td> <input type="text" placeholder="Autor" name="autor" value="" /></td>
                                <td> <input type="text" placeholder ="Titulo" name="titulo" value="" /></td>
                                <td> <input type="text" placeholder="publicacion desde" name="apubliDesde" value="" /></td>
                                <td> <input type="text" placeholder ="publicacion hasta" name="apubliHasta" value="" /></td>
                                <td style="align-items: center"><input  type="submit" name="filtrar" value="Filtrar" /></td>
                            </div>
                       <div id ="divlistaVideo"> 
                           
                        <table id ="videos">
                           
                           
 
                            <tr>
                                <th>Autor</th>
                                <th>Titulo</th>
                                <th>Año de Publicación</th>
                                <th>Duracion</th>
                                <th>Numero reproducciones</th>
                                <th>Formato</th>
                                <th>Url</th>
                            </tr>
                        <c:forEach items="${listadoVideos}" var="video">
                            
                            <tr>
                            <td>${video.autor}</td>
                            <td>${video.titulo}</td>
                            <td>${video.aPubli}</td>
                            <td>${video.duracion} </td>
                            <td>${video.reproduccion} </td>
                            <td>${video.formato} </td>
                            <td><a href=${video.url}>${video.url}</a></td>
                            </tr>


                         </c:forEach>
                             <tr>
                                <td colspan="6" > agregar nuevo video <a href="videos.jsp">aquí</a>  </td>
                            </tr>
                       </table>
                       </div>
                       </form>   
           </div>
           
    </body>
</html>
