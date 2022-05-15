<%-- 
    Author     : RaulDF
    Done       : 100%
--%>


<%@page import="TAWapp.dto.UsuarioDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Bienvenido</title>
    </head>
    <%
        UsuarioDTO user = (UsuarioDTO)request.getAttribute("usuario");
    %> 
    <body>
        <ul>
  <li><a class="active" href="UsuarioServlet">Home</a></li>
  <li><a href="VenderServlet">Mis Subastas</a></li>
  <li style="float:right"><a href="LogoutServlet">Cerrar Sesion</a></li>
  <li style="float:right"><a href="PerfilServlet"><%= user.getNombre() %></a></li>
</ul>
    </body>
    
</html>
<style>
ul {
  list-style-type: none;
  margin: 0;
  padding: 0;
  overflow: hidden;
  background-color: #333;
}

li {
  float: left;
  border-right:1px solid #bbb;
}

li:last-child {
  border-right: none;
}

li a {
  display: block;
  color: white;
  text-align: center;
  padding: 14px 16px;
  text-decoration: none;
}

li a:hover:not(.active) {
  background-color: #111;
}

.active {
  background-color: #04AA6D;
}
</style>