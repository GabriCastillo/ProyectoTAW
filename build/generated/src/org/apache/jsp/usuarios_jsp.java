package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import entity.Usuario;
import java.util.List;

public final class usuarios_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Listado de usuarios</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <h1>Listado de usuarios</h1>\n");
      out.write("        <table border=\"1\">\n");
      out.write("            <tr>\n");
      out.write("                <th>NOMBRE</th>\n");
      out.write("                <th>APELLIDO</th>                \n");
      out.write("                <th>DOMICILIO</th>                                \n");
      out.write("                <th>CIUDAD_RESIDENCIA</th>     \n");
      out.write("                <th>EDAD</th>                     \n");
      out.write("                <th>SEXO</th>                                     \n");
      out.write("                <th></th>                                                     \n");
      out.write("                <th></th>                                                                     \n");
      out.write("            </tr>\n");
      out.write("        ");

            List<Usuario> usuarios = (List)request.getAttribute("usuarios");
            for (Usuario usuario: usuarios) {
        
      out.write("    \n");
      out.write("        <tr>\n");
      out.write("            <td>");
      out.print( usuario.getNombre() );
      out.write("</td>\n");
      out.write("            <td>");
      out.print( usuario.getApellido() );
      out.write("</td>            \n");
      out.write("            <td>");
      out.print( usuario.getDomicilio() );
      out.write("</td>                     \n");
      out.write("            <td>");
      out.print( usuario.getCiudadResidencia() );
      out.write("</td>                                 \n");
      out.write("           <td>");
      out.print( usuario.getEdad());
      out.write("</td>                      \n");
      out.write("           <td>");
      out.print( usuario.getSexo() );
      out.write("</td>                  \n");
      out.write("           <td><a href=\"UsuarioBorrarServlet?id=");
      out.print( usuario.getIdusuario() );
      out.write("\">Borrar</a></td> \n");
      out.write("           <td><a href=\"UsuarioNuevoEditarServlet?id=");
      out.print( usuario.getIdusuario() );
      out.write("\">Editar</a></td>            \n");
      out.write("        </tr>\n");
      out.write("        \n");
      out.write("        ");

            }
        
      out.write("\n");
      out.write("        </table>\n");
      out.write("        <a href=\"UsuarioNuevoEditarServlet\">Crear nuevo usuario ... </a>\n");
      out.write("        \n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
