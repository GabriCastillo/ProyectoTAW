<%-- 
    Document   : Subastas
    Created on : 29-abr-2022, 22:10:20
    Author     : RaulDF
--%>

<%@page import="TAWapp.dto.CompradorProductoDTO"%>
<%@page import="TAWapp.dto.UsuarioDTO"%>
<%@page import="TAWapp.dto.CategoriaDTO"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Mis subastas</title>
    </head>
    <%
        UsuarioDTO user = (UsuarioDTO) request.getAttribute("usuario");
        List<CategoriaDTO> listaCategorias = (List) request.getAttribute("categorias");
        List<CompradorProductoDTO> listaSubastas = (List) request.getAttribute("subastas");
       
    %> 

    <body>
        <header>       <ul>
                <li><a class="active" href="UsuarioServlet">Home</a></li>
                <li><a href="VenderServlet">Mis Subastas</a></li>
                <li style="float:right"><a href="LogoutServlet">Cerrar Sesion</a></li>
                <li style="float:right"><a><%= user.getNombre()%></a></li>
        </header>
        <section>
            <section id="subastas" style="box-sizing:content-box">
                <h1 id="titulo">Tus subastas</h1>
                <%
                    if (listaSubastas != null) {
                        for (CompradorProductoDTO subasta : listaSubastas) {
                %>

                <div style="display:flex;margin-top: 20px;margin-bottom: 20px">
                    <div style="width:40%;text-align: center">
                        <img src="<%= subasta.getProducto().getImagen()%>" 
                             style="border-radius:15px;border: 5px solid #04AA6D " 
                             alt="Foto del producto" width="200" height="200"> 
                    </div>
                    <div style="width:30%">
                        <h3><%=subasta.getProducto().getTitulo()%></h3><br/>
                        <a style="color:white">Descripcion:<%= subasta.getProducto().getDescripcion()%></a><br/>

                        <%
                            if (subasta.getPrecio_Compra() == 0) {
                        %>
                        <a style="color:white">Precio vendido: <%= subasta.getPrecio_salida()%></a>
                        <%
                        } else {
                        %>
                        <a style="color:white">Precio actual: <%= subasta.getPrecio_salida()%></a><br/>
                        <a style="color:white">Precio limite: <%= subasta.getPrecio_Compra()%></a><br/>
                        <%
                            }
                        %>
                    </div>
                    <div style="text-align: center;width:20%;margin-top: 50px">
                        <%
                            if (subasta.getPrecio_Compra() == 0) {
                        %>
                        <a id="btnCancel" >Cerrada</a>
                        <%
                        } else {
                        %>
                        <a href="CerrarPujaServlet?id=<%= subasta.getIdCompradorProductoDTO()%>" id="btn" type="button" value="Cerrar Puja" >Cerrar Puja</a>
                        <%
                            }
                        %>

                    </div>
                </div>
                <%
                        }
                    }
                %>



            </section>
            <section id="formulario">
                <h1 id="titulo">Añade un producto</h1>
                <form method="POST" action="SubirProductoServlet">
                    <div style="display:flex">
                        <div class="izqBox" style="width: 50%;margin-bottom: 15px">
                            <div class="input-container ic1">
                                <input id="titulo" class="input" type="text" name="titulo" placeholder=" " required oninvalid="this.setCustomValidity('Pon el titulo')"
                                       oninput="this.setCustomValidity('')"/>
                                <div class="cut"></div>
                                <label for="titulo" class="placeholder">Titulo</label>
                            </div>                   
                            <div class="input-container ic2" >
                                <input id="titulo" class="input" type="number" name="precioInicial" placeholder=" " required oninvalid="this.setCustomValidity('Pon un precio')"
                                       oninput="this.setCustomValidity('')"/>
                                <div class="cut2"></div>
                                <label for="precioInicial" class="placeholder">Precio Inicial</label>
                            </div>
                            <div class="input-container ic2">
                                <input id="precioLimite" class="input" type="number" name="precioLimite" placeholder=" " required oninvalid="this.setCustomValidity('Pon un precio')"
                                       oninput="this.setCustomValidity('')"/>
                                <div class="cut2"></div>
                                <label for="precioInicial" class="placeholder">Precio limite</label>
                            </div>
                            <div class="input-container ic2">
                                <select id="categoria" class="input" name="categoria" placeholder=" ">
                                    <%
                                        for (CategoriaDTO c : listaCategorias) {
                                            String selected = "";

                                    %>
                                    <option <%= selected%> value="<%= String.valueOf(c.getIdCategoria())%>"><%= c.getTipo()%></option>    
                                    <%
                                        }
                                    %> 

                                </select>
                                <div class="cut2"></div>
                                <label for="categoria" class="placeholder">Categoria</label>
                            </div>

                        </div>
                        <div class="dBox">
                            <div class="input-container ic1" >
                                <input id="descripcion" class="input2" type="text" name="descripcion" placeholder=" " required oninvalid="this.setCustomValidity('Pon una descripcion')"
                                       oninput="this.setCustomValidity('')"/>
                                <div class="cut2"></div>
                                <label for="descripcion" class="placeholder">Descripcion</label>
                            </div>
                            <div class="input-container ic3" >
                                <input id="imagen" class="input" type="text" name="imagen" required oninvalid="this.setCustomValidity('Pega la url de la imagen')"
                                       oninput="this.setCustomValidity('')"/>
                                <div class="cut3"></div>
                                <label for="imagen" class="placeholder">Url imagen:</label>
                            </div>

                        </div>
                        <input type="hidden" name="id" id="id" value="<%= user.getIdusuario()%>" />

                    </div>
                    <div style="text-align:center"><input id="btn" type="submit" value="Subir Producto" /></div>
                </form>
            </section>
        </section>
      
    </body>
