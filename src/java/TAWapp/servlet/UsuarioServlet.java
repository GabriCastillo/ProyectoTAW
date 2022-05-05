/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package TAWapp.servlet;

import TAWapp.service.UsuarioService;
import TAWapp.dao.UsuarioFacade;
import TAWapp.dto.UsuarioDTO;
import TAWapp.entity.Usuario;
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
 * @author casti
 */
@WebServlet(name = "UsuarioServlet", urlPatterns = {"/UsuarioServlet"})
public class UsuarioServlet extends TAWappServlet {

    @EJB
    UsuarioService usuarioService;

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

            if (user.getRolIdrol().getIdRol() == 1) {
                String filtroNombre = request.getParameter("filtroNombre");
                List<UsuarioDTO> usuarios = this.usuarioService.listarUsuarios(filtroNombre);

                request.setAttribute("usuarios", usuarios);
                request.getRequestDispatcher("/WEB-INF/jsp/usuarios.jsp").forward(request, response);
            } else {
                request.getRequestDispatcher("/WEB-INF/jsp/iniciado.jsp").forward(request, response);
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
