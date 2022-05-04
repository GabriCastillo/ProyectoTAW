<%-- 
    Document   : productos
    Created on : 29-abr-2022, 17:07:16
    Author     : casti
--%>

<%@page import="TAWapp.dto.ProductoDTO"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listado de productos</title>
    </head>
    <jsp:include page="/WEB-INF/jsp/cabecera.jsp" />        

    <h1>Listado de productos</h1>

    <form method="post" action="ProductoServlet">
        Titulo: <input type="text" name="filtroTitulo" value="" />
        <input type="submit" value="Filtrar" />
    </form>
    </br>


    <%
        List<ProductoDTO> productos = (List) request.getAttribute("productos");
        if (productos == null || productos.isEmpty()) {
    %>

    <h2>No hay productos</h2>

    <%
    } else {
    %>  

    <table border="1">
        <tr>
            <th>Titulo</th>
            <th>Descripcion</th>                
            <th>Imagen</th>                                
            <th>Categoria</th>    
            <th>Propietario</th>
            <th></th>                                                     
            <th></th>                                                                     
        </tr>
        <%
            for (ProductoDTO producto : productos) {

        %>    
        <tr>
            <td><%= producto.getTitulo()%></td>
            <td><%= producto.getDescripcion()%></td>            
            <td><%= producto.getImagen()%></td>                                 
            <td><%= producto.getCategoriaIdcategoria().getTipo()%></td>
            <td><%= producto.getUsuarioVendedor().getNombre()%></td>  
            <td><a href="ProductoBorrarServlet?id=<%= producto.getIdproducto()%>">Borrar</a></td> 
            <td><a href="ProductoNuevoEditarServlet?id=<%= producto.getIdproducto()%>">Editar</a></td>            
        </tr>

        <%
            }
        %>
    </table>
    <%
        }
    %>
    </br>

    <a href="ProductoNuevoEditarServlet">Crear nuevo producto ... </a>

</body>
</html>
