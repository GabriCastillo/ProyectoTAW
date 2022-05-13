/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TAWapp.servlet;

import TAWapp.dao.RolFacade;
import TAWapp.dto.UsuarioDTO;
import TAWapp.service.UsuarioService;
import java.io.IOException;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author casti
 * Done: 100%
 */
@WebServlet(name = "UsuarioGuardarNuevoServlet", urlPatterns = {"/UsuarioGuardarNuevoServlet"})
public class UsuarioGuardarNuevoServlet extends TAWappServlet {

    @EJB
    UsuarioService usuarioService;
    @EJB
    RolFacade rolFacade;

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

        String clave = request.getParameter("password");
        String claveRepetida = request.getParameter("password2");
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String domicilio = request.getParameter("domicilio");
        String ciudad = request.getParameter("ciudad");
        int edad = Integer.parseInt(request.getParameter("edad"));
        String sexo = request.getParameter("sexo");
        int rol = Integer.parseInt(request.getParameter("rol"));

        List<UsuarioDTO> listaUsers = this.usuarioService.listarUsuarios("", "", "");
        Boolean encontrado = false;
        int i = 0;
        while (!encontrado && i < listaUsers.size()) {
            encontrado = listaUsers.get(i).getNombre().equals(nombre);
            i++;
        }

        String strError;

        if (encontrado) {
            strError = "El usuario ya existe";
            request.setAttribute("error", strError);
            request.getRequestDispatcher("RegistroUsuarioServlet").forward(request, response);

         //   response.sendRedirect(request.getContextPath() + "/RegistroUsuarioServlet");
        } else if (!clave.equals(claveRepetida)) {
            strError = "Las contraseñas no coinciden";
            request.setAttribute("error", strError);
            request.getRequestDispatcher("RegistroUsuarioServlet").forward(request, response);

        } else {
            this.usuarioService.crearUsuario(nombre, apellido, domicilio, ciudad, edad, sexo, clave, rol);

            request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request, response);

        }

        // response.sendRedirect(request.getContextPath() + "/WEB-INF/jsp/login.jsp");
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
