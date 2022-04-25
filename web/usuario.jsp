<%-- 
    Document   : customer
    Created on : 16 mar. 2022, 11:44:12
    Author     : guzman
--%>

<%@page import="webappsampletaw.entity.Customer"%>
<%@page import="webappsampletaw.entity.DiscountCode"%>
<%@page import="webappsampletaw.entity.MicroMarket"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <%
        <%-- 
        List<MicroMarket> listaSuper = (List)request.getAttribute("supermercados");
        List<DiscountCode> listaDescuentos = (List)request.getAttribute("descuentos");
--%>
        Usuario usuario = (Usuario)request.getAttribute("usuario");
    %>    
    <body>
        <h1>Datos del cliente</h1>
        <form method="POST" action="CustomerGuardarServlet">
            <input type="hidden" name="id" value="<%= cliente==null? "": usuario.getIdusuario() %>" />
            Nombre: <input type="text" size="30" name="nombre" value="<%= usuario==null? "": cliente.getNombre() %>" /> <br/>
            Apellido <input type="text" size="30" name="domicilio1" value="<%= usuario==null? "": cliente.getApellido() %>" /> <input type="text" name="domicilio2" size="30" value="<%= cliente==null? "": cliente.getAddressline2() %>" /><br/>
            Domicilio:<input type="text" size="40" name="email" value="<%= usuario==null? "": cliente.getDomicilio() %>" /> <br/>
            Ciudad: <input type="text" size="25" name="ciudad" value="<%= usuario==null? "": cliente.getCiudadResidencia() %>" /> <br/>
            Edad: <input type="text" size="2" name="estado" value="<%= usuario==null? "": cliente.getEdad() %>" /> <br/>
            Sexo: <input type="text" size="12" name="telefono" value="<%= usuario==null? "": cliente.getSexo() %>" /> <br/>
            Rol: <input type="text" size="12"  name="fax" value="<%= usuario==null? "": cliente.getRolIdrol() %>" /> <br/>

           <%-- 
            Supermercado: 
            <select name="supermercado">
            <% 
                for (MicroMarket mm:listaSuper) {
                    String selected = "";
                    if (cliente != null && cliente.getZip().getZipCode().equals(mm.getZipCode())) {
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
                    if (cliente != null && 
                         cliente.getDiscountCode().getDiscountCode().equals(dc.getDiscountCode())) {
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
