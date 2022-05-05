<%-- 
    Document   : usuarioNuevo
    Created on : 04-may-2022, 17:01:07
    Author     : casti
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

    %>    
    <body>

        
        <section id="formulario2">        
            <h1 id="titulo">Datos del Usuario</h1>
            <form method="POST" action="UsuarioGuardarNuevoServlet">
                <div style="display:flex">
                    <div class="izqBox" style="width: 50%;margin-bottom: 15px">
                        <input type="hidden" name="id"  />

                        <div class="input-container ic1">
                            <input id="nombre" class="input" type="text" name="nombre" placeholder=" " />
                            <div class="cut"></div>
                            <label for="nombre" class="placeholder">Nombre</label>
                        </div>                   
                        <div class="input-container ic2" >
                            <input id="apellido" class="input" type="text" name="apellido" placeholder=" " />
                            <div class="cut2"></div>
                            <label for="apellido" class="placeholder">Apellido</label>
                        </div>
                        <div class="input-container ic2">
                            <input id="domicilio" class="input" type="text" name="domicilio" placeholder=" "  /> 
                            <div class="cut2"></div>
                            <label for="domicilio" class="placeholder">Domicilio</label>
                        </div>

                        <div class="input-container ic2" >
                            <input id="ciudad" class="input" type="text" name="ciudad" placeholder=" "  />
                            <div class="cut2"></div>
                            <label for="ciudad" class="placeholder">Ciudad</label>
                        </div>


                    </div>

                    <div class="dBox">
                        <div class="input-container ic1" >
                            <input id="edad" class="input" type="text" name="edad" placeholder=" "  /> 
                            <div class="cut2"></div>
                            <label for="edad" class="placeholder">Edad</label>
                        </div>
                        <div class="input-container ic2" >
                            <input id="sexo" class="input"  type="text" name="sexo" placeholder=" "  />
                            <div class="cut3"></div>
                            <label for="sexo" class="placeholder">Sexo</label>
                        </div>
                        <div class="input-container ic2" >
                            <input id="password" class="input" type="text" name="password" placeholder=" "  />
                            <div class="cut2"></div>
                            <label for="password" class="placeholder">Contraseña</label>
                        </div>
                        
                         <div class="input-container ic2" >
                            <input id="password2" class="input" type="text" name="password2" placeholder=" "  />
                            <div class="cut2"></div>
                            <label for="password2" class="placeholder">Repetir Contraseña</label>
                        </div>

                        <div class="input-container ic2">

                            <select id="rol" class="input" name="rol" placeholder=" ">
                                <%
                                    for (RolDTO r : listaRoles) {
                                        String selected = "";
                                       
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
    
    .select {
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
        height: 600px;
        float: left;
    }
    
    #formulario2{
        border-radius: 25px;
        margin-top: 10px;
        background-color:#404040 ;
        height: 600px;
        float:center;
    }
    
    #usuarios{

        border-radius: 25px;
        margin-top: 10px;
        background-color:#404040 ;
        width: 60%;
        height: 600px;
        float: left;
    }
    #formulario{
        border-radius: 25px;
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
    
    
    table{border-collapse:collapse;}
th,tr,td{
	border:1px solid #000;
	width:150px;
	height:45px;
	vertical-align:middle;
	text-align:center;
}
th{
	color:#fff;
	background-color: #252525;
}

tr:nth-child(odd) td{
	background-color:#eee;
}
</style>
