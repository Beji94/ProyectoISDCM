<%-- 
    Document   : login
    Created on : 17-mar-2018, 19:26:39
    Author     : Beñat
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body>
        <form action="servletUser" method="post">
            Identificador: <input type="text" name="id" />
            Contraseña: <input type="password" name="passwd" />
            <input type="submit" value="Aceptar">
        </form>
        Si no tiene una cuenta, pinche <a href="registroUsuario.jsp">aquí</a>
    </body>
</html>
