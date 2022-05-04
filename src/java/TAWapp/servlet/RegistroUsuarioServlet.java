/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TAWapp.servlet;

import TAWapp.dto.RolDTO;
import TAWapp.dto.UsuarioDTO;
import TAWapp.service.RolService;
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
 * @author RaulDF
 */
@WebServlet(name = "RegistroUsuarioServlet", urlPatterns = {"/RegistroUsuarioServlet"})
public class RegistroUsuarioServlet extends TAWappServlet {

    @EJB
    UsuarioService usuarioService;
    @EJB
    RolService rolService;

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

        List<RolDTO> listaRoles = this.rolService.listarRoles();

        request.setAttribute("roles", listaRoles);

        UsuarioDTO usuario = null;
        request.setAttribute("usuario", usuario);

        request.getRequestDispatcher("/WEB-INF/jsp/usuarioNuevo.jsp").forward(request, response);

        /*
        String usuario = request.getParameter("usuario");
        String clave = request.getParameter("clave");        
        String claveRepetida = request.getParameter("claveRepetida");
              
        List<UsuarioDTO> listaUsers = this.us.listarUsuarios("");
        Boolean encontrado = false;
        int i=0;
        while(!encontrado && i<listaUsers.size()){ 
            encontrado = listaUsers.get(i).getNombre().equals(usuario);
            i++;
        }
        
        if(encontrado){
            String strError = "El usuario ya existe";
            request.setAttribute("error", strError);
            request.getRequestDispatcher("SignIn.jsp").forward(request, response);
        }else if(!clave.equals(claveRepetida)){
            String strError = "Las contraseñas no coinciden";
            request.setAttribute("error", strError);
            request.getRequestDispatcher("SignIn.jsp").forward(request, response);
        }else{
            UsuarioDTO user = this.us.crearUsuario(usuario,clave);
            HttpSession session = request.getSession();
            session.setAttribute("usuario", user);
            response.sendRedirect(request.getContextPath() + "/UsuarioServlet");                            

        }
         */
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
