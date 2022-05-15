<%-- 
    Document   : correos
    Author     : Javier
    Done       : 100%
--%>

<%@page import="TAWapp.dto.ProductoDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="TAWapp.dto.CorreoDTO"%>
<%@page import="TAWapp.dto.UsuarioDTO"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Correo del cliente</title>
    </head>        
    <body>
        <jsp:include page="/WEB-INF/jsp/cabecera.jsp" />
            
        <h1>Correo de <%= request.getAttribute("nombreUsuario") %></h1>
        
        <%
            List<CorreoDTO> correos = (List)request.getAttribute("correosUsuario");
            if (correos == null || correos.isEmpty() ) {
        %>    
        <h2>Este usuario no ha recibido nada todavía.</h2>
        <%
            } else { 
        %>    
        <table border="1">
        <%    
                for (CorreoDTO correo : correos) {
        %>    
            <tr>
                <td>PROMOCION <%= correo.getIdpromo() %></td>
        <%    
                    if(correo.getIdProducto() == null) {
        %>   
                <td><%= correo.getMensaje() %></td> 
        <%    
                    } else {
        %>
                <td><%= "Recomendación del producto " + correo.getIdProducto().getIdproducto() + ": "+ correo.getIdProducto().getTitulo() %> <br/> <%= correo.getMensaje() %></td> 
        <%    
                    }
        %>
                <td><a href="BorrarCorreoServlet?CorreoBORRAR=<%= correo.getIdpromo() %>&nombreUsuario=<%= request.getAttribute("nombreUsuario") %>&idUsuarioPASS=<%= request.getAttribute("idUsuario") %>">BORRAR</a></td>   
            </tr>
        <%
                }
        %>
        </table>
        <%
            }
        %>     
        <form id="promocionForm" method="post" action="AnadirCorreoServlet">
            <input type="hidden" name="idUsuario" value="<%= request.getAttribute("idUsuario") %>" />
            <input type="hidden" name="nombreUsuario" value="<%= request.getAttribute("nombreUsuario") %>" />
            <textarea required name="mensajePromo" rows="4" cols="50" form="promocionForm"></textarea><br/>
            <select name="productoSeleccionado">
                <option selected value="0">Incluir un producto...</option>
        <%    
                List<ProductoDTO> productosLista = (List)request.getAttribute("productosLista");
                if(!productosLista.isEmpty()) {
                    for (ProductoDTO producto : productosLista) {
        %>    
                <option value="<%= producto.getIdproducto() %>"><%= producto.getTitulo() %></option>
        <%
                    }
                }
        %>
            </select>
            <input type="submit" value="Enviar promoción" />
        </form>
    </body>
</html>
