/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package TAWapp.servlet;

import TAWapp.dao.EstadisticaFacade;
import TAWapp.dao.ProductoFacade;
import TAWapp.dao.RolFacade;
import TAWapp.dao.UsuarioFacade;
import TAWapp.entity.Rol;
import TAWapp.entity.Usuario;
import javax.ejb.EJB;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author casti
 */
@WebServlet(name = "UsuarioGuardarServlet", urlPatterns = {"/UsuarioGuardarServlet"})
public class UsuarioGuardarServlet extends HttpServlet {

    @EJB
    UsuarioFacade usuarioFacade;
    @EJB
    RolFacade rolFacade;
    @EJB
    EstadisticaFacade estadisitcaFacade;
    @EJB
    ProductoFacade productoFacade;

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

        String strId, str;
        Usuario usuario;

        strId = request.getParameter("id");

        if (strId == null || strId.isEmpty()) {    // Crear nuevo usuario
            usuario = new Usuario();
        } else {                               // Editar usuario
            usuario = this.usuarioFacade.find(Integer.parseInt(strId));
        }

        str = request.getParameter("nombre");
        usuario.setNombre(str);

        str = request.getParameter("apellido");
        usuario.setApellido(str);

        str = request.getParameter("domicilio");
        usuario.setDomicilio(str);

        str = request.getParameter("ciudad");
        usuario.setCiudadResidencia(str);

        str = request.getParameter("edad");
        usuario.setEdad(Integer.parseInt(str));

        str = request.getParameter("sexo");
        usuario.setSexo(str);

        str = request.getParameter("rol");
        Rol rol = this.rolFacade.find(str);
        usuario.setRolIdrol(rol);

    
        
       /* 
        switch(rol.getIdRol()){
            case 0: //Admin
                
                break;
            
            case 1: //Comprador
                
                break;
                
            case 2: //Vendedor
                
                break;
                        
            case 3: //Analista
                
                break;
                        
            case 4: //Marketing
                
                break;
        }
        
        */
        
        

        if (strId == null || strId.isEmpty()) {    // Crear nuevo usuario
            usuarioFacade.create(usuario);
        } else {                                   // Editar usuario
            usuarioFacade.edit(usuario);
        }
        
        

        response.sendRedirect(request.getContextPath() + "/UsuarioServlet");

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
