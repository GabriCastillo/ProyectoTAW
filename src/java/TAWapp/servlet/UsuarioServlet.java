/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TAWapp.servlet;

import TAWapp.dto.CategoriaDTO;
import TAWapp.dto.CompradorProductoDTO;
import TAWapp.dto.EstadisticaDTO;
import TAWapp.dto.FavoritoDTO;
import TAWapp.dto.ProductoDTO;
import TAWapp.dto.RolDTO;
import TAWapp.service.UsuarioService;
import TAWapp.dto.UsuarioDTO;
import TAWapp.service.CategoriaService;
import TAWapp.service.CompradorProductoService;
import TAWapp.service.EstadisticaService;
import TAWapp.service.FavoritoService;
import TAWapp.service.ProductoService;
import TAWapp.service.RolService;
import javax.ejb.EJB;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import javax.servlet.http.HttpSession;

/**
 *
 * @author casti Done: 80%
 * @author Ruben Done: 20%
 */
@WebServlet(name = "UsuarioServlet", urlPatterns = {"/UsuarioServlet"})
public class UsuarioServlet extends TAWappServlet {

    @EJB
    UsuarioService usuarioService;
    @EJB
    RolService rolService;
    @EJB
    EstadisticaService estadisticaService;
    @EJB
    ProductoService productoService;
    @EJB
    CategoriaService categoriaService;
    @EJB
    CompradorProductoService subastaService;
    @EJB
    FavoritoService favoritoService;

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
            HttpSession session = request.getSession();
            UsuarioDTO user = (UsuarioDTO) session.getAttribute("usuario");
            session.setAttribute("usuario", user);
            request.setAttribute("usuario", user);

            switch (user.getRolIdrol().getIdRol()) {
                case 1:
                    List<RolDTO> listaRoles = this.rolService.listarRoles();
                    request.setAttribute("roles", listaRoles);
                    String filtroNombre = request.getParameter("filtroNombre");
                    String filtroApellido = request.getParameter("filtroApellido");
                    String filtroRol = request.getParameter("filtroRol");
                    List<UsuarioDTO> usuarios = this.usuarioService.listarUsuarios(filtroNombre, filtroApellido, filtroRol);
                    request.setAttribute("usuarios", usuarios);
                    request.getRequestDispatcher("/WEB-INF/jsp/usuarios.jsp").forward(request, response);
                    break;
                case 2:
                    List<CategoriaDTO> listaCategorias = this.categoriaService.listarCategorias();
                    request.setAttribute("categorias", listaCategorias);
                    List<ProductoDTO> productos = this.productoService.listarProductos("");
                    session.setAttribute("productos", productos);
                    request.setAttribute("productos", productos);
                    List<FavoritoDTO> listaFavoritos = this.favoritoService.listaPropiosFavoritos(user.getIdusuario());
                    request.setAttribute("favoritos", listaFavoritos);
                    session.setAttribute("favoritos", listaFavoritos);
                    List<CompradorProductoDTO> listaSubastas = this.subastaService.listaPropiasSubastas("");
                    request.setAttribute("subastas", listaSubastas);
                    session.setAttribute("subastas", listaSubastas);
                    request.setAttribute("productos", productos);
                    request.getRequestDispatcher("/WEB-INF/jsp/iniciado.jsp").forward(request, response);
                    break;
                case 3:
                    /*
                    String filtroNombre = request.getParameter("findByName");
            List<EstadisticaDTO> listaEstadisticas = this.estadisticaService.listarEstadisticas(filtroNombre);

            request.setAttribute("estadisticas", listaEstadisticas);
            String str = request.getParameter("id");
            if (str != null) {
                EstadisticaDTO estadistica = this.estadisticaService.buscarEstadistica(Integer.parseInt(str));
                request.setAttribute("estadistica", estadistica);
            }
                     */
                    String filtroTitulo = request.getParameter("filtroTitulo");
                    List<EstadisticaDTO> estadisticas = this.estadisticaService.listarEstadisticas(filtroTitulo);

                    request.setAttribute("estadisticas", estadisticas);
                    request.getRequestDispatcher("/WEB-INF/jsp/Analista.jsp").forward(request, response);
                    break;
                case 4:
                    response.sendRedirect(request.getContextPath() + "/MarketingServlet");
                    break;
                default:
                    break;
            }

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
