<%-- 
    Document   : encriptacion
    Created on : 22-may-2018, 17:31:56
    Author     : Beñat
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Encriptar XML</title>
    </head>
    <body>
        <h3>Encriptar XML</h3>
        Select a file to upload: <br />
            <form action="UploadServlet" method="post"
                enctype="multipart/form-data">
                <input type="file" name="file" size="50" />
            <br />
                <input type="submit" value="Upload File" />
            </form>
    </body>
</html>
