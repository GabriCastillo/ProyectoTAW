<%-- 
    Document   : login
    Author     : Javier
    Done       : 100%
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Bienvenidos al sistema</title>
    </head>
    <%
        String strError = (String)request.getAttribute("error");
        if (strError == null) strError = "";
    %>    
    <body>
        <h1>Login</h1>
        <%= strError %>
        <form method="POST" action="LoginServlet">
            Apellido: <input type="text" name="apellido" value="" /><br/><br/>
            <input type="submit" value="Enviar" />
        </form>
    </body>
</html>
