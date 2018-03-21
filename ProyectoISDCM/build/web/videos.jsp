<%-- 
    Document   : videos
    Created on : 20/03/2018, 05:23:35 PM
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/logincss.css" rel="stylesheet" />
        <title>JSP Page</title>
        <div> 
          <h1> REGISTRO DE VIDEOS</>
          </div>
          
    </head>
      <body background="css/resources/fondo.jpg">
          <form action="servletRegistroVid" method="post">
              <div class="divRegistrousuario">
		 <table>
                
                 <tr>
                    <td  class ="labelTitle">  Titulo                 </td>
                    <td>  <input type="text" class ="textbox" name="titulo" /></td>
                </tr>
                
                
                <tr>
                    <td  class ="labelTitle">      autor                     </td>
                    <td><input type="text" class ="textbox"name="autor" /></td>
                </tr>
                
                 <tr>
                    <td  class ="labelTitle">      duracion                     </td>
                    <td><input type="text" class ="textbox"name="duracion" /></td>
                </tr>
                <tr>
                    <td  class ="labelTitle">      descripcion                     </td>
                    <td><input type="text" class ="textbox"name="descripcion" /></td>
                </tr>
                 
                
                <tr>
                    <td  class ="labelTitle">      URL                     </td>
                    <td><input type="text" class ="textbox"name="url" /></td>
                </tr>
                
                 <tr>
                    <td  class ="labelTitle">      formato                     </td>
                    <td><input type="text" class ="textbox"name="formato" /></td>
                </tr>
                 <tr>
                     
                    <td> 
                        <input type="submit" name="videos" value="Grabar" />
                    </td>
                    
                </tr>
                <tr>
                    <td colspan="3" class ="warningTitleuser"> Ver lista de videos <a href="lista_videos.jsp">aquí</a>  </td>
                </tr>
                 </table>
                
                </div>
          </form>
    </body>
</html>
