<%-- 
    Document   : cabecera
    Author     : Javier
    Done       : 100%
--%>

<%@page import="TAWapp.dto.UsuarioDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    UsuarioDTO usuario = (UsuarioDTO)session.getAttribute("apellido");
    if (usuario == null) {
        response.sendRedirect(request.getContextPath());
    }
%>

<table width="80%">
    <tr width="80%">
        <td>Bienvenido, <%= usuario.getApellido() %></td>
        <td>Session ID: <%= session.getId() %></td>
        <td><a href="UsuarioServlet">Listado de clientes</a></td>        
        <td><a href="LogoutServlet">Salir</a></td>        
    </tr>
</table>