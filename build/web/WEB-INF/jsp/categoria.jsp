<%-- 
    Document   : categoria
    Created on : 05-may-2022, 16:05:33
    Author     : casti
--%>

<%@page import="TAWapp.dto.CategoriaDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Producto</title>
    </head>
    <%
        CategoriaDTO categoria = (CategoriaDTO) request.getAttribute("categoria");
    %> 


    <body>
        <jsp:include page="/WEB-INF/jsp/cabecera.jsp" />     
        <section id="formulario2">        

            <h1 id="titulo">Datos de la Categoria</h1>
            <form method="POST" action="CategoriaGuardarServlet">
                <div style="display:flex">
                    <div class="izqBox" style="width: 50%;margin-bottom: 15px">
                        <input type="hidden" name="id" value="<%= categoria == null ? "" : categoria.getIdCategoria()%>" />

                        <div class="input-container ic1">
                            <input id="tipo" class="input" type="text" name="tipo" placeholder=" " value="<%= categoria == null ? "" : categoria.getTipo()%>" />
                            <div class="cut"></div>
                            <label for="tipo" class="placeholder">Tipo</label>
                        </div>         

                    </div>

                </div>
                </br>
                <div style="text-align:center"><input id="btn" type="submit" value="Subir" /></div>
            </form>
            </br>
            <div style="text-align:center"><a href="CategoriaServlet" style="color: #04AA6D;">Cancelar</a></div>

    </body>
</html>
