<%-- 
    Document   : busqueda
    Created on : 25-abr-2018, 11:49:30
    Author     : Beñat
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
               <c:choose>
                    <c:when test="${listadoVideos.isEmpty()}">
                       <div id="divlistavideo">
                           <h2>Actualmente no tienes ningún video</h2>
                           <table id ="videos">
                               <tr>
                                <th>Titulo</th>
                                <th>Fecha</th>
                                <th>Duracion</th>
                                <th>Numero reproducciones</th>
                                <th>Formato</th>
                                <th>Url</th>
                                </tr>
                               <tr>
                                    <td colspan="6" > agregar nuevo video <a href="videos.jsp">aquí</a>  </td>
                                </tr>
                            </table>
                       
                       </div>
                    </c:when>
               
                   <c:otherwise>
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
                            <td>${video.fechaXML}</td>
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
                   </c:otherwise>

               </c:choose>
           </div>
           
    </body>
</html>

