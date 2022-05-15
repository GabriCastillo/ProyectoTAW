<%-- 
    Document   : MainPage
    Created on : 27-abr-2022, 17:57:47
    Author     : RaulDF
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Bienvenidos a TAW</title>
    </head>
    <%
        String strError = (String)request.getAttribute("error");
        if (strError == null) strError = "";
    %>    
    <body>
        <%= strError %>
        <header>
            <a href="login">Iniciar sesión</a>
            <a href="/WEB-INF/jsp/SignIn.jsp">Registrarse</a>
            <a href="www.google.com">Registrarse</a>
        </header>
    </body>
</html>

</head>