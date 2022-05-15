/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TAWapp.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import TAWapp.dto.CorreoDTO;
import TAWapp.service.CorreoService;
import TAWapp.service.UsuarioService;

/**
 *  @author Javier
 *  DONE: 100%
 *
 */
@WebServlet(name = "AnadirCorreoServlet", urlPatterns = {"/AnadirCorreoServlet"})
public class AnadirCorreoServlet extends SampleTAWServlet {
    @EJB CorreoService correoService;
    
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
            int idUsuario = Integer.parseInt(request.getParameter("idUsuario"));
            int idProductoPromo = Integer.parseInt(request.getParameter("productoSeleccionado"));
            String mensaje = request.getParameter("mensajePromo");
            
            this.correoService.crearCorreoIndividual(idUsuario, idProductoPromo, mensaje);

            request.getSession(false).setAttribute("idUsuarioCORREO", request.getParameter("idUsuario"));
            request.getSession(false).setAttribute("nombreUsuario", request.getParameter("nombreUsuario"));
            response.sendRedirect(request.getContextPath() + "/CorreoServlet");            
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
