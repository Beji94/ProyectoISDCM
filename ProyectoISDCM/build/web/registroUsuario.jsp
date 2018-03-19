<%-- 
    Document   : registroUsuario
    Created on : 28-feb-2018, 17:53:23
    Author     : benat.jimenez
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registro de usuario</title>
    </head>
    <body>
        <form action="servletUser" method="post">
        Nombre: <input type="text" name="nombre" /><br />
        Apellidos: <input type="text" name="apellidos" /><br />
        Correo: <input type="text" name="email" /><br />
        Identificador: <input type="text" name="id" /><br />
        Contraseña: <input type="passwd" name="passwd" /><br />
        Repetir contraseña: <input type="passwd" name="passwd2" /><br />
        Dirección <input type="text" name="direccion" /><br />
        Teléfono <input type="text" name="telefono" /><br />					
        <input type="submit" value="Registrase" />
        </form>
        Si ya tiene una cuenta, pinche <a href="login.jsp">aquí</a>
    </body>
</html>
