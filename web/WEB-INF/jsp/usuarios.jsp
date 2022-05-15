<%-- 
    Document   : usuarios
    Author     : Javier
    Done       : 100%
--%>

<%@page import="TAWapp.dto.CategoriaDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="TAWapp.dto.ListaDTO"%>
<%@page import="TAWapp.dto.UsuarioDTO"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listas de clientes</title>
    </head>        
    <body>
        <jsp:include page="/WEB-INF/jsp/cabecera.jsp" />
        
        <h1>Listas creadas</h1>
        <form method="post" action="UsuarioServlet">
            Nombre: <input type="text" name="filtroListaAll" value="" />
            <input type="submit" value="Filtrar" />
        </form>
        
        <%
            List<ListaDTO> listas = (List)request.getAttribute("nombresListas");
            if (listas == null || listas.isEmpty() ) {
        %>    
        <h2>No hay listas</h2>
        <%
            } else { 
        %>    
        <table border="1">
            <tr>
                <th>NOMBRE</th>
                <th></th>
                <th></th>
            </tr>
        <%    
                List<String> nombresComunes = new ArrayList();
                List<ListaDTO> listaUnificada = new ArrayList();
                for (ListaDTO lista : listas) {
                    if (!nombresComunes.contains(lista.getNombre())) {
                        nombresComunes.add(lista.getNombre());
                        listaUnificada.add(lista);
                    }
                }
                
                for (ListaDTO lista : listaUnificada) {
        %>    
            <tr>
                <td><%= lista.getNombre() %></td>
                <td><a href="BorrarListaServlet?nombreListaBorrar=<%= lista.getNombre() %>">BORRAR</a></td> 
                <td><a href="ListaEditarServlet?nombreListaEditar=<%= lista.getNombre() %>">EDITAR</a></td>   
            </tr>
        
        <%
                }
        %>
        </table>
        <%
            }
        %>     
        <form method="post" action="CrearListaServlet">
            <input type="text" size="12" name="nombreLista" value="" />
            <input type="submit" value="Crear lista" />
        </form>
        
        <h1>Todos los clientes compradores</h1>
        <form method="post" action="UsuarioServlet">
            Nombre: <input type="text" name="filtroCompradorAll" value="" />
            <input type="submit" value="Filtrar" />
        </form>
        
        <%
            List<UsuarioDTO> usuarios = (List)request.getAttribute("usuarios");
            if (usuarios == null || usuarios.isEmpty() ) {
        %>    
        <h2>No hay clientes compradores</h2>
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
                for (UsuarioDTO usuario : usuarios) {
        %>    
            <tr>
                <td><%= usuario.getNombre() %></td>        
                <td><%= usuario.getApellido() %></td>
                <td><%= usuario.getEdad() %></td>
                <td><%= usuario.getSexo() %></td>
                <td><%= usuario.getDomicilio() %></td>
                <td><%= usuario.getCiudadResidencia() %></td>
                <td><%= ultimasCategorias.get(usuarios.indexOf(usuario)).getTipo() %></td>
                <td><a href="CorreoServlet?idUsuarioCORREO=<%= usuario.getIdusuario() %>&nombreUsuarioCORREO=<%= usuario.getNombre() + " " + usuario.getApellido() %>">CORREO</a></td> 
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
