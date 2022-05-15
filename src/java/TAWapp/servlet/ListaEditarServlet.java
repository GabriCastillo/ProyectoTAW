/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TAWapp.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import TAWapp.dto.CategoriaDTO;
import TAWapp.dto.ListaDTO;
import TAWapp.dto.ProductoDTO;
import TAWapp.dto.UsuarioDTO;
import TAWapp.service.CompradorProductoService;
import TAWapp.service.ListaService;
import TAWapp.service.ProductoService;
import TAWapp.service.UsuarioService;

/**
 *  @author Javier
 *  DONE: 100%
 *
 */
@WebServlet(name = "ListaEditarServlet", urlPatterns = {"/ListaEditarServlet"})
public class ListaEditarServlet extends TAWappServlet {
    @EJB ListaService listaService;
    @EJB UsuarioService usuarioService;
    @EJB ProductoService productoService;
    @EJB CompradorProductoService compradorProductoService;
    
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
        response.setContentType("text/html;charset=UTF-8");
        if (super.comprobarSession(request, response)) {
            String nombreLista = request.getParameter("nombreListaEditar");
            if(nombreLista == null) {
                HttpSession session = request.getSession(false);
                nombreLista = session.getAttribute("nombreListaEditar").toString();
            }
            
            
            
            List<ListaDTO> compradoresLista = this.listaService.listarListas(nombreLista);
            request.setAttribute("compradoresLista", compradoresLista);
            
            
            
            List<CategoriaDTO> ultimasCategoriasLista = new ArrayList<>();
            if(compradoresLista.get(0).getUsuarioLista() != null) {
                for(ListaDTO comprador : compradoresLista) {
                    ultimasCategoriasLista.add(this.compradorProductoService.encontrarUltimaCategoriaCliente(comprador.getUsuarioLista().getIdusuario()));
                }
            }
            request.setAttribute("ultimasCategoriasLista", ultimasCategoriasLista); 

            
            
            List<ProductoDTO> productosLista = this.productoService.listarProductosDisponibles();
            request.setAttribute("productosLista", productosLista);
                       
            
            
            String filtroCompradorAll = request.getParameter("filtroCompradorAll");            
            List<UsuarioDTO> compradoresAll = this.usuarioService.listarCompradores(filtroCompradorAll);
            request.setAttribute("compradores", compradoresAll);
            
            List<CategoriaDTO> ultimasCategorias = new ArrayList<>();
            if(compradoresAll != null) {
                for(UsuarioDTO comprador : compradoresAll) {
                    ultimasCategorias.add(this.compradorProductoService.encontrarUltimaCategoriaCliente(comprador.getIdusuario()));
                }
            }
            request.setAttribute("ultimasCategorias", ultimasCategorias); 
            
            
            
            request.getRequestDispatcher("/WEB-INF/jsp/lista.jsp").forward(request, response);     
        }
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
