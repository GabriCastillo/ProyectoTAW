<%-- 
    Document   : customers
    Created on : 14 mar. 2022, 12:01:31
    Author     : guzman
--%>

<%@page import="TAWapp.entity.Usuario"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listado de usuarios</title>
    </head>
    <body>
        <h1>Listado de usuarios</h1>
        <table border="1">
            <tr>
                <th>NOMBRE</th>
                <th>APELLIDO</th>                
                <th>DOMICILIO</th>                                
                <th>CIUDAD_RESIDENCIA</th>     
                <th>EDAD</th>                     
                <th>SEXO</th>                                     
                <th></th>                                                     
                <th></th>                                                                     
            </tr>
        <%
            List<Usuario> usuarios = (List)request.getAttribute("usuarios");
            for (Usuario usuario: usuarios) {
        %>    
        <tr>
            <td><%= usuario.getNombre() %></td>
            <td><%= usuario.getApellido() %></td>            
            <td><%= usuario.getDomicilio() %></td>                     
            <td><%= usuario.getCiudadResidencia() %></td>                                 
           <td><%= usuario.getEdad()%></td>                      
           <td><%= usuario.getSexo() %></td>                  
           <td><a href="UsuarioBorrarServlet?id=<%= usuario.getIdusuario() %>">Borrar</a></td> 
           <td><a href="UsuarioNuevoEditarServlet?id=<%= usuario.getIdusuario() %>">Editar</a></td>            
        </tr>
        
        <%
            }
        %>
        </table>
        <a href="UsuarioNuevoEditarServlet">Crear nuevo usuario ... </a>
        
    </body>
</html>
