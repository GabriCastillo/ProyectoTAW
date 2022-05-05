/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package TAWapp.servlet;

import TAWapp.service.UsuarioService;
import TAWapp.dao.RolFacade;
import TAWapp.dao.UsuarioFacade;
import TAWapp.entity.Rol;
import TAWapp.entity.Usuario;
import javax.ejb.EJB;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author casti
 */
@WebServlet(name = "UsuarioGuardarServlet", urlPatterns = {"/UsuarioGuardarServlet"})
public class UsuarioGuardarServlet extends TAWappServlet {

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
        if (super.comprobarSession(request, response)) {
            
            
            String nombre = request.getParameter("nombre");
            String apellido = request.getParameter("apellido");
            String domicilio = request.getParameter("domicilio");
            String ciudad = request.getParameter("ciudad");
            int edad = Integer.parseInt(request.getParameter("edad"));
            String sexo = request.getParameter("sexo");
            String contraseña = request.getParameter("password");
            int rol = Integer.parseInt(request.getParameter("rol"));

            String strId = request.getParameter("id");
            
            if (strId == null || strId.isEmpty()) {    // Crear nuevo usuario
                usuarioService.crearUsuario(nombre,  apellido,  domicilio,  ciudad, 
                               edad,  sexo,  contraseña,  rol);
            } else {                               // Editar usuario
               usuarioService.modificarUsuario(Integer.parseInt(strId),nombre,  apellido,  domicilio,  ciudad, 
                               edad,  sexo,  contraseña,  rol);
            }

            response.sendRedirect(request.getContextPath() + "/UsuarioServlet");
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
