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
        List<MicroMarket> listaSuper = (List)request.getAttribute("supermercados");
        List<DiscountCode> listaDescuentos = (List)request.getAttribute("descuentos");

        Customer cliente = (Customer)request.getAttribute("cliente");
    %>    
    <body>
        <jsp:include page="/WEB-INF/jsp/cabecera.jsp" />           
        <h1>Datos del cliente</h1>
        <form method="POST" action="CustomerGuardarServlet">
            <input type="hidden" name="id" value="<%= cliente==null? "": cliente.getCustomerId() %>" />
            Nombre: <input type="text" size="30" name="nombre" value="<%= cliente==null? "": cliente.getName() %>" /> <br/>
            Domicilio: <input type="text" size="30" name="domicilio1" value="<%= cliente==null? "": cliente.getAddressline1() %>" /> <input type="text" name="domicilio2" size="30" value="<%= cliente==null? "": cliente.getAddressline2() %>" /><br/>
            Email:<input type="text" size="40" name="email" value="<%= cliente==null? "": cliente.getEmail() %>" /> <br/>
            Ciudad: <input type="text" size="25" name="ciudad" value="<%= cliente==null? "": cliente.getCity() %>" /> <br/>
            Estado: <input type="text" size="2" name="estado" value="<%= cliente==null? "": cliente.getState() %>" /> <br/>
            Teléfono: <input type="text" size="12" name="telefono" value="<%= cliente==null? "": cliente.getPhone() %>" /> <br/>
            Fax: <input type="text" size="12"  name="fax" value="<%= cliente==null? "": cliente.getFax() %>" /> <br/>
            Límite de crédito: <input type="text" size="10" name="credito" value="<%= cliente==null? "": cliente.getCreditLimit() %>" /> <br/>               
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
            
            <input type="submit" value="Enviar" />
        </form>
    </body>
</html>
