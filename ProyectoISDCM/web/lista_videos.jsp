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
           <!--<form action="servletListavideo" class="login-form" method="post">
               <td><input type="submit" name="listavideo" value="Aceptar" /> </td>
           </form>
           -->
           <div>
               <c:choose>
                    <c:when test="${listadoVideos.isEmpty()}">
                       <div>
                           <h2>Actualmente no tienes ningún video</h2>
                       </div>
                    </c:when>
               
                   <c:otherwise>
                       <div id ="divlistavideo"> 
                        <table id ="videos">
                            <tr>
                                <th>Titulo</th>
                                <th>Fecha</th>
                                <th>Duracion</th>
                                <th>Numero reproducciones</th>
                                <th>Formato</th>
                                <th>Url</th>
                            </tr>
                        <c:forEach items="${listadoVideos}" var="video">
                            
                            <tr>
                            <td>${video.titulo}</td>
                            <td>${video.fecha}</td>
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
                   </c:otherwise>

               </c:choose>
           </div>
           
    </body>
</html>
