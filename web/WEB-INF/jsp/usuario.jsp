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
        List<RolDTO> listaRoles = (List) request.getAttribute("roles");
        UsuarioDTO usuario = (UsuarioDTO) request.getAttribute("usuario");
    %>    
    <body>

        <jsp:include page="/WEB-INF/jsp/cabecera.jsp" />   
        <section id="formulario2">        
            <h1 id="titulo">Datos del Usuario</h1>
            <form method="POST" action="UsuarioGuardarServlet">
                <div style="display:flex">
                    <div class="izqBox" style="width: 50%;margin-bottom: 15px">
                        <input type="hidden" name="id" value="<%= usuario == null ? "" : usuario.getIdusuario()%>" />

                        <div class="input-container ic1">
                            <input id="nombre" class="input" type="text" name="nombre" placeholder=" " value="<%= usuario == null ? "" : usuario.getNombre()%>" />
                            <div class="cut"></div>
                            <label for="nombre" class="placeholder">Nombre</label>
                        </div>                   
                        <div class="input-container ic2" >
                            <input id="apellido" class="input" type="text" name="apellido" placeholder=" " value="<%= usuario == null ? "" : usuario.getApellido()%>" />
                            <div class="cut2"></div>
                            <label for="apellido" class="placeholder">Apellido</label>
                        </div>
                        <div class="input-container ic2">
                            <input id="domicilio" class="input" type="text" name="domicilio" placeholder=" " value="<%= usuario == null ? "" : usuario.getDomicilio()%>" /> 
                            <div class="cut2"></div>
                            <label for="domicilio" class="placeholder">Domicilio</label>
                        </div>

                        <div class="input-container ic2" >
                            <input id="ciudad" class="input" type="text" name="ciudad" placeholder=" " value="<%= usuario == null ? "" : usuario.getCiudadResidencia()%>" />
                            <div class="cut2"></div>
                            <label for="ciudad" class="placeholder">Ciudad</label>
                        </div>


                    </div>

                    <div class="dBox">
                        <div class="input-container ic1" >
                            <input id="edad" class="input" type="text" name="edad" placeholder=" " value="<%= usuario == null ? "" : usuario.getEdad()%>" /> 
                            <div class="cut2"></div>
                            <label for="edad" class="placeholder">Edad</label>
                        </div>
                        <div class="input-container ic2" >
                            <input id="sexo" class="input"  type="text" name="sexo" placeholder=" " value="<%= usuario == null ? "" : usuario.getSexo()%>" />
                            <div class="cut3"></div>
                            <label for="sexo" class="placeholder">Sexo</label>
                        </div>
                        <div class="input-container ic2" >
                            <input id="password" class="input" type="text" name="password" placeholder=" " value="<%= usuario == null ? "" : usuario.getPassword()%>" />
                            <div class="cut2"></div>
                            <label for="password" class="placeholder">Contraseña</label>
                        </div>

                        <div class="input-container ic2">

                            <select id="rol" class="input" name="rol" placeholder=" ">
                                <%
                                    for (RolDTO r : listaRoles) {
                                        String selected = "";
                                        if (usuario != null && usuario.getRolIdrol().equals(r)) {
                                            selected = "selected";
                                        }
                                %>
                                <option <%= selected%> value="<%= String.valueOf(r.getIdRol())%>"><%= r.getNombre()%></option>    
                                <%
                                    }
                                %> 
                            </select>
                            <div class="cut2"></div>
                            <label for="rol" class="placeholder">Rol</label>

                        </div>

                    </div>


                </div>
                <div style="text-align:center"><input id="btn" type="submit" value="Añadir Usuario" /></div>

            </form>
        </section>
    </body>
</html>