<%-- 
    Document   : SignIn
    Created on : 27-abr-2022, 17:59:08
    Author     : RaulDF
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registro</title>
    </head>
    <%
        String strError = (String)request.getAttribute("error");
        if (strError == null) strError = "";
    %>  
    <body>
        <h1>Registro</h1>
        <%= strError %>
        <form method="POST" action="RegistroUsuarioServlet">
            Usuario: <input type="text" name="usuario" value="" /><br/>
            Clave: <input type="password" name="clave" value="" /><br/>
            Repite clave:<input type="password" name="claveRepetida" value=""/><br/><br/>
            <input type="submit" value="Enviar" />
        </form>
    </body>
</html>
