package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
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


    String respuesta = (String) request.getAttribute("srespuesta");
    String errores = (String) request.getAttribute("serrores");
    String nombre = (String) request.getAttribute("snombre");
    String usuario = (String) request.getAttribute("susuario");
    String email = (String) request.getAttribute("semail");
    String pass = request.getParameter("spass");
    String pass2 = request.getParameter("spass2");
    String divError = "<div class='card-panel  grey darken-4 white-text text-darken-2'>";
    String divErrortitle = "<h5>Se han encontrado errores</h5>";
    String divError2 = "</div>";

    if (errores == null) {
        errores = "";
    }
    if (nombre == null) {
        nombre = "";
    }
    if (pass == null) {
        pass = "";
    }
    if (pass2 == null) {
        pass2 = "";
    }
    if (usuario == null) {
        usuario = "";
    }
    if (respuesta == null) {
        respuesta = "";
    }
    if (email == null) {
        email = "";
    }
    if (session.getAttribute("user") == null) {
            
    }else{
        response.sendRedirect("perfil.jsp");
    }

      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("\n");
      out.write("        <title>PvPLobby</title>\n");
      out.write("        <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js\"></script>\n");
      out.write("        <!--Import Google Icon Font-->\n");
      out.write("        <link href=\"https://fonts.googleapis.com/icon?family=Material+Icons\" rel=\"stylesheet\">\n");
      out.write("        <!--Import materialize.css-->\n");
      out.write("        <link href=\"css/materialize.min.css\" rel=\"stylesheet\" type=\"text/css\"/>         \n");
      out.write("        <!--Let browser know website is optimized for mobile-->\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\"/>\n");
      out.write("        <link href=\"css/Style.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("        <script src=\"js/validacionRegistro.js\" type=\"text/javascript\"></script>\n");
      out.write("    </head>\n");
      out.write("    <body class=\"grey lighten-4\">\n");
      out.write("        <header>\n");
      out.write("            <nav>\n");
      out.write("                <div class=\"nav-wrapper grey darken-4\">\n");
      out.write("                    <a href=\"index.jsp\" class=\"brand-logo\">PVPLobby</a>\n");
      out.write("                    <ul id=\"nav-mobile\" class=\"right hide-on-med-and-down\">\n");
      out.write("                        <li><a href=\"login.jsp\"><i class=\"material-icons\">account_box</i></a></li>\n");
      out.write("                    </ul>\n");
      out.write("                </div>\n");
      out.write("            </nav>\n");
      out.write("        </header>\n");
      out.write("        <main>\n");
      out.write("            <section class=\"container\">\n");
      out.write("                <div class=\"row\">\n");
      out.write("                    <div class=\"col m4 l1 hide-on-med-and-down\"><p>s12 m4</p></div>\n");
      out.write("                    <div class=\"col s12 m12 l10\">\n");
      out.write("                        <table class=\"striped\">\n");
      out.write("                            <tr></tr>\n");
      out.write("                            <tr>\n");
      out.write("                                <td class=\"hide-on-small-and-down\"> \n");
      out.write("                                    <img class=\"responsive-img\" src=\"img/Logo PvP Lobby.png\" alt=\"logopvplobby\"/>\n");
      out.write("                                </td>\n");
      out.write("                                <td class=\"col l8 m12 s12\">\n");
      out.write("\n");
      out.write("                                    <form id='registro' action=\"SERVUsuario\" method=\"POST\" autocomplete=\"off\">\n");
      out.write("                                        <div class=\"row card-panel white\">\n");
      out.write("                                            <h4 class=\"center-align col s12\">Registro</h4>\n");
      out.write("                                            <p class=\"center-align col s12 \">Registrese para empezar a interactuar con la comunidad y explorar eventos</p>\n");
      out.write("                                            <div class=\"input-field col s12\">\n");
      out.write("                                                <input id=\"usuario\" name='usuario' type=\"text\" class=\"validate\" value=\"");
      out.print(usuario);
      out.write("\">\n");
      out.write("                                                <label for=\"usuario\">Usuario</label>\n");
      out.write("                                            </div>\n");
      out.write("                                            <div class=\"input-field col s12\">\n");
      out.write("                                                <input id=\"nombre\" name='nombre' type=\"text\" class=\"validate\" value=\"");
      out.print(nombre);
      out.write("\">\n");
      out.write("                                                <label for=\"nombre\">Nombre</label>\n");
      out.write("\n");
      out.write("                                            </div>\n");
      out.write("                                            <div class=\"input-field col s12\">\n");
      out.write("                                                <input id=\"email\" name='email' type=\"email\" class=\"validate\" value=\"");
      out.print(email);
      out.write("\">\n");
      out.write("                                                <label for=\"email\">Correo Electrónico</label>\n");
      out.write("\n");
      out.write("                                            </div>\n");
      out.write("                                            <div class=\"input-field col s12\">\n");
      out.write("                                                <input id=\"pass\" name=\"pass\" type=\"password\" class=\"validate\" value=\"");
      out.print(pass);
      out.write("\">\n");
      out.write("                                                <label for=\"pass\">Contraseña</label>\n");
      out.write("\n");
      out.write("                                            </div>\n");
      out.write("                                            <div class=\"input-field col s12\">\n");
      out.write("                                                <input id=\"pass2\" name=\"pass2\" type=\"password\" class=\"validate\" value=\"");
      out.print(pass2);
      out.write("\">\n");
      out.write("                                                <label for=\"pass2\">Repita Contraseña</label>                                               \n");
      out.write("                                            </div>\n");
      out.write("                                            <div class=\"input-field col s12\">\n");
      out.write("                                                <button class=\"btn waves-effect waves-light blue accent-3 col s12\" type=\"submit\" name=\"btnRegistro\">Registrarse\n");
      out.write("                                                    \n");
      out.write("                                                </button>         \n");
      out.write("\n");
      out.write("                                            </div>\n");
      out.write("                                            <div class=\"input-field center-align col s12\">\n");
      out.write("                                                <p>Al registrarte aceptas nuestras <a href=\"condiciones.jsp\">Condiciones</a></p>\n");
      out.write("                                            </div>\n");
      out.write("                                        </div>     \n");
      out.write("                                    </form>\n");
      out.write("                                    \n");
      out.write("                                </td>\n");
      out.write("                            </tr>\n");
      out.write("                            <tr>\n");
      out.write("                                <td class=\"hide-on-med-and-down\"></td>\n");
      out.write("                                <td class=\"col l8 m12 s12\">\n");
      out.write("                                    <div class=\"center-align\">\n");
      out.write("                                        ");
