<%-- 
    Author     : casti
    Done:      : 100%
--%>

<%@page import="TAWapp.dto.RolDTO"%>
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
    <%
        List<RolDTO> listaRoles = (List) request.getAttribute("roles");
    %>  
    <body>
        <jsp:include page="/WEB-INF/jsp/cabecera.jsp" />        

        <h1>Listado de usuarios</h1>
        <form method="post" action="UsuarioServlet">
            Nombre: <input type="text" name="filtroNombre" value="" />
            Apellido: <input type="text" name="filtroApellido" value="" />
            <select  name="filtroRol">
                <option  value=""> N/A </option>
                <%
                    for (RolDTO r : listaRoles) {
                     
                %>
                <option  value="<%= String.valueOf(r.getIdRol())%>"><%= r.getNombre()%></option>    

                <%
                    }
                %> 
            </select>
            <input type="submit" value="Filtrar" />
        </form>


        </br>

        <%
            List<UsuarioDTO> usuarios = (List) request.getAttribute("usuarios");
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
                <td><a href="UsuarioBorrarServlet?id=<%= usuario.getIdusuario()%>" style="color: #04AA6D;">Borrar</a></td> 
                <td><a href="UsuarioNuevoEditarServlet?id=<%= usuario.getIdusuario()%>" style="color: #04AA6D;">Editar</a></td>            
            </tr>

            <%
                }
            %>
        </table>
        <%
            }
        %>
        </br>

        <a href="UsuarioNuevoEditarServlet" style="color: #04AA6D;">Crear nuevo usuario ... </a>

    </body>
</html>

