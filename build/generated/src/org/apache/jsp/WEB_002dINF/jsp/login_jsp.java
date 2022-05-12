package org.apache.jsp.WEB_002dINF.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

public final class login_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        <title>Bienvenido al sistema</title>\n");
      out.write("    </head>\n");
      out.write("    ");

        String strError = (String) request.getAttribute("error");
        if (strError == null) {
            strError = "";
        }
    
      out.write("    \n");
      out.write("    <body>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("        <div class=\"loginBox\"> <img class=\"user\" src=\"https://i.ibb.co/yVGxFPR/2.png\" height=\"100px\" width=\"100px\">\n");
      out.write("            <h3>Inicia Sesion</h3>\n");
      out.write("            <form action=\"LoginServlet\" method=\"post\">\n");
      out.write("                <div class=\"inputBox\"> \n");
      out.write("                    <input id=\"usuario\" type=\"text\" name=\"usuario\" placeholder=\"Usuario\"> \n");
      out.write("                    <input id=\"password\" type=\"password\" name=\"clave\" placeholder=\"Contraseña\"> \n");
      out.write("                </div> <input type=\"submit\" value=\"Entrar\">\n");
      out.write("            </form> \n");
      out.write("            <div class=\"text-center\">\n");
      out.write("                <a href=\"RegistroUsuarioServlet\" style=\"color: #59238F;\">Registrate</a>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        ");

            if (strError != "") {
        
      out.write("  \n");
      out.write("        <script>\n");
      out.write("            function myFunction() {\n");
      out.write("                alert(\"");
      out.print( strError );
      out.write("\");\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            myFunction();\n");
      out.write("        </script>\n");
      out.write("        ");

            }
        
      out.write("              \n");
      out.write("\n");
      out.write("\n");
      out.write("    </body>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("</html>\n");
      out.write("\n");
      out.write("<style>\n");
      out.write("\n");
      out.write("\n");
      out.write("    body{margin: 0;padding: 0;background: url(https://i.ibb.co/1GQFwtt/Screen-Shot1575.webp) no-repeat;height: 100vh;font-family: sans-serif;background-size: cover;background-repeat: no-repeat;background-position: center;overflow: hidden}\n");
      out.write("    #particles-js{height: 100%}.loginBox{position: absolute;top: 50%;left: 50%;transform: translate(-50%,-50%);width: 350px;min-height: 200px;background: #000000;border-radius: 10px;padding: 40px;box-sizing: border-box}.user{margin: 0 auto;display: block;margin-bottom: 20px}\n");
      out.write("    h3{margin: 0;padding: 0 0 20px;color: #59238F;text-align: center}.loginBox input{width: 100%;margin-bottom: 20px}.loginBox input[type=\"text\"], .loginBox input[type=\"password\"]{border: none;border-bottom: 2px solid #262626;outline: none;height: 40px;color: #fff;background: transparent;font-size: 16px;padding-left: 20px;box-sizing: border-box}.loginBox input[type=\"text\"]:hover, .loginBox input[type=\"password\"]:hover{color: #42F3FA;border: 1px solid #42F3FA;box-shadow: 0 0 5px rgba(0,255,0,.3), 0 0 10px rgba(0,255,0,.2), 0 0 15px rgba(0,255,0,.1), 0 2px 0 black}.loginBox input[type=\"text\"]:focus, .loginBox input[type=\"password\"]:focus{border-bottom: 2px solid #42F3FA}.inputBox{position: relative}.inputBox span{position: absolute;top: 10px;color: #262626}.loginBox input[type=\"submit\"]{border: none;outline: none;height: 40px;font-size: 16px;background: #59238F;color: #fff;border-radius: 20px;cursor: pointer}.loginBox a{color: #262626;font-size: 14px;font-weight: bold;text-decoration: none;text-align: center;display: block}a:hover{color: #00ffff}p{color: #0000ff}\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("</style>\n");
      out.write("\n");
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