if (errores != null && !errores.equals("")) {
      out.write("\n");
      out.write("                                        ");
      out.print(divError + divErrortitle + errores + divError2);
      out.write("\n");
      out.write("                                        ");
}
      out.write("    \n");
      out.write("                                    </div>\n");
      out.write("                                </td>\n");
      out.write("                            </tr>\n");
      out.write("                            <tr>\n");
      out.write("                                <td class=\"hide-on-med-and-down\"></td>\n");
      out.write("                                <td class=\"col l8 m12 s12\">\n");
      out.write("                                    <div class=\"card-panel white center-align\">\n");
      out.write("                                        <p>¿Ya Tienes cuenta? <a href=\"login.jsp\">Iniciar Sesion</a></p>\n");
      out.write("                                    </div>\n");
      out.write("                                </td>\n");
      out.write("                            </tr>\n");
      out.write("                        </table>                        \n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"col m4 l1 hide-on-med-and-down\"><p>s12 m4</p></div>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"row\"></div>\n");
      out.write("\n");
      out.write("            </section>\n");
      out.write("        </main>\n");
      out.write("        <footer class=\"page-footer grey lighten-2\">\n");
      out.write("            <div class=\"row container center-align\">\n");
      out.write("                <div class=\"col l4 s12\">\n");
      out.write("                    <a href=\"informacion.jsp\">INFORMACION</a>\n");
      out.write("\n");
      out.write("                </div>\n");
      out.write("                <div class=\"col l4 s12\">\n");
      out.write("                    <a href=\"privacidad.jsp\">POLITICAS Y PRIVACIDAD</a>    \n");
      out.write("                </div>\n");
      out.write("                <div class=\"col l4 s12\">\n");
      out.write("                    <a href=\"condiciones.jsp\">CONDICIONES</a>    \n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("            <div class=\"footer-copyright grey-text text-darken-3 \">\n");
      out.write("                <div class=\"container\">\n");
      out.write("                    © 2018 PvPLobby\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("            </div>\n");
      out.write("        </footer>   \n");
      out.write("\n");
      out.write("        <script src=\"js/materialize.min.js\" type=\"text/javascript\"></script>\n");
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
