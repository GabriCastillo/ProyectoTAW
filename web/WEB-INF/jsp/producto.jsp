<%-- 
    Document   : producto
    Created on : 29-abr-2022, 17:07:06
    Author     : casti
--%>

<%@page import="TAWapp.dto.ProductoDTO"%>
<%@page import="TAWapp.dto.CategoriaDTO"%>
<%@page import="TAWapp.dto.UsuarioDTO"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
     <%
        List<CategoriaDTO> listaCategorias = (List)request.getAttribute("categorias");
        List<UsuarioDTO> listaUsuarios = (List)request.getAttribute("usuarios");
        ProductoDTO producto = (ProductoDTO)request.getAttribute("producto");
    %> 
    
    
    <body>
         <jsp:include page="/WEB-INF/jsp/cabecera.jsp" />           
        <h1>Datos del producto</h1>
        <form method="POST" action="ProductoGuardarServlet">
            <input type="hidden" name="id" value="<%= producto==null? "": producto.getIdproducto()%>" />
            Titulo: <input type="text" size="45" name="titulo" value="<%= producto==null? "": producto.getTitulo()%>" /> <br/>
            Descripcion: <input type="text" size="45" name="descripcion" value="<%= producto==null? "": producto.getDescripcion() %>" /> <br/>
            URL Imagen:<input type="text" size="45" name="url" value="<%= producto==null? "": producto.getImagen() %>" /> 
            
            Categoria: 
            <select name="categoria">
            <% 
                for (CategoriaDTO c: listaCategorias) {
                    String selected = "";
                    if (producto != null && producto.getCategoriaIdcategoria().equals(c)) {
                        selected = "selected";
                    }
            %>
            <option <%= selected %> value="<%= String.valueOf(c.getIdCategoria()) %>"><%= c.getTipo() %></option>    
            <% 
                }
            %> 
            
            </select>
            
            Dueño: 
            <select name="idUsuario">
            <% 
                for (UsuarioDTO u: listaUsuarios) {
                    String selected = "";
                    if (producto != null && producto.getUsuarioVendedor().equals(u)) {
                        selected = "selected";
                    }
            %>
            <option <%= selected %> value="<%= String.valueOf(u.getIdusuario()) %>"><%= u.getNombre() %></option>    
            <% 
                }
            %> 
            
            </select>
            
            <br/>
            <input type="submit" value="Enviar" />
        </form>
    </body>
</html>
