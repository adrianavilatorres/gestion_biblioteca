/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2021-02-15 18:17:05 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.privado;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class prestamoUpdate_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(2);
    _jspx_dependants.put("/privado/../footer.jsp", Long.valueOf(1611419454754L));
    _jspx_dependants.put("/privado/../header.jsp", Long.valueOf(1613411270798L));
  }

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fsql_005fquery_0026_005fvar_005fdataSource;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fsql_005fquery_0026_005fvar_005fdataSource = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fsql_005fquery_0026_005fvar_005fdataSource.release();
    _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.release();
    _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.release();
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

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      if (_jspx_meth_sql_005fquery_005f0(_jspx_page_context))
        return;
      out.write('\n');
      out.write('\n');
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
      out.write("<div id=\"paso1\" align=\"center\">\n");
      out.write("    <div class=\"form\" id=\"prestamo-form\">\n");
      out.write("        <caption><h2>Seleccione el prestamo que desea actualizar</h2></caption>\n");
      out.write("        <select id=\"prestamoId\">\n");
      out.write("            ");
      if (_jspx_meth_c_005fforEach_005f0(_jspx_page_context))
        return;
      out.write("\n");
      out.write("        </select>\n");
      out.write("    </div>\n");
      out.write("    <button onclick=\"recargar()\">Enviar</button>\n");
      out.write("</div>\n");
      out.write("\n");
      out.write("<div id=\"paso2\" align=\"center\">\n");
      out.write("    <div class=\"form\">\n");
      out.write("        ID: <input id=\"prestamoid\" type=\"text\" disabled /> <br/>\n");
      out.write("        Fecha Inicio: <input id=\"fecha_inicio\" type=\"date\" placeholder=\"Fecha de inicio\" disabled/> <br/>\n");
      out.write("        Fecha Fin: <input id=\"fecha_fin\" type=\"date\" placeholder=\"Fecha fin\" disabled/><br/>\n");
      out.write("        Usuario ID: <input id=\"usuario_id\" type=\"text\" placeholder=\"ID del usuario\" disabled/><br/>\n");
      out.write("        Prorroga: <input id=\"prorroga\" type=\"date\" placeholder=\"Prorroga\" /><br/>\n");
      out.write("        Estado: <input id=\"estado\" type=\"text\" placeholder=\"Estado\" /><br/>\n");
      out.write("        Libro ID: <input id=\"libro_id\" type=\"text\" placeholder=\"ID del libro\" disabled/><br/>\n");
      out.write("        <button onclick=\"enviar()\">Enviar</button>\n");
      out.write("    </div>\n");
      out.write("</div>\n");
      out.write("\n");
      out.write("\n");
      out.write("<script type=\"text/javascript\">\n");
      out.write("    $(\"#paso2\").hide();\n");
      out.write("    $(\"#prestamo-form > option\").first().attr(\"selected\", true);\n");
      out.write("    // $(\"#user-form > option\").first().prop(\"selected\", true);\n");
      out.write("    \n");
      out.write("    function recargar(){\n");
      out.write("        var $form = $(\"#prestamo-form\");\n");
      out.write("        var prestamoId = $(\"#prestamoId\").val();\n");
      out.write("        var url = 'http://localhost:9090/prestamo/'+prestamoId;\n");
      out.write("        \n");
      out.write("        console.log('Intentando borrar presamo: id='+prestamoId);\n");
      out.write("        $.ajax({\n");
      out.write("            type : 'GET',\n");
      out.write("            url : url,\n");
      out.write("            contentType: 'application/json',\n");
      out.write("            // data : JSON.stringify({name: userName, email: userEmail}),\n");
      out.write("            success : function(data, status, xhr){\n");
      out.write("                let prestamo = data;\n");
      out.write("                $(\"#paso1\").hide();\n");
      out.write("                $(\"#paso2\").show();\n");
      out.write("                $(\"#prestamoid\").val(prestamo.id);\n");
      out.write("                $(\"#fecha_inicio\").val(prestamo.fecha_inicio);\n");
      out.write("                $(\"#fecha_fin\").val(prestamo.fecha_fin);\n");
      out.write("                $(\"#usuario_id\").val(prestamo.usuario_id);\n");
      out.write("                $(\"#prorroga\").val(prestamo.prorroga);\n");
      out.write("                $(\"#estado\").val(prestamo.estado);\n");
      out.write("                $(\"#libro_id\").val(prestamo.libro_id);\n");
      out.write("\n");
      out.write("            },\n");
      out.write("            error: function(xhr, status, error){\n");
      out.write("            $('#msg').html('<span style=\\'color:red;\\'>'+error+'</span>')\n");
      out.write("            }\n");
      out.write("        });\n");
      out.write("        $(\"#paso1\").hide();\n");
      out.write("        $(\"#paso2\").show();\n");
      out.write("    };\n");
      out.write("    \n");
      out.write("    \n");
      out.write("    function enviar(){\n");
      out.write("        var url = 'http://localhost:9090/prestamo/'+$(\"#prestamoid\").val();\n");
      out.write("        var datos = {};\n");
      out.write("        datos.id = $(\"#prestamoid\").val();\n");
      out.write("        datos.fecha_inicio = $(\"#fecha_inicio\").val();\n");
      out.write("        datos.fecha_fin = $(\"#fecha_fin\").val();\n");
      out.write("        datos.usuario_id = $(\"#usuario_id\").val();\n");
      out.write("        datos.prorroga = $(\"#prorroga\").val();\n");
      out.write("        datos.estado = $(\"#estado\").val();\n");
      out.write("        datos.libro_id = $(\"#libro_id\").val();\n");
      out.write("\n");
      out.write("        alert(datos.libro_id)\n");
      out.write("        $.ajax({\n");
      out.write("            type : 'PUT',\n");
      out.write("            complete: function(data, status, xhr){\n");
      out.write("                console.log(\"EXITO!!!!!!\" + data);\n");
      out.write("                window.location.replace(\"prestamoRead.jsp\");          \n");
      out.write("            },\n");
      out.write("            url : url,\n");
      out.write("            contentType: 'application/json',\n");
      out.write("            data : JSON.stringify(datos),\n");
      out.write("            error: function(xhr, status, error){\n");
      out.write("                $('#msg').html('<span style=\\'color:red;\\'>'+error+'</span>');\n");
      out.write("            }\n");
      out.write("        });\n");
      out.write("    }\n");
      out.write("    </script>\n");
      out.write("        \n");
      out.write("        \n");
      out.write("\n");
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
      out.write(' ');
      out.write('\n');
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

  private boolean _jspx_meth_sql_005fquery_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  sql:query
    org.apache.taglibs.standard.tag.rt.sql.QueryTag _jspx_th_sql_005fquery_005f0 = (org.apache.taglibs.standard.tag.rt.sql.QueryTag) _005fjspx_005ftagPool_005fsql_005fquery_0026_005fvar_005fdataSource.get(org.apache.taglibs.standard.tag.rt.sql.QueryTag.class);
    _jspx_th_sql_005fquery_005f0.setPageContext(_jspx_page_context);
    _jspx_th_sql_005fquery_005f0.setParent(null);
    // /privado/prestamoUpdate.jsp(5,0) name = var type = java.lang.String reqTime = false required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_sql_005fquery_005f0.setVar("prestamoList");
    // /privado/prestamoUpdate.jsp(5,0) name = dataSource type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_sql_005fquery_005f0.setDataSource("jdbc/gestionBiblioteca");
    int[] _jspx_push_body_count_sql_005fquery_005f0 = new int[] { 0 };
    try {
      int _jspx_eval_sql_005fquery_005f0 = _jspx_th_sql_005fquery_005f0.doStartTag();
      if (_jspx_eval_sql_005fquery_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        if (_jspx_eval_sql_005fquery_005f0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
          out = _jspx_page_context.pushBody();
          _jspx_push_body_count_sql_005fquery_005f0[0]++;
          _jspx_th_sql_005fquery_005f0.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
          _jspx_th_sql_005fquery_005f0.doInitBody();
        }
        do {
          out.write("\n");
          out.write("    select id, fecha_inicio, fecha_fin, usuario_id, prorroga, estado, libro_id from prestamos;\n");
          int evalDoAfterBody = _jspx_th_sql_005fquery_005f0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
        if (_jspx_eval_sql_005fquery_005f0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
          out = _jspx_page_context.popBody();
          _jspx_push_body_count_sql_005fquery_005f0[0]--;
        }
      }
      if (_jspx_th_sql_005fquery_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (java.lang.Throwable _jspx_exception) {
      while (_jspx_push_body_count_sql_005fquery_005f0[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_sql_005fquery_005f0.doCatch(_jspx_exception);
    } finally {
      _jspx_th_sql_005fquery_005f0.doFinally();
      _005fjspx_005ftagPool_005fsql_005fquery_0026_005fvar_005fdataSource.reuse(_jspx_th_sql_005fquery_005f0);
    }
    return false;
  }

  private boolean _jspx_meth_c_005fforEach_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_005fforEach_005f0 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_005fforEach_005f0.setPageContext(_jspx_page_context);
    _jspx_th_c_005fforEach_005f0.setParent(null);
    // /privado/prestamoUpdate.jsp(15,12) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fforEach_005f0.setVar("prestamo");
    // /privado/prestamoUpdate.jsp(15,12) name = items type = javax.el.ValueExpression reqTime = true required = false fragment = false deferredValue = true expectedTypeName = java.lang.Object deferredMethod = false methodSignature = null
    _jspx_th_c_005fforEach_005f0.setItems(new org.apache.jasper.el.JspValueExpression("/privado/prestamoUpdate.jsp(15,12) '${prestamoList.rows}'",_el_expressionfactory.createValueExpression(_jspx_page_context.getELContext(),"${prestamoList.rows}",java.lang.Object.class)).getValue(_jspx_page_context.getELContext()));
    int[] _jspx_push_body_count_c_005fforEach_005f0 = new int[] { 0 };
    try {
      int _jspx_eval_c_005fforEach_005f0 = _jspx_th_c_005fforEach_005f0.doStartTag();
      if (_jspx_eval_c_005fforEach_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\n");
          out.write("                <option value=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${prestamo.id}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
          out.write("\"/> \n");
          out.write("                    ");
          if (_jspx_meth_c_005fout_005f0(_jspx_th_c_005fforEach_005f0, _jspx_page_context, _jspx_push_body_count_c_005fforEach_005f0))
            return true;
          out.write("\n");
          out.write("                </option>\n");
          out.write("            ");
          int evalDoAfterBody = _jspx_th_c_005fforEach_005f0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_005fforEach_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (java.lang.Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_005fforEach_005f0[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_005fforEach_005f0.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_005fforEach_005f0.doFinally();
      _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.reuse(_jspx_th_c_005fforEach_005f0);
    }
    return false;
  }

  private boolean _jspx_meth_c_005fout_005f0(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fforEach_005f0, javax.servlet.jsp.PageContext _jspx_page_context, int[] _jspx_push_body_count_c_005fforEach_005f0)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:out
    org.apache.taglibs.standard.tag.rt.core.OutTag _jspx_th_c_005fout_005f0 = (org.apache.taglibs.standard.tag.rt.core.OutTag) _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.OutTag.class);
    _jspx_th_c_005fout_005f0.setPageContext(_jspx_page_context);
    _jspx_th_c_005fout_005f0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fforEach_005f0);
    // /privado/prestamoUpdate.jsp(17,20) name = value type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fout_005f0.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${prestamo.id}", java.lang.Object.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
    int _jspx_eval_c_005fout_005f0 = _jspx_th_c_005fout_005f0.doStartTag();
    if (_jspx_th_c_005fout_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005fout_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005fout_005f0);
    return false;
  }
}
