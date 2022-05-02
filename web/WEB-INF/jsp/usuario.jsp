<%-- 
    Document   : customer
    Created on : 16 mar. 2022, 11:44:12
    Author     : guzman
--%>

<%@page import="TAWapp.dto.UsuarioDTO"%>
<%@page import="TAWapp.dto.RolDTO"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <%
        List<RolDTO> listaRoles = (List)request.getAttribute("roles");
        UsuarioDTO usuario = (UsuarioDTO)request.getAttribute("usuario");
    %>    
    <body>
        <jsp:include page="/WEB-INF/jsp/cabecera.jsp" />           
        <h1>Datos del usuario</h1>
        <form method="POST" action="UsuarioGuardarServlet">
            <input type="hidden" name="id" value="<%= usuario==null? "": usuario.getIdusuario() %>" />
            Nombre: <input type="text" size="45" name="nombre" value="<%= usuario==null? "": usuario.getNombre() %>" /> <br/>
            Apellido: <input type="text" size="45" name="apellido" value="<%= usuario==null? "": usuario.getApellido() %>" /> <br/>
            Domicilio:<input type="text" size="45" name="domicilio" value="<%= usuario==null? "": usuario.getDomicilio() %>" /> 
            Ciudad: <input type="text" size="45" name="ciudad" value="<%= usuario==null? "": usuario.getCiudadResidencia() %>" /> <br/>
            Edad: <input type="text" size="45" name="edad" value="<%= usuario==null? "": usuario.getEdad() %>" /> <br/>
            Sexo: <input type="text" size="45" name="sexo" value="<%= usuario==null? "": usuario.getSexo() %>" /> <br/> 
            Contraseña: <input type="text" size="45" name="password" value="<%= usuario==null? "": usuario.getPassword() %>" /> <br/> 
            
            Rol: 
            <select name="rol">
            <% 
                for (RolDTO r: listaRoles) {
                    String selected = "";
                    if (usuario != null && usuario.getRolIdrol().equals(r)) {
                        selected = "selected";
                    }
            %>
            <option <%= selected %> value="<%= String.valueOf(r.getIdRol()) %>"><%= r.getNombre() %></option>    
            <% 
                }
            %> 
            
            </select>
         
         <br/>
            <input type="submit" value="Enviar" />
        </form>
    </body>
</html>
