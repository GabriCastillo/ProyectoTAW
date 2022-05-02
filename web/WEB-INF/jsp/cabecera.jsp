<%-- 
    Document   : cabecera
    Created on : 30 mar. 2022, 11:56:49
    Author     : guzman
--%>

<%@page import="TAWapp.dto.UsuarioDTO"%>
<%@page import="TAWapp.entity.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    UsuarioDTO admin = (UsuarioDTO)session.getAttribute("usuario");
    if (admin == null) {
        response.sendRedirect(request.getContextPath());
    }
%>

<table width="80%">
    <tr width="80%">
        <td>Bienvenido, <%= admin.getNombre() %></td>
        <td>Session ID: <%= session.getId() %></td>
        <td><a href="UsuarioServlet">Listado de usuarios</a></td>
        <td><a href="ProductoServlet">Listado de productos</a></td>
        <td><a href="LogoutServlet">Salir</a></td>        
    </tr>
</table>