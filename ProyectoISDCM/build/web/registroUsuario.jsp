<%-- 
    Document   : registroUsuario
    Created on : 28-feb-2018, 17:53:23
    Author     : benat.jimenez
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <script LANGUAGE="JavaScript">
            function validar_clave() 
            {
var caract_invalido = " ";
var caract_longitud = 6;
var cla1 = document.registrouser.passwd.value;
var cla2 = document.registrouser.passwd2.value;
if (cla1 = '' || cla2 ='') {
alert('Debes introducir tu clave en los dos campos.');
return false;
}
if ( document.registrouser.passwd.value.length < caract_longitud) {
alert('Tu clave debe constar de ' + caract_longitud + ' caracteres.');
return false;
}
if (document.registrouser.passwd.value.indexOf(caract_invalido) > -1) {
alert("Las claves no pueden contener espacios");
return false;
}
else {
if (cla1 <> cla2) {
alert ("Las claves introducidas no son iguales");
return false;
}
else {
return true;
      }
   }
}
            
        </script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
          <link href="css/logincss.css" rel="stylesheet" />
        <title>Registro de usuario</title>
           <h1> REGISTRO DE USUARIOS  </h1>
    </head>
    <body  background="css/resources/fondo.jpg" >
        <form id="registrouser" action="servletUser" method="post">
             <div class="divRegistrousuario">
		 <table>
		
                <tr>
                    <td  class ="labelTitle">      Nombre                     </td>
                    <td> <input type="text" class ="textbox" name="nombre" /> </td>
                </tr>
                
                 <tr>
                    <td  class ="labelTitle">       Apellidos                     </td>
                    <td>  <input type="text" class ="textbox" name="apellidos" /></td>
                </tr>
                
                
                <tr>
                    <td  class ="labelTitle">      Correo:                     </td>
                    <td><input type="text" class ="textbox"name="email" /></td>
                </tr>
                
                 <tr>
                    <td  class ="labelTitle">      Identificador                     </td>
                    <td><input type="text" class ="textbox"name="id" /></td>
                </tr>
                
                 <tr>
                    <td  class ="labelTitle">      Pasword                     </td>
                    <td><input type="passwd" class ="textbox"name="passwd" /></td>
                </tr>
                
                 <tr>
                    <td  class ="labelTitle">      Confirmar Pasword                     </td>
                    <td><input type="passwd" class ="textbox"name="passwd2" /></td>
                </tr>
                
                <tr>
                    <td  class ="labelTitle">      Dirección                     </td>
                    <td><input type="passwd" class ="textbox"name="direccion" /></td>
                </tr>
                
                 <tr>
                    <td  class ="labelTitle">      Teléfono                     </td>
                    <td><input type="passwd" class ="textbox"name="telefono" /></td>
                </tr>
                 <tr>
                     
                    <td> 
                        <input type="submit"  name="registro" value="Registrase" />
                    </td>
                    
                </tr>
                <tr>
                    <td colspan="3" class ="warningTitleuser"> Si ya tiene una cuenta, presione <a href="login.jsp">aquí</a>  </td>
                </tr>
                 </table>
                
                </div>
       
            					
       
        </form>
        
    </body>
</html>
