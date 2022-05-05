/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package TAWapp.servlet;

import TAWapp.dto.RolDTO;
import TAWapp.dto.UsuarioDTO;
import TAWapp.service.RolService;
import TAWapp.service.UsuarioService;
import TAWapp.entity.Rol;
import TAWapp.entity.Usuario;
import javax.ejb.EJB;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 *
 * @author casti
 */
@WebServlet(name = "UsuarioNuevoEditarServlet", urlPatterns = {"/UsuarioNuevoEditarServlet"})
public class UsuarioNuevoEditarServlet extends TAWappServlet {

    @EJB UsuarioService usuarioService;
    @EJB RolService rolService;

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
            List<RolDTO> listaRoles = this.rolService.listarRoles();

            request.setAttribute("roles", listaRoles);

            String str = request.getParameter("id");
            if (str != null) {
                UsuarioDTO usuario = this.usuarioService.buscarUsuario(Integer.parseInt(str));
                request.setAttribute("usuario", usuario);
            }

            request.getRequestDispatcher("/WEB-INF/jsp/usuario.jsp").forward(request, response);
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
