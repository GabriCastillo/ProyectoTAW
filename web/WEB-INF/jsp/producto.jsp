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
        List<CategoriaDTO> listaCategorias = (List) request.getAttribute("categorias");
        List<UsuarioDTO> listaUsuarios = (List) request.getAttribute("usuarios");
        ProductoDTO producto = (ProductoDTO) request.getAttribute("producto");
    %> 


    <body>
        <jsp:include page="/WEB-INF/jsp/cabecera.jsp" />     
        <section id="formulario2">        

            <h1 id="titulo">Datos del Producto</h1>
            <form method="POST" action="ProductoGuardarServlet">
                <div style="display:flex">
                    <div class="izqBox" style="width: 50%;margin-bottom: 15px">
                        <input type="hidden" name="id" value="<%= producto == null ? "" : producto.getIdproducto()%>" />

                        <div class="input-container ic1">
                            <input id="titulo" class="input" type="text" name="titulo" placeholder=" " value="<%= producto == null ? "" : producto.getTitulo()%>" />
                            <div class="cut"></div>
                            <label for="titulo" class="placeholder">Titulo:</label>
                        </div>         

                        <div class="input-container ic2" >
                            <textarea  id="descripcion"  name="descripcion" class="input2" type="text" style="width:70%; height:130px;" placeholder=" " >
<%= producto == null ? "" : producto.getDescripcion()%>
                            </textarea>                            

                            <input id="descripcion" class="input2" type="text" name="descripcion" placeholder=" " value="<%= producto == null ? "" : producto.getDescripcion()%>" />
                            <div class="cut2"></div>
                            <label for="descripcion" class="placeholder">Descripcion</label>
                        </div>
                    </div>
                    <div class="dBox">
                        <div class="input-container ic3" >
                            <input id="url" class="input" type="file" accept="image/*" name="url" value="<%= producto == null ? "" : producto.getImagen()%>" /> 
                            <div class="cut3"></div>
                            <label for="url" class="placeholder">Selecciona la imagen:</label>
                        </div>


                        <div class="input-container ic2">
                            <select id="categoria" class="input" name="categoria" placeholder=" ">
                                <%
                                    for (CategoriaDTO c : listaCategorias) {
                                        String selected = "";
                                        if (producto != null && producto.getCategoriaIdcategoria().equals(c)) {
                                            selected = "selected";
                                        }
                                %>
                                <option <%= selected%> value="<%= String.valueOf(c.getIdCategoria())%>"><%= c.getTipo()%></option>    
                                <%
                                    }
                                %> 

                            </select>
                            <div class="cut2"></div>
                            <label for="categoria" class="placeholder">Categoria</label>
                        </div>

                        <div class="input-container ic2">
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
                            <div class="cut2"></div>
                            <label for="idUsuario" class="placeholder">Dueño</label>
                        </div>
                    </div>
                </div>
                </br>
                <div style="text-align:center"><input id="btn" type="submit" value="Añadir Producto" /></div>
            </form>
    </body>
</html>


