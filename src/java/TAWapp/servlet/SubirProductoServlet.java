/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TAWapp.servlet;

import TAWapp.dto.ProductoDTO;
import TAWapp.dto.UsuarioDTO;
import TAWapp.entity.Producto;
import TAWapp.service.CompradorProductoService;
import TAWapp.service.ProductoService;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
    @EJB CompradorProductoService cps;
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
        Producto pro = this.ps.crearProductoID(titulo, descripcion,imagen,categoria,user);
        
        //Producto pro = this.ps.listaProductos(producto.getTitulo()).get(0);
        this.cps.crearSubasta(pro,precioInicial,precioLimite,user);  
        
        

        
        //Subasta tambien se crea
        
        HttpSession session = request.getSession();
        session.setAttribute("producto", pro);
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
