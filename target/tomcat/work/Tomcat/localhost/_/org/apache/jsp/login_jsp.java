/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2021-02-15 18:16:58 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class login_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(2);
    _jspx_dependants.put("/footer.jsp", Long.valueOf(1611419454754L));
    _jspx_dependants.put("/header.jsp", Long.valueOf(1613411270798L));
  }

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write('\n');
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <title>Reserva online</title>\n");
      out.write("        <meta charset=\"utf-8\">\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
      out.write("    <!-- \n");
      out.write("        <script src=\"/js/jquery.min.js\"></script>\n");
      out.write("        <link href=\"/css/bootstrap.min.css\" rel=\"stylesheet\" type=\"text/css\" />\n");
      out.write("        <script src=\"/js/bootstrap.min.js\" ></script>\n");
      out.write("        <script src=\"/js/bootstrap3-floating-labels.js\" type=\"text/javascript\"></script>\n");
      out.write("        <link href=\"/css/bootstrap3-floating-labels.css\" rel=\"stylesheet\" type=\"text/css\"/> \n");
      out.write("    -->\n");
      out.write("    <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js\"></script>\n");
      out.write("    <link rel=\"stylesheet\" \n");
      out.write("    href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css\" \n");
      out.write("    integrity=\"sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z\" \n");
      out.write("    crossorigin=\"anonymous\">\n");
      out.write("    <link href=\"../css/estilos.css\" rel=\"stylesheet\">\n");
      out.write("    <!--<link href=\"css/estilos.css\" rel=\"stylesheet\">-->\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("       \n");
      out.write("        <!-- Static navbar -->            \n");
      out.write("        <nav class=\"navbar navbar-expand-lg navbar-light bg-light\">\n");
      out.write("            <div class=\" navbar-brand\">\n");
      out.write("                <img class=\" navbar-brand\" src=\"../img/profile.png\" width=\"30px\">\n");
      out.write("                ");
 
                
                    Cookie loginCookie = null;
                    String userName = "";
                    Cookie[] cookies = request.getCookies();
                    if (cookies != null) {
                        for (Cookie cookie : cookies) {
                            if (cookie.getName().equals("ges_res.user")) {
                                loginCookie = cookie;
                                userName = loginCookie.getValue();
                                break;
                            }
                        }
                        if (loginCookie!=null) {
                            
                        }else{
                            userName = "Login";
                        }
                        
                    }
                
      out.write("\n");
      out.write("                \n");
      out.write("                <a class=\" navbar-brand\" href=\"\">");
      out.print( userName);
      out.write("</a>\n");
      out.write("            </div>\n");
      out.write("            <a class=\"navbar-brand\" href=\"/\">Gestión Biblioteca</a>\n");
      out.write("            <button class=\"navbar-toggler\" type=\"button\" data-toggle=\"collapse\" data-target=\"#navbarSupportedContent\" aria-controls=\"navbarSupportedContent\" aria-expanded=\"false\" aria-label=\"Toggle navigation\">\n");
      out.write("                <span class=\"navbar-toggler-icon\"></span>\n");
      out.write("              </button>\n");
      out.write("            <div class=\"collapse navbar-collapse\" id=\"navbarSupportedContent\">\n");
      out.write("                <ul class=\"nav navbar-nav\">\n");
      out.write("                    <li class=\"nav-item\"><a class=\"nav-link\" href=\"/logout\">Logout</a></li>\n");
      out.write("                    <li class=\"nav-item dropdown\">\n");
      out.write("                        <a href=\"#\" class=\"nav-link dropdown-toggle\" data-toggle=\"dropdown\" role=\"button\" aria-haspopup=\"true\" aria-expanded=\"false\"> Usuarios <span class=\"caret\"></span></a>\n");
      out.write("                        <ul class=\"dropdown-menu\">\n");
      out.write("                            <li class=\"dropdown-item\"><a href=\"/privado/userRead.jsp\">Listado</a></li>\n");
      out.write("                            <li class=\"dropdown-item\"><a href=\"/privado/userCreate.jsp\">Alta</a></li>\n");
      out.write("                            <li class=\"dropdown-item\" ><a href=\"/privado/userUpdate.jsp\">Modificación</a></li>\n");
      out.write("                            <li class=\"dropdown-item\"><a href=\"/privado/userDelete.jsp\">Borrado</a></li>\n");
      out.write("                        </ul>\n");
      out.write("                    </li>\n");
      out.write("                    <li class=\"nav-item dropdown\">\n");
      out.write("                        <a href=\"#\" class=\"nav-link dropdown-toggle\" data-toggle=\"dropdown\" role=\"button\" aria-haspopup=\"true\" aria-expanded=\"false\"> Libros <span class=\"caret\"></span></a>\n");
      out.write("                        <ul class=\"dropdown-menu\">\n");
      out.write("                            <li class=\"dropdown-item\"><a href=\"/privado/libroRead.jsp\">Listar</a></li>\n");
      out.write("                            <li class=\"dropdown-item\"><a href=\"/privado/libroCreate.jsp\">Alta</a></li>\n");
      out.write("                            <li class=\"dropdown-item\"><a href=\"/privado/libroUpdate.jsp\">Modificación</a></li>\n");
      out.write("                            <li class=\"dropdown-item\"><a href=\"/privado/libroDelete.jsp\">Borrado</a></li>\n");
      out.write("                        </ul>\n");
      out.write("                    </li>\n");
      out.write("                    <li class=\"nav-item dropdown\">\n");
      out.write("                        <a href=\"#\" class=\"nav-link dropdown-toggle\" data-toggle=\"dropdown\" role=\"button\" aria-haspopup=\"true\" aria-expanded=\"false\"> Prestamos <span class=\"caret\"></span></a>\n");
      out.write("                        <ul class=\"dropdown-menu\">\n");
      out.write("                            <li class=\"dropdown-item\"><a href=\"/privado/prestamoRead.jsp\">Listar</a></li>\n");
      out.write("                            <li class=\"dropdown-item\"><a href=\"/privado/prestamoCreate.jsp\">Alta</a></li>\n");
      out.write("                            <li class=\"dropdown-item\"><a href=\"/privado/prestamoUpdate.jsp\">Modificación</a></li>\n");
      out.write("                            <li class=\"dropdown-item\"><a href=\"/privado/prestamoDelete.jsp\">Borrado</a></li>\n");
      out.write("                        </ul>\n");
      out.write("                    </li>\n");
      out.write("                    <li class=\"nav-item dropdown\">\n");
      out.write("                        <a href=\"#\" class=\"nav-link dropdown-toggle\" data-toggle=\"dropdown\" role=\"button\" aria-haspopup=\"true\" aria-expanded=\"false\"> Reseñas <span class=\"caret\"></span></a>\n");
      out.write("                        <ul class=\"dropdown-menu\">\n");
      out.write("                            <li class=\"dropdown-item\"><a href=\"/privado/resennaRead.jsp\">Listar</a></li>\n");
      out.write("                            <li class=\"dropdown-item\"><a href=\"/privado/resennaCreate.jsp\">Alta</a></li>\n");
      out.write("                            <li class=\"dropdown-item\"><a href=\"/privado/resennaUpdate.jsp\">Modificación</a></li>\n");
      out.write("                            <li class=\"dropdown-item\"><a href=\"/privado/resennaDelete.jsp\">Borrado</a></li>\n");
      out.write("                        </ul>\n");
      out.write("                    </li>\n");
      out.write("                    \n");
      out.write("                \n");
      out.write("                </ul>\n");
      out.write("            </div>\n");
      out.write("        </nav>\n");
      out.write("\n");
      out.write("        <div class=\"card\">");
      out.write("\n");
      out.write("<div class=\"container\">\n");
      out.write("    <div class=\"jumbotron\"><h2>Login</h2></div>\n");
      out.write("    <div class=\"form\">\n");
      out.write("        <form action=\"login\" method=\"POST\">\n");
      out.write("            <input name=\"username\" type=\"text\" placeholder=\"Nombre de usuario\" />\n");
      out.write("            <input name=\"pwd\" type=\"password\" placeholder=\"Contraseña\" />\n");
      out.write("            <button type=\"submit\">Enviar</button>\n");
      out.write("        </form>\n");
      out.write("    </div>\n");
      out.write("</div>\n");
      out.write("            \n");
      out.write("        </div> <!-- del DIV.container principal -->\n");
      out.write("        \n");
      out.write("\n");
      out.write("        <script src=\"https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js\" integrity=\"sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN\" crossorigin=\"anonymous\"></script>\n");
      out.write("        <script src=\"https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.min.js\" integrity=\"sha384-w1Q4orYjBQndcko6MimVbzY0tgp4pWB4lZ7lr30WKz0vr/aWKhXdBNmNb5D92v7s\" crossorigin=\"anonymous\"></script>\n");
      out.write("        <br>\n");
      out.write("        <br>\n");
      out.write("        <br>\n");
      out.write("        <br>\n");
      out.write("        <br>\n");
      out.write("        <br>\n");
      out.write("        <div class=\"pie\">\n");
      out.write("            <p>IES Virgen del Carmen</p>\n");
      out.write("            <p>Acceso a Datos</p>\n");
      out.write("            <p>2º CFGS DAM</p>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("    </body>\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
