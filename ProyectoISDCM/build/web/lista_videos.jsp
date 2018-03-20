<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%-- 
    Document   : lista_videos
    Created on : 20/03/2018, 05:38:46 PM
    Author     : User
--%>


<%--        Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/dbISDCM", "root", "root");
    --%>    

<sql:query var="Lista_video" dataSource="jdbc/dbISDCM">
    SELECT identificador,titulo,autor,fecha,duracion,descripcion,formato,url FROM ROOT.VIDEOS 
</sql:query>
    
<table border="1">
    <!-- column headers -->
    <tr>
    <c:forEach var="columnName" items="${Lista_video.columnNames}">
        <th><c:out value="${columnName}"/></th>
    </c:forEach>
</tr>
<!-- column data -->
<c:forEach var="row" items="${Lista_video.rowsByIndex}">
    <tr>
    <c:forEach var="column" items="${row}">
        <td><c:out value="${column}"/></td>
    </c:forEach>
    </tr>
</c:forEach>
</table>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
    </body>
</html>
