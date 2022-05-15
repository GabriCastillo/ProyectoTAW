<%-- 
    Document   : lista
    Author     : Javier
    Done       : 100%
--%>

<%@page import="TAWapp.dto.CategoriaDTO"%>
<%@page import="TAWapp.dto.ProductoDTO"%>
<%@page import="TAWapp.dto.ListaDTO"%>
<%@page import="TAWapp.dto.UsuarioDTO"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista seleccionada</title>
    </head>
    <body>
        <jsp:include page="/WEB-INF/jsp/cabecera.jsp" />
        
        <%
            List<ListaDTO> compradoresLista = (List)request.getAttribute("compradoresLista");
        %>   
            <h1><%= compradoresLista.get(0).getNombre() %></h1>
        <%
            
            if (compradoresLista == null || compradoresLista.isEmpty() ) {
        %>    
        <h2>No hay listas</h2>
        <%
            } else { 
        %>    
        <table border="1">
            <tr>
                <th>NOMBRE</th>
                <th>APELLIDOS</th>
                <th>EDAD</th>
                <th>SEXO</th>
                <th>DOMICILIO</th>
                <th>CIUDAD DE RESIDENCIA</th>
                <th>ULTIMA CATEGORIA COMPRADA</th>
                <th></th>
            </tr>
        <%    
                List<CategoriaDTO> ultimasCategoriasLista = (List)request.getAttribute("ultimasCategoriasLista");
                for (ListaDTO compradorLista : compradoresLista) {
        %>    
            <tr> 
        <%
                    if(compradorLista.getUsuarioLista() != null) {
        %>
                <td><%= compradorLista.getUsuarioLista().getNombre() %></td>
                <td><%= compradorLista.getUsuarioLista().getApellido() %></td>
                <td><%= compradorLista.getUsuarioLista().getEdad() %></td>
                <td><%= compradorLista.getUsuarioLista().getSexo() %></td>
                <td><%= compradorLista.getUsuarioLista().getDomicilio() %></td>
                <td><%= compradorLista.getUsuarioLista().getCiudadResidencia() %></td>
                <td><%= ultimasCategoriasLista.get(compradoresLista.indexOf(compradorLista)).getTipo() %></td>
                <td><a href="BorrarCompradorListaServlet?nombreListaEditar=<%= compradoresLista.get(0).getNombre() %>&idCompradorBorrarLista=<%= compradorLista.getUsuarioLista().getIdusuario() %>">BORRAR</a></td>   
        <%
                    } else {
        %>
                <td>-</td>
                <td>-</td>
                <td>-</td>
                <td>-</td>
                <td>-</td>
                <td>-</td>
                <td>-</td>
                <td><a href="ListaEditarServlet?nombreListaEditar=<%= compradoresLista.get(0).getNombre() %>">BORRAR</a></td>   
        <%
                    }
        %> 
                
                
            </tr>
        
        <%
                }
        %>
        </table>
        <%
            }
        %>     

        <form id="promocionForm" method="post" action="AnadirCorreoListaServlet">
            <input type="hidden" name="nombreListaPromo" value="<%= compradoresLista.get(0).getNombre() %>" />
            <textarea required name="mensajePromo" rows="4" cols="50" form="promocionForm" value=""></textarea><br/>
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
        
        <h1>Listado de compradores</h1>
        <form method="post" action="ListaEditarServlet">
            <input type="hidden" name="nombreListaEditar" value="<%= compradoresLista.get(0).getNombre() %>" />
            Nombre: <input type="text" name="filtroCompradorAll" value="" />
            <input type="submit" value="Filtrar" />
        </form>
        
        <%
            List<UsuarioDTO> compradores = (List)request.getAttribute("compradores");
            if (compradores == null || compradores.isEmpty() ) {
        %>    
        <h2>No hay clientes</h2>
        <%
            } else { 
        %>    
        <table border="1">
            <tr>
                <th>NOMBRE</th>
                <th>APELLIDOS</th>
                <th>EDAD</th>
                <th>SEXO</th>
                <th>DOMICILIO</th>
                <th>CIUDAD DE RESIDENCIA</th>
                <th>ULTIMA CATEGORIA COMPRADA</th>
                <th></th>
            </tr>
        <%    
                List<CategoriaDTO> ultimasCategorias = (List)request.getAttribute("ultimasCategorias");
                for (UsuarioDTO comprador : compradores) {
        %>    
            <tr>
                <td><%= comprador.getNombre() %></td>        
                <td><%= comprador.getApellido() %></td>
                <td><%= comprador.getEdad() %></td>
                <td><%= comprador.getSexo() %></td>
                <td><%= comprador.getDomicilio() %></td>
                <td><%= comprador.getCiudadResidencia() %></td>
                <td><%= ultimasCategorias.get(compradores.indexOf(comprador)).getTipo() %></td>
                <td><a href="AnadirCompradorListaServlet?nombreListaEditar=<%= compradoresLista.get(0).getNombre() %>&idListaAnadirComprador=<%= compradoresLista.get(0).getIdLista() %>&idCompradorAnadirLista=<%= comprador.getIdusuario() %>">AÑADIR</a></td> 
            </tr>
        
        <%
                }
        %>
        </table>
        <%
            }
        %>        
        
        
        
    </body>
</html>
