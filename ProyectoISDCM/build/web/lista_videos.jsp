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
        <title>Lista de Videos</title>
    </head>
    <body>
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
                        <table>
                            <tr>
                                <th>titulo</th>
                                <th>fecha</th>
                                <th>duracion</th>
                                <th>Num reproducciones</th>
                                <th>formato</th>
                                <th>url</th>
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
                       </table>
                   </c:otherwise>

               </c:choose>
           </div>
    </body>
</html>
