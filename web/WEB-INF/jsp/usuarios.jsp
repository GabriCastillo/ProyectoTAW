<%-- 
    Document   : customers
    Created on : 14 mar. 2022, 12:01:31
    Author     : guzman
--%>

<%@page import="TAWapp.dto.UsuarioDTO"%>
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
        <jsp:include page="/WEB-INF/jsp/cabecera.jsp" />        

        <h1>Listado de usuarios</h1>
        <form method="post" action="UsuarioServlet">
            Nombre: <input type="text" name="filtroNombre" value="" />
            <input type="submit" value="Filtrar" />
        </form>
        
        <%
            List<UsuarioDTO> usuarios = (List)request.getAttribute("usuarios");
            if (usuarios == null || usuarios.isEmpty()) {
        %>

         <h2>No hay usuarios</h2>
        
        <%                
            } else {
        %>  
        
        <table border="1">
            <tr>
                <th>Nombre</th>
                <th>Apellido</th>                
                <th>Domicilio</th>                                
                <th>Ciudad Residencia</th>     
                <th>Edad</th>                     
                <th>Sexo</th>       
                <th>Rol</th> 
                <th></th>                                                     
                <th></th>                                                                     
            </tr>
            <%
                for (UsuarioDTO usuario : usuarios) {
            %>    
            <tr>
                <td><%= usuario.getNombre()%></td>
                <td><%= usuario.getApellido()%></td>            
                <td><%= usuario.getDomicilio()%></td>                     
                <td><%= usuario.getCiudadResidencia()%></td>                                 
                <td><%= usuario.getEdad()%></td>                      
                <td><%= usuario.getSexo()%></td>             
                <td><%= usuario.getRolIdrol().getNombre()%></td>  
                <td><a href="UsuarioBorrarServlet?id=<%= usuario.getIdusuario()%>">Borrar</a></td> 
                <td><a href="UsuarioNuevoEditarServlet?id=<%= usuario.getIdusuario()%>">Editar</a></td>            
            </tr>

            <%
                }
            %>
        </table>
        <%
            }
        %>
        <a href="UsuarioNuevoEditarServlet">Crear nuevo usuario ... </a>

    </body>
</html>
