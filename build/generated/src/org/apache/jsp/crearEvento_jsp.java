package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class crearEvento_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>PvPLobby</title>\n");
      out.write("        <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js\"></script>\n");
      out.write("        <!--Import Google Icon Font-->\n");
      out.write("        <link href=\"https://fonts.googleapis.com/icon?family=Material+Icons\" rel=\"stylesheet\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://www.w3schools.com/w3css/4/w3.css\">\n");
      out.write("        <!--Import materialize.css-->\n");
      out.write("        <link href=\"css/materialize.min.css\" rel=\"stylesheet\" type=\"text/css\"/>         \n");
      out.write("        <!--Let browser know website is optimized for mobile-->\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\"/>\n");
      out.write("        <link href=\"css/Style.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("        <script src=\"js/validacionRegistro.js\" type=\"text/javascript\"></script>\n");
      out.write("    </head>\n");
      out.write("    <body class=\"grey lighten-4\">\n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "header.jsp", out, false);
      out.write("\n");
      out.write("        <main>\n");
      out.write("            <section style=\"padding-top: 30px; padding-bottom: 30px; \" class=\"container\">\n");
      out.write("                <div style=\"border: solid #cccccc 1px;\" class=\"row card\">\n");
      out.write("\n");
      out.write("                    <div class=\"col s12 m4 l3 center\"> <!-- Note that \"m4 l3\" was added -->\n");
      out.write("                        <div style=\"padding-top: 50px;\" class=\"row\">\n");
      out.write("                            <img style=\"border: solid black 1px;\" src=\"img/Union 4.png\" class=\"imgPersona circle white\">\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"row\">\n");
      out.write("                            <h4>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${user}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</h4>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"row\">\n");
      out.write("\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"row\">\n");
      out.write("                            <form action=\"SERVFeed\">\n");
      out.write("                                <button type=\"submit\" style=\"margin-top: 20px; padding: 20px;\" class=\"w3-button tablink w3-blue col s12\">Volver</button>\n");
      out.write("                            </form>\n");
      out.write("\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("\n");
      out.write("                    <div style=\"outline: solid #cccccc 1px\" class=\"col s12 m8 l9 opciones\"> \n");
      out.write("                        <form action=\"SERVCrearEvento\" method=\"POST\" autocomplete=\"off\">\n");
      out.write("                            <div class=\"container\">\n");
      out.write("                                <h4 style=\"margin-top: 50px\">Crear Evento</h4>\n");
      out.write("\n");
      out.write("                                <br>\n");
      out.write("                                <div class=\"row\">\n");
      out.write("                                    <div class=\"input-field col s10\">\n");
      out.write("                                        <input value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${stitulo}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" id=\"txtNombre\" name=\"txtTitulo\" type=\"text\">\n");
      out.write("                                        <label class=\"active\" for=\"txtTitulo\">Titulo</label>\n");
      out.write("                                    </div>                     \n");
      out.write("                                    <div class=\"input-field col s10\">\n");
      out.write("                                        <textarea id=\"txtCuerpo\" name=\"txtCuerpo\" class=\"materialize-textarea\" data-length=\"255\"></textarea>\n");
      out.write("                                        <label for=\"txtCuerpo\">Descripción de evento</label>\n");
      out.write("                                    </div>\n");
      out.write("                                    <div class=\"input-field col s10\">\n");
      out.write("                                        <input  value=\"\" type=\"text\" id=\"txtFechaComienzo\" name=\"txtFechaComienzo\" class=\"datepicker\">\n");
      out.write("                                        <label class=\"active\" for=\"txtFechaComienzo\">Fecha de comienzo de evento</label>\n");
      out.write("                                    </div>\n");
      out.write("                                </div>\n");
      out.write("\n");
      out.write("                                <div class=\"row\">\n");
      out.write("                                    <div class=\"input-field col s10\">\n");
      out.write("                                        <input class=\"timepicker\" value=\"\" id=\"txtHoraComienzo\" name='txtHoraComienzo' type=\"txt\"  class=\"validate\">\n");
      out.write("                                        <label class=\"active\" for=\"txtHoraComiezo\">Hora de comienzo</label>\n");
      out.write("                                    </div> \n");
      out.write("                                </div>\n");
      out.write("\n");
      out.write("                                <div class=\"row\">\n");
      out.write("                                    <div class=\"input-field col s10\">\n");
      out.write("                                        <input  value=\"\" type=\"text\" id=\"txtFechaTermino\" name=\"txtFechaTermino\" class=\"datepicker\">\n");
      out.write("                                        <label class=\"active\" for=\"txtFechaTermino\">Fecha de termino de evento</label>\n");
      out.write("                                    </div>\n");
      out.write("                                </div>\n");
      out.write("\n");
      out.write("                                <div class=\"row\">\n");
      out.write("                                    <div class=\"input-field col s10\">\n");
      out.write("                                        <input class=\"timepicker\"  value=\"\" type=\"text\" id=\"txtHoraTermino\" name=\"txtHoraTermino\" class=\"datepicker\">\n");
      out.write("                                        <label class=\"active\" for=\"txtHoraTermino\">Hora de termino de evento</label>\n");
      out.write("                                    </div>\n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"row\">\n");
      out.write("                                    <p>Tipo de privacidad del evento</p>\n");
      out.write("                                    <p>\n");
      out.write("                                        <label>\n");
      out.write("                                            <input id=\"esPublico\" name=\"group1\" type=\"radio\" checked value=\"1\" />\n");
      out.write("                                            <span>Publico</span>\n");
      out.write("                                        </label>\n");
      out.write("                                    </p>\n");
      out.write("                                    <p>\n");
      out.write("                                        <label>\n");
      out.write("                                            <input id=\"esPrivado\" name=\"group1\" type=\"radio\" value=\"0\" />\n");
      out.write("                                            <span>Privado</span>\n");
      out.write("                                        </label>\n");
      out.write("                                    </p>\n");
      out.write("\n");
      out.write("                                </div>\n");
      out.write("                                <div style=\"padding-bottom: 30px\" class=\"row\">\n");
      out.write("                                    <div class=\"col s12 center\">\n");
      out.write("                                        <button class=\"btn waves-effect waves-light light-blue\" type=\"submit\" name=\"btnCreacionEvento\">Enviar</button>  \n");
      out.write("\n");
      out.write("                                    </div>\n");
      out.write("                                </div>\n");
      out.write("\n");
      out.write("                            </div> \n");
      out.write("                        </form> \n");
      out.write("                    </div>\n");
      out.write("\n");
      out.write("                </div> \n");
      out.write("            </section>\n");
      out.write("        </main>\n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "footer.jsp", out, false);
      out.write("\n");
      out.write("        <script src=\"js/materialize.js\" type=\"text/javascript\"></script>\n");
      out.write("        <script src=\"js/inicializadorMaterialize.js\" type=\"text/javascript\"></script>\n");
      out.write("\n");
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
