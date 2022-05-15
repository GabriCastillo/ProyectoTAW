/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package TAWapp.servlet;

import javax.ejb.EJB;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import TAWapp.dto.CategoriaDTO;
import TAWapp.dto.ListaDTO;
import TAWapp.dto.UsuarioDTO;
import TAWapp.service.CompradorProductoService;
import TAWapp.service.UsuarioService;
import TAWapp.service.ListaService;


/**
 *  @author Javier
 *  DONE: 100%
 *
 */
@WebServlet(name = "UsuarioServlet", urlPatterns = {"/UsuarioServlet"})
public class UsuarioServlet extends SampleTAWServlet {
    @EJB CompradorProductoService compradorProductoService;
    @EJB UsuarioService usuarioService;
    @EJB ListaService listaService;
    
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
        
        if (super.comprobarSession(request, response)) {
            String filtroListaAll = request.getParameter("filtroListaAll");            
            List<ListaDTO> nombresListas = this.listaService.listarListas(filtroListaAll);
            request.setAttribute("nombresListas", nombresListas);
            
            String filtroCompradorAll = request.getParameter("filtroCompradorAll");            
            List<UsuarioDTO> compradoresAll = this.usuarioService.listarClientes(filtroCompradorAll);
            request.setAttribute("usuarios", compradoresAll);
            
            List<CategoriaDTO> ultimasCategorias = new ArrayList<>();
            if(compradoresAll != null) {
                for(UsuarioDTO comprador : compradoresAll) {
                    ultimasCategorias.add(this.compradorProductoService.encontrarUltimaCategoriaCliente(comprador.getIdusuario()));
                }
            }
            request.setAttribute("ultimasCategorias", ultimasCategorias); 
            
            request.getRequestDispatcher("/WEB-INF/jsp/usuarios.jsp").forward(request, response);        
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
