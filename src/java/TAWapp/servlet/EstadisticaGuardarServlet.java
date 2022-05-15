/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TAWapp.servlet;

import TAWapp.dto.UsuarioDTO;
import static TAWapp.entity.Estadistica_.descripcion;
import static TAWapp.entity.Estadistica_.nombre;
import static TAWapp.entity.Estadistica_.usuarioAnalista;
import static TAWapp.entity.Estadistica_.valor;
import TAWapp.service.EstadisticaService;
import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author pepe_
 */
@WebServlet(name = "EstadisticaGuardarServlet", urlPatterns = {"/EstadisticaGuardarServlet"})
public class EstadisticaGuardarServlet extends TAWappServlet {

    @EJB EstadisticaService estadisticaService;
    
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
        
        if (super.comprobarSession(request, response)){
            //UsuarioDTO user = (UsuarioDTO) request.getAttribute("usuario");
            int usuarioAnalista = Integer.parseInt(request.getParameter("idUsuario"));
            String nombre = request.getParameter("nombre");
            String descripcion = request.getParameter("descripcion");
            //Double valor = this.estadisticaService.precioMedio();
            
            String strId = request.getParameter("id");
            
            if (strId == null || strId.isEmpty()){
                estadisticaService.crearEstadistica(usuarioAnalista, nombre, descripcion, 0);
            }else{
                estadisticaService.modifcarEstadistica(Integer.parseInt(strId), usuarioAnalista, nombre, descripcion, 0);
            }            
        }
        
        response.sendRedirect(request.getContextPath() + "");
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
