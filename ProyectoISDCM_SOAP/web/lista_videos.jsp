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
                       <div id ="divlistavideo"> 
                        <table id ="videos">
                            <tr>
                                <th>Autor <input type="text" name="autor" value="" /></th>
                                <th>Titulo <input type="text" name="titulo" value="" /></th>
                                <th>Fecha desde <input type="text" name="apubliDesde" value="" /></th>
                                <th>Fecha hasta <input type="text" name="apubliHasta" value="" /></th>
                                <th><input type="submit" name="filtrar" value="Filtrar" /></th>
                            </tr>
 
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
