<%-- 
    Document   : customer
    Created on : 16 mar. 2022, 11:44:12
    Author     : guzman
--%>

<%@page import="TAWapp.entity.Usuario"%>
<%@page import="TAWapp.entity.Producto"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <%
        List<Producto> productos = (List)request.getAttribute("productos");
      //  List<DiscountCode> listaDescuentos = (List)request.getAttribute("descuentos");

        Usuario usuario = (Usuario)request.getAttribute("usuario");
    %>    
    <body>
        <jsp:include page="/WEB-INF/jsp/cabecera.jsp" />           
        <h1>Datos del usuario</h1>
        <form method="POST" action="UsuarioGuardarServlet">
            <input type="hidden" name="id" value="<%= usuario==null? "": usuario.getIdusuario() %>" />
            Nombre: <input type="text" size="30" name="nombre" value="<%= usuario==null? "": usuario.getNombre() %>" /> <br/>
            Apellido: <input type="text" size="30" name="domicilio1" value="<%= usuario==null? "": usuario.getApellido() %>" /> 
            Domicilio:<input type="text" size="40" name="email" value="<%= usuario==null? "": usuario.getDomicilio() %>" /> <br/>
            Ciudad: <input type="text" size="25" name="ciudad" value="<%= usuario==null? "": usuario.getCiudadResidencia() %>" /> <br/>
            Edad: <input type="text" size="2" name="estado" value="<%= usuario==null? "": usuario.getEdad() %>" /> <br/>
            Sexo: <input type="text" size="12" name="telefono" value="<%= usuario==null? "": usuario.getSexo() %>" /> <br/>            
   <%--        
            Supermercado: 
            <select name="supermercado">
            <% 
                for (MicroMarket mm:listaSuper) {
                    String selected = "";
                    if (usuario != null && usuario.getZip().getZipCode().equals(mm.getZipCode())) {
                        selected = "selected";
                    }
            %>
            <option <%= selected %> value="<%= mm.getZipCode() %>"><%= mm.getZipCode() %></option>
                
            <% 
                }
            %>                
            </select><br/>
            Codigo de descuento: 
            <select name="descuento">
            <% 
                for (DiscountCode dc: listaDescuentos) {
                    String selected = "";
                    if (usuario != null && 
                         usuario.getDiscountCode().getDiscountCode().equals(dc.getDiscountCode())) {
                         selected = "selected";
                    }
            %>
            <option <%= selected %> value="<%= dc.getDiscountCode() %>"><%= dc.getRate() %></option>
                
            <% 
                }
            %>                
            </select><br/>
   --%>         
            <input type="submit" value="Enviar" />
        </form>
    </body>
</html>
