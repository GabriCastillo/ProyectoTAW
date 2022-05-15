<%-- 
    Document   : Analisis
    Created on : 13-may-2022, 0:53:08
    Author     : pepe_
--%>

<%@page import="TAWapp.dto.EstadisticaDTO"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <%--
        List<CategoriaDTO> listaCategorias = (List) request.getAttribute("categorias");
        List<UsuarioDTO> listaUsuarios = (List) request.getAttribute("usuarios");--%> 
    <%    EstadisticaDTO estadistica = (EstadisticaDTO) request.getAttribute("estadistica");
    %>
    


    <body>
        <jsp:include page="/WEB-INF/jsp/cabecera.jsp" />     
        <section id="formulario2">        

            <h1 id="titulo">Datos del Analisis</h1>
            <form method="POST" action="EstadisticaGuardarServlet">
                <div style="display:flex">
                    <div class="izqBox" style="width: 50%;margin-bottom: 15px">
                        <input type="hidden" name="id" value="<%= estadistica == null ? "" : estadistica.getIdestadistica()%>" />

                        <div class="input-container ic1">
                            <input id="titulo" class="input" type="text" name="titulo" placeholder=" " value="<%= estadistica == null ? "" : estadistica.getNombre()%>" />
                            <div class="cut"></div>
                            <label for="titulo" class="placeholder">Nombre:</label>
                        </div>         

                        <div class="input-container ic2" >
                            <textarea  id="descripcion"  name="descripcion" class="input2" type="text" style="width:70%; height:130px;" placeholder=" " >
<%= estadistica == null ? "" : estadistica.getDescripcion()%>
                            </textarea>                            

                            <input id="descripcion" class="input2" type="text" name="descripcion" placeholder=" " value="<%= estadistica == null ? "" : estadistica.getDescripcion()%>" />
                            <div class="cut2"></div>
                            <label for="descripcion" class="placeholder">Descripcion</label>
                        </div>
                    </div>
                    <div class="dBox">
                        <%--<div class="input-container ic2">
                            <select id="idUsuario" class="input" name="idUsuario" placeholder=" ">
                                <%
                                    for (UsuarioDTO u : listaUsuarios) {
                                        String selected = "";
                                        if (producto != null && producto.getUsuarioVendedor().equals(u)) {
                                            selected = "selected";
                                        }
                                %>
                                <option <%= selected%> value="<%= String.valueOf(u.getIdusuario())%>"><%= u.getNombre()%></option>    
                                <%
                                    }
                                %> 

                            </select>
                            <div class="cut2"></div> --%>
                            <label for="usuarioAnalista" class="placeholder">Analista</label>
                        </div>
                    </div>
                </div>
                </br>
                <div style="text-align:center"><input id="btn" type="submit" value="Añadir Producto" /></div>
            </form>
    </body>
</html>


