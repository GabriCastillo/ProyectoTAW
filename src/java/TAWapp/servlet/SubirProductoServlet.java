/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TAWapp.servlet;

import TAWapp.dto.ProductoDTO;
import TAWapp.dto.UsuarioDTO;
import TAWapp.service.ProductoService;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 *
 * @author RaulDF
 */
@WebServlet(name = "SubirProductoServlet", urlPatterns = {"/SubirProductoServlet"})
public class SubirProductoServlet extends HttpServlet {
    @EJB ProductoService ps;
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String titulo = (String)request.getParameter("titulo");
        String descripcion = (String)request.getParameter("descripcion");
        Integer precioInicial =Integer.parseInt(request.getParameter("precioInicial")) ;
        Integer precioLimite = Integer.parseInt(request.getParameter("precioLimite"));
        String c = (String)request.getParameter("categoria");
        int categoria = Integer.parseInt(c);
        String imagen = (String)request.getParameter("imagen");
        String fechaLimite = (String)request.getParameter("fechaLimite");
        String i = (String) request.getParameter("id");
        int user = Integer.parseInt(i);
        this.ps.crearProducto(titulo, descripcion,imagen,categoria,user);
        
        List<ProductoDTO> productos = ps.listarProductos(titulo);
        ProductoDTO producto = productos.get(0);
        //Subasta tambien se crea
        
        HttpSession session = request.getSession();
        session.setAttribute("producto", producto);
        response.sendRedirect(request.getContextPath()+"/VenderServlet");
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
