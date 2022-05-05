<%-- 
    Document   : customers
    Created on : 14 mar. 2022, 12:01:31
    Author     : guzman
--%>

<%@page import="webappsampletaw.entity.Customer"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listado de clientes</title>
    </head>        
    <body>
        <jsp:include page="/WEB-INF/jsp/cabecera.jsp" />        
        
        <h1>Listado de clientes</h1>
        <form method="post" action="CustomerServlet">
            Nombre: <input type="text" name="filtroNombre" value="" />
            <input type="submit" value="Filtrar" />
        </form>
        
        <table border="1">
            <tr>
                <th>NAME</th>
                <th>ADDRESS</th>                
                <th>EMAIL</th>                                
                <th>CITY</th>     
                <th>MICROMARKET</th>                     
                <th>DISCOUNTCODE</th>                                     
                <th></th>                                                     
                <th></th>                                                                     
            </tr>
        <%
            List<Customer> clientes = (List)request.getAttribute("clientes");
            for (Customer cliente: clientes) {
        %>    
        <tr>
            <td><%= cliente.getName() %></td>
            <td><%= cliente.getAddressline1() %></td>            
            <td><%= cliente.getEmail() %></td>                     
            <td><%= cliente.getCity() %></td>                                 
           <td><%= cliente.getZip().getZipCode() %></td>                      
           <td><%= cliente.getDiscountCode().getRate() %></td>                  
           <td><a href="CustomerBorrarServlet?id=<%= cliente.getCustomerId() %>">Borrar</a></td> 
           <td><a href="CustomerNuevoEditarServlet?id=<%= cliente.getCustomerId() %>">Editar</a></td>            
        </tr>
        
        <%
            }
        %>
        </table>
        <a href="CustomerNuevoEditarServlet">Crear nuevo cliente ... </a>
        
    </body>
</html>
