package org.apache.jsp.WEB_002dINF.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import TAWapp.service.UsuarioService;
import TAWapp.dto.UsuarioDTO;
import TAWapp.dto.RolDTO;
import java.util.List;

public final class usuarioNuevo_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Nuevo usuario</title>\n");
      out.write("    </head>\n");
      out.write("    ");

        List<RolDTO> listaRoles = (List) request.getAttribute("roles");
        String strError = (String) request.getAttribute("error");
        if (strError == null) {
            strError = "";
        }
    
      out.write("    \n");
      out.write("    <body>\n");
      out.write("\n");
      out.write("\n");
      out.write("        <section id=\"formulario2\">        \n");
      out.write("            <h1 id=\"titulo\">Datos del Usuario</h1>\n");
      out.write("\n");
      out.write("            <form method=\"POST\" action=\"UsuarioGuardarNuevoServlet\">\n");
      out.write("                <div style=\"display:flex\">\n");
      out.write("                    <div class=\"izqBox\" style=\"width: 50%;margin-bottom: 15px\">\n");
      out.write("                        <input type=\"hidden\" name=\"id\"  />\n");
      out.write("\n");
      out.write("                        <div class=\"input-container ic1\">\n");
      out.write("                            <input id=\"nombre\" class=\"input\" type=\"text\" name=\"nombre\" placeholder=\" \" />\n");
      out.write("                            <div class=\"cut\"></div>\n");
      out.write("                            <label for=\"nombre\" class=\"placeholder\">Nombre</label>\n");
      out.write("                        </div>                   \n");
      out.write("                        <div class=\"input-container ic2\" >\n");
      out.write("                            <input id=\"apellido\" class=\"input\" type=\"text\" name=\"apellido\" placeholder=\" \" />\n");
      out.write("                            <div class=\"cut2\"></div>\n");
      out.write("                            <label for=\"apellido\" class=\"placeholder\">Apellido</label>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"input-container ic2\">\n");
      out.write("                            <input id=\"domicilio\" class=\"input\" type=\"text\" name=\"domicilio\" placeholder=\" \"  /> \n");
      out.write("                            <div class=\"cut2\"></div>\n");
      out.write("                            <label for=\"domicilio\" class=\"placeholder\">Domicilio</label>\n");
      out.write("                        </div>\n");
      out.write("\n");
      out.write("                        <div class=\"input-container ic2\" >\n");
      out.write("                            <input id=\"ciudad\" class=\"input\" type=\"text\" name=\"ciudad\" placeholder=\" \"  />\n");
      out.write("                            <div class=\"cut2\"></div>\n");
      out.write("                            <label for=\"ciudad\" class=\"placeholder\">Ciudad</label>\n");
      out.write("                        </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("                    </div>\n");
      out.write("\n");
      out.write("                    <div class=\"dBox\">\n");
      out.write("                        <div class=\"input-container ic1\" >\n");
      out.write("                            <input id=\"edad\" class=\"input\" type=\"text\" name=\"edad\" placeholder=\" \"  /> \n");
      out.write("                            <div class=\"cut2\"></div>\n");
      out.write("                            <label for=\"edad\" class=\"placeholder\">Edad</label>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"input-container ic2\" >\n");
      out.write("                            <input id=\"sexo\" class=\"input\"  type=\"text\" name=\"sexo\" placeholder=\" \"  />\n");
      out.write("                            <div class=\"cut3\"></div>\n");
      out.write("                            <label for=\"sexo\" class=\"placeholder\">Sexo</label>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"input-container ic2\" >\n");
      out.write("                            <input id=\"password\" class=\"input\" type=\"text\" name=\"password\" placeholder=\" \"  />\n");
      out.write("                            <div class=\"cut2\"></div>\n");
      out.write("                            <label for=\"password\" class=\"placeholder\">Contraseña</label>\n");
      out.write("                        </div>\n");
      out.write("\n");
      out.write("                        <div class=\"input-container ic2\" >\n");
      out.write("                            <input id=\"password2\" class=\"input\" type=\"text\" name=\"password2\" placeholder=\" \"  />\n");
      out.write("                            <div class=\"cut2\"></div>\n");
      out.write("                            <label for=\"password2\" class=\"placeholder\">Repetir Contraseña</label>\n");
      out.write("                        </div>\n");
      out.write("\n");
      out.write("                        <div class=\"input-container ic2\">\n");
      out.write("\n");
      out.write("                            <select id=\"rol\" class=\"input\" name=\"rol\" placeholder=\" \">\n");
      out.write("                                ");

                                    for (RolDTO r : listaRoles) {
                                        String selected = "";

                                
      out.write("\n");
      out.write("                                <option ");
      out.print( selected);
      out.write(" value=\"");
      out.print( String.valueOf(r.getIdRol()));
      out.write('"');
      out.write('>');
      out.print( r.getNombre());
      out.write("</option>    \n");
      out.write("                                ");

                                    }
                                
      out.write(" \n");
      out.write("                            </select>\n");
      out.write("                            <div class=\"cut2\"></div>\n");
      out.write("                            <label for=\"rol\" class=\"placeholder\">Rol</label>\n");
      out.write("\n");
      out.write("                        </div>\n");
      out.write("\n");
      out.write("                    </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("                </div>\n");
      out.write("                </br>\n");
      out.write("                <div style=\"text-align:center\"><input id=\"btn\" type=\"submit\" value=\"Añadir Usuario\" /></div>\n");
      out.write("\n");
      out.write("            </form>\n");
      out.write("        </section>\n");
      out.write("\n");
      out.write("        \n");
      out.write("    </body>\n");
      out.write("</html>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<style>\n");
      out.write("    *{\n");
      out.write("        box-sizing: border-box;\n");
      out.write("    }\n");
      out.write("    .input-container {\n");
      out.write("        height: 50px;\n");
      out.write("        position:relative ;\n");
      out.write("        width: 100%;\n");
      out.write("    }\n");
      out.write("\n");
      out.write("    .ic1 {\n");
      out.write("        margin-top: 40px;\n");
      out.write("    }\n");
      out.write("    .input {\n");
      out.write("        background-color: #828282;\n");
      out.write("        border-radius: 12px;\n");
      out.write("        border: 0;\n");
      out.write("        box-sizing: border-box;\n");
      out.write("        color: #eee;\n");
      out.write("        font-size: 15px;\n");
      out.write("        height: 100%;\n");
      out.write("        outline: 0;\n");
      out.write("        padding: 4px 20px 0 ;\n");
      out.write("        margin-left: 20px;\n");
      out.write("        width: 70%;\n");
      out.write("    }\n");
      out.write("\n");
      out.write("    .select {\n");
      out.write("        background-color: #828282;\n");
      out.write("        border-radius: 12px;\n");
      out.write("        border: 0;\n");
      out.write("        box-sizing: border-box;\n");
      out.write("        color: #eee;\n");
      out.write("        font-size: 15px;\n");
      out.write("        height: 100%;\n");
      out.write("        outline: 0;\n");
      out.write("        padding: 4px 20px 0 ;\n");
      out.write("        margin-left: 20px;\n");
      out.write("        width: 70%;\n");
      out.write("    }\n");
      out.write("    .input2 {\n");
      out.write("        background-color: #828282;\n");
      out.write("        border-radius: 12px;\n");
      out.write("        border: 0;\n");
      out.write("        box-sizing: border-box;\n");
      out.write("        color: #eee;\n");
      out.write("        font-size: 15px;\n");
      out.write("        height: 130px;\n");
      out.write("        outline: 0;\n");
      out.write("        padding: 4px 20px 0 ;\n");
      out.write("        margin-left: 20px;\n");
      out.write("        width: 70%;\n");
      out.write("    }\n");
      out.write("\n");
      out.write("\n");
      out.write("    .cut {\n");
      out.write("        background-color: #404040;\n");
      out.write("        border-radius: 10px;\n");
      out.write("        height: 20px;\n");
      out.write("        left: 20px;\n");
      out.write("        position: absolute;\n");
      out.write("        top: -20px;\n");
      out.write("        transform: translateY(0);\n");
      out.write("        transition: transform 200ms;\n");
      out.write("        width: 76px;\n");
      out.write("\n");
      out.write("    }\n");
      out.write("\n");
      out.write("    .cut2 {\n");
      out.write("        background-color: #404040;\n");
      out.write("        border-radius: 10px;\n");
      out.write("        height: 20px;\n");
      out.write("        left: 20px;\n");
      out.write("        position: absolute;\n");
      out.write("        top: -20px;\n");
      out.write("        transform: translateY(0);\n");
      out.write("        transition: transform 200ms;\n");
      out.write("        width: 96px;\n");
      out.write("\n");
      out.write("    }\n");
      out.write("    .cut3 {\n");
      out.write("        background-color: #404040;\n");
      out.write("        border-radius: 10px;\n");
      out.write("        height: 20px;\n");
      out.write("        left: 20px;\n");
      out.write("        position: absolute;\n");
      out.write("        top: -20px;\n");
      out.write("        transform: translateY(0);\n");
      out.write("        transition: transform 200ms;\n");
      out.write("        width: 96px;\n");
      out.write("\n");
      out.write("    }\n");
      out.write("    .cut2-short {\n");
      out.write("        width: 50px;\n");
      out.write("    }\n");
      out.write("    .cut-short {\n");
      out.write("        width: 50px;\n");
      out.write("    }\n");
      out.write("    .cut3-short {\n");
      out.write("        width: 50px;\n");
      out.write("    }\n");
      out.write("\n");
      out.write("    .input:focus ~ .cut,\n");
      out.write("    .input:not(:placeholder-shown) ~ .cut,\n");
      out.write("    .input:focus ~ .cut2,\n");
      out.write("    .input:not(:placeholder-shown) ~ .cut2,\n");
      out.write("    .input2:focus ~ .cut2,\n");
      out.write("    .input2:not(:placeholder-shown) ~ .cut2\n");
      out.write("    {\n");
      out.write("        transform: translateY(8px);\n");
      out.write("    }\n");
      out.write("\n");
      out.write("    .placeholder {\n");
      out.write("        color: white;\n");
      out.write("        font-family: sans-serif;\n");
      out.write("        left: 20px;\n");
      out.write("        line-height: 14px;\n");
      out.write("        pointer-events: none;\n");
      out.write("        position: absolute;\n");
      out.write("        transform-origin: 0 50%;\n");
      out.write("        transition: transform 200ms, color 200ms;\n");
      out.write("        top: 20px;\n");
      out.write("        margin-left: 10px;\n");
      out.write("    }\n");
      out.write("\n");
      out.write("    .input:focus ~ .placeholder,\n");
      out.write("    .input:not(:placeholder-shown) ~ .placeholder,\n");
      out.write("    .input2:focus ~ .placeholder,\n");
      out.write("    .input2:not(:placeholder-shown) ~ .placeholder{\n");
      out.write("        transform: translateY(-30px) translateX(10px) scale(0.75);\n");
      out.write("    }\n");
      out.write("\n");
      out.write("    .input:not(:placeholder-shown) ~ .placeholder,\n");
      out.write("    .input2:not(:placeholder-shown) ~ .placeholder{\n");
      out.write("        color: #828282;\n");
      out.write("    }\n");
      out.write("\n");
      out.write("    .input:focus ~ .placeholder,\n");
      out.write("    .input2:focus ~ .placeholder{\n");
      out.write("        color: #04AA6D;\n");
      out.write("    }\n");
      out.write("    .ic2 {\n");
      out.write("        margin-top: 30px;\n");
      out.write("    }\n");
      out.write("    .ic3 {\n");
      out.write("        margin-top: 108px;\n");
      out.write("    }\n");
      out.write("    #btn{\n");
      out.write("        background-color:#04AA6D;\n");
      out.write("        border: none;\n");
      out.write("        color: white;\n");
      out.write("        padding: 15px 32px;\n");
      out.write("        text-align: center;\n");
      out.write("        text-decoration: none;\n");
      out.write("        display: inline-block;\n");
      out.write("        font-size: 16px;\n");
      out.write("    }\n");
      out.write("    #formText{\n");
      out.write("        position: relative;\n");
      out.write("    }\n");
      out.write("    #relleno{\n");
      out.write("        background-color: #DBCFBB;\n");
      out.write("        border-radius: 25px;\n");
      out.write("        margin-left: 25px;\n");
      out.write("        height: auto;\n");
      out.write("        text-align: center;\n");
      out.write("        width: 200px;\n");
      out.write("    }\n");
      out.write("    body{\n");
      out.write("        background-color:  #DBCFBB;\n");
      out.write("    }\n");
      out.write("    #titulo{\n");
      out.write("        display: block;\n");
      out.write("        text-align: center;\n");
      out.write("        font-size:26px;\n");
      out.write("        color: white;\n");
      out.write("    }\n");
      out.write("    #subastas{\n");
      out.write("\n");
      out.write("        border-radius: 25px;\n");
      out.write("        margin-top: 10px;\n");
      out.write("        background-color:#404040 ;\n");
      out.write("        width: 60%;\n");
      out.write("        height: 600px;\n");
      out.write("        float: left;\n");
      out.write("    }\n");
      out.write("\n");
      out.write("    #formulario2{\n");
      out.write("        border-radius: 25px;\n");
      out.write("        margin-top: 10px;\n");
      out.write("        background-color:#404040 ;\n");
      out.write("        height: 600px;\n");
      out.write("        float:center;\n");
      out.write("    }\n");
      out.write("\n");
      out.write("    #usuarios{\n");
      out.write("\n");
      out.write("        border-radius: 25px;\n");
      out.write("        margin-top: 10px;\n");
      out.write("        background-color:#404040 ;\n");
      out.write("        width: 60%;\n");
      out.write("        height: 600px;\n");
      out.write("        float: left;\n");
      out.write("    }\n");
      out.write("    #formulario{\n");
      out.write("        border-radius: 25px;\n");
      out.write("        margin-top: 10px;\n");
      out.write("        background-color:#404040 ;\n");
      out.write("        width: 37%;\n");
      out.write("        height: 600px;\n");
      out.write("        float:right;\n");
      out.write("    }\n");
      out.write("    ul {\n");
      out.write("        list-style-type: none;\n");
      out.write("        margin: 0;\n");
      out.write("        padding: 0;\n");
      out.write("        overflow: hidden;\n");
      out.write("        background-color: #333;\n");
      out.write("    }\n");
      out.write("\n");
      out.write("    li {\n");
      out.write("        float: left;\n");
      out.write("        border-right:1px solid #bbb;\n");
      out.write("    }\n");
      out.write("\n");
      out.write("    li:last-child {\n");
      out.write("        border-right: none;\n");
      out.write("    }\n");
      out.write("\n");
      out.write("    li a {\n");
      out.write("        display: block;\n");
      out.write("        color: white;\n");
      out.write("        text-align: center;\n");
      out.write("        padding: 14px 16px;\n");
      out.write("        text-decoration: none;\n");
      out.write("    }\n");
      out.write("\n");
      out.write("    li a:hover:not(.active) {\n");
      out.write("        background-color: #111;\n");
      out.write("    }\n");
      out.write("\n");
      out.write("    .active {\n");
      out.write("        background-color: #04AA6D;\n");
      out.write("    }\n");
      out.write("\n");
      out.write("\n");
      out.write("    table{border-collapse:collapse;}\n");
      out.write("    th,tr,td{\n");
      out.write("        border:1px solid #000;\n");
      out.write("        width:150px;\n");
      out.write("        height:45px;\n");
      out.write("        vertical-align:middle;\n");
      out.write("        text-align:center;\n");
      out.write("    }\n");
      out.write("    th{\n");
      out.write("        color:#fff;\n");
      out.write("        background-color: #252525;\n");
      out.write("    }\n");
      out.write("\n");
      out.write("    tr:nth-child(odd) td{\n");
      out.write("        background-color:#eee;\n");
      out.write("    }\n");
      out.write("</style>\n");
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