</html>
<style>
    *{
        box-sizing: border-box;
    }
    .input-container {
        height: 50px;
        position:relative ;
        width: 100%;
    }

    .ic1 {
        margin-top: 40px;
    }
    .input {
        background-color: #828282;
        border-radius: 12px;
        border: 0;
        box-sizing: border-box;
        color: #eee;
        font-size: 15px;
        height: 100%;
        outline: 0;
        padding: 4px 20px 0 ;
        margin-left: 20px;
        width: 70%;
    }
    .input2 {
        background-color: #828282;
        border-radius: 12px;
        border: 0;
        box-sizing: border-box;
        color: #eee;
        font-size: 15px;
        height: 130px;
        outline: 0;
        padding: 4px 20px 0 ;
        margin-left: 20px;
        width: 70%;
    }


    .cut {
        background-color: #404040;
        border-radius: 10px;
        height: 20px;
        left: 20px;
        position: absolute;
        top: -20px;
        transform: translateY(0);
        transition: transform 200ms;
        width: 76px;

    }

    .cut2 {
        background-color: #404040;
        border-radius: 10px;
        height: 20px;
        left: 20px;
        position: absolute;
        top: -20px;
        transform: translateY(0);
        transition: transform 200ms;
        width: 96px;

    }
    .cut3 {
        background-color: #404040;
        border-radius: 10px;
        height: 20px;
        left: 20px;
        position: absolute;
        top: -20px;
        transform: translateY(0);
        transition: transform 200ms;
        width: 96px;

    }
    .cut2-short {
        width: 50px;
    }
    .cut-short {
        width: 50px;
    }
    .cut3-short {
        width: 50px;
    }

    .input:focus ~ .cut,
    .input:not(:placeholder-shown) ~ .cut,
    .input:focus ~ .cut2,
    .input:not(:placeholder-shown) ~ .cut2,
    .input2:focus ~ .cut2,
    .input2:not(:placeholder-shown) ~ .cut2
    {
        transform: translateY(8px);
    }

    .placeholder {
        color: white;
        font-family: sans-serif;
        left: 20px;
        line-height: 14px;
        pointer-events: none;
        position: absolute;
        transform-origin: 0 50%;
        transition: transform 200ms, color 200ms;
        top: 20px;
        margin-left: 10px;
    }

    .input:focus ~ .placeholder,
    .input:not(:placeholder-shown) ~ .placeholder,
    .input2:focus ~ .placeholder,
    .input2:not(:placeholder-shown) ~ .placeholder{
        transform: translateY(-30px) translateX(10px) scale(0.75);
    }

    .input:not(:placeholder-shown) ~ .placeholder,
    .input2:not(:placeholder-shown) ~ .placeholder{
        color: #828282;
    }

    .input:focus ~ .placeholder,
    .input2:focus ~ .placeholder{
        color: #04AA6D;
    }
    .ic2 {
        margin-top: 30px;
    }
    .ic3 {
        margin-top: 108px;
    }
    #btn{
        background-color:#04AA6D;
        border: none;
        color: white;
        padding: 15px 32px;
        text-align: center;
        text-decoration: none;
        display: inline-block;
        font-size: 16px;
    }
    #btnCancel{
        background-color:#828282;
        border: none;
        color: white;
        padding: 15px 32px;
        text-align: center;
        text-decoration: none;
        display: inline-block;
        font-size: 16px;
    }
    #formText{
        position: relative;
    }
    #relleno{
        background-color: #DBCFBB;
        border-radius: 25px;
        margin-left: 25px;
        height: auto;
        text-align: center;
        width: 200px;
    }
    body{
        background-color:  #DBCFBB;
    }
    #titulo{

        display: block;
        text-align: center;
        font-size:26px;
        color: white;
    }
    #subastas{

        border-radius: 25px;
        margin-top: 10px;
        background-color:#404040 ;
        width: 60%;
        float: left;
    }
    #formulario{
        position:fixed;
        border-radius: 25px;
        margin-left: 62%;
        margin-top: 10px;
        background-color:#404040 ;
        width: 37%;
        height: 600px;
        float:right;
    }
    ul {
        list-style-type: none;
        margin: 0;
        padding: 0;
        overflow: hidden;
        background-color: #333;
    }

    li {
        float: left;
        border-right:1px solid #bbb;
    }

    li:last-child {
        border-right: none;
    }

    li a {
        display: block;
        color: white;
        text-align: center;
        padding: 14px 16px;
        text-decoration: none;
    }

    li a:hover:not(.active) {
        background-color: #111;
    }

    .active {
        background-color: #04AA6D;
    }
</style>