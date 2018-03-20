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
          <link href="css/logincss.css" rel="stylesheet" />
        <title>Login</title>
    </head>
    <body background="css/resources/fondo.jpg">
        <form action="servletUser" class="login-form" method="post">
           	 <div class="divLog">
		 <table>
		 
		<tr>
			<td class ="labelTitle">  Identificador:</td>
			<td><input class ="textbox" type="text" placeholder="Usuario" name="id" /></td>
		</tr>    
		<tr>
			<td class ="labelTitle">Password:</td>
			<td><input class ="textbox" type="password" placeholder ="Password" name="passwd" /></td>
		</tr>
		<tr>
			<td><input type="button" value="Aceptar" /> </td>
	  
		</tr>
		<tr>
			<td class="warningTitle" colspan="3">         Si no tiene una cuenta, registrese  <a href="registroUsuario.jsp">aquí</a></td>
		</tr>
    </table>
    </div>
    
        </form>
     
    </body>
</html>
