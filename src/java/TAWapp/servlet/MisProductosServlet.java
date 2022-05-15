/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TAWapp.servlet;

import TAWapp.dto.CompradorProductoDTO;
import TAWapp.dto.FavoritoDTO;
import TAWapp.dto.ProductoDTO;
import TAWapp.dto.UsuarioDTO;
import TAWapp.service.CategoriaService;
import TAWapp.service.CompradorProductoService;
import TAWapp.service.FavoritoService;
import TAWapp.service.ProductoService;
import TAWapp.service.UsuarioService;
import java.io.IOException;
import java.io.PrintWriter;
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
 * @author frees
 */
@WebServlet(name = "MisProductosServlet", urlPatterns = {"/MisProductosServlet"})
public class MisProductosServlet extends HttpServlet {
@EJB
    UsuarioService usuarioService;
    @EJB ProductoService productoService;
    @EJB CategoriaService categoriaService;
    @EJB CompradorProductoService subastaService;
    @EJB FavoritoService favoritoService;
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
        HttpSession session = request.getSession();
        UsuarioDTO user = (UsuarioDTO) session.getAttribute("usuario");
        List<FavoritoDTO> listaFavoritos = this.favoritoService.listaPropiosFavoritos(user.getIdusuario());
        List<ProductoDTO> productos = this.productoService.listaFavoritos(listaFavoritos);
        List<CompradorProductoDTO> listaSubastas = this.subastaService.listaMisproductos(user.getIdusuario());  
        session.setAttribute("productos", productos);
        request.setAttribute("productos", productos);
        session.setAttribute("usuario", user);
        request.setAttribute("usuario", user);
        request.setAttribute("favoritos", listaFavoritos);
        session.setAttribute("favoritos", listaFavoritos);
        request.setAttribute("subastas", listaSubastas);
        session.setAttribute("subastas", listaSubastas);
        request.getRequestDispatcher("/WEB-INF/jsp/MisProductos.jsp").forward(request, response);
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
