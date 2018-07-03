package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import modelo.Publicacion;
import java.util.LinkedList;
import modelo.DAOPublicacion;
import modelo.DAOPerfil;
import modelo.Perfil;
import modelo.DAOUsuario;
import modelo.Usuario;

public final class modificarPerfil_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");
      out.write("\n");

    /*
    try {
        if (session.getAttribute("user") == null) {
        response.sendRedirect("login.jsp");
        }  
        } catch (Exception e) {
            out.print(e.getMessage());
        }
    
    DAOUsuario dao = new DAOUsuario();
    DAOPerfil dao2 = new DAOPerfil();
    DAOPublicacion dao3 = new DAOPublicacion();
    Usuario usuarioLocal = (Usuario) request.getAttribute("usuarioclase");
    Perfil PerfilLocal = (Perfil) request.getAttribute("perfil");    
    LinkedList<Publicacion> listado = (LinkedList) request.getAttribute("listaPublicaciones");
    
    if (usuarioLocal == null) {
            if (dao.consultar() != null && session.getAttribute("user") != null ) {
                boolean vs = false;
                    for (Usuario elem : dao.consultar()) {
                        
                            if (elem.getNombreUsuario().equals(session.getAttribute("user"))) {
                                    usuarioLocal = elem;
                                    System.out.println(elem.getIdUsuario());
                                    vs = true;
                                    break;
                                }else{
                                vs = false;
                            }
                        }
                    if (vs) {
                          System.out.println("No se consiguio cargar el usuario");  
                        }
                }
        }
        if (PerfilLocal == null && usuarioLocal != null) {
        PerfilLocal = dao2.seleccionarPerfil(usuarioLocal.getIdUsuario());
        listado = dao3.seleccionarEventos(usuarioLocal.getIdUsuario());
        if (PerfilLocal == null) {
                System.out.println("Error no se consigue ningun perfil o esta mala la query");
            }else{
            //PerfilLocal = ps;
        }
        
        }
     */
    String respuesta = (String) request.getAttribute("srespuesta");
    String errores = (String) request.getAttribute("serrores");
    String nombre = (String) request.getAttribute("snombre");
    String usuario = (String) request.getAttribute("susuario");
    String email = (String) request.getAttribute("semail");
    String biografia = (String) request.getAttribute("sbiografia");
    String fechaNacimiento = request.getParameter("sfnacimiento");
    String idpersonal = request.getParameter("sidpersonal");
    String divError = "<div class='card-panel  grey darken-4 white-text text-darken-2'>";
    String divErrortitle = "<h5>Se han encontrado errores</h5>";
    String divError2 = "</div>";

    if (errores == null) {
        errores = "";
    }
    if (nombre == null) {
        nombre = "";
    }
    if (biografia == null) {
        biografia = "";
    }
    if (idpersonal == null) {
        idpersonal = "";
    }
    if (usuario == null) {
        usuario = "";
    }
    if (fechaNacimiento == null) {
        fechaNacimiento = "";
    }
    if (respuesta == null) {
        respuesta = "";
    }
    if (email == null) {
        email = "";
    }


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
      out.write("                    <div class=\"col s12 m4 l3 center\" onload=\"myFunction()\"> <!-- Note that \"m4 l3\" was added -->\n");
      out.write("                        <div style=\"padding-top: 50px;\" class=\"row\">\n");
      out.write("                            <img style=\"border: solid black 1px;\" src=\"img/Union 4.png\" class=\"imgPersona circle white\">\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"row\">\n");
      out.write("                            <h4>User</h4>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"row\">\n");
      out.write("                            <a href=\"\"> Editar foto del perfil</a>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"row\">\n");
      out.write("                            <button style=\"margin-top: 20px; padding: 20px;\" id=\"activado\" class=\"w3-button tablink  col s12\" onclick=\"openLink(event, 'test1')\">Modificar Perfil</button>\n");
      out.write("                              <button style=\"margin-top: 20px; padding: 20px;\" class=\"w3-button tablink  col s12\" onclick=\"openLink(event, 'test2')\">Cambiar Contraseña</button>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("\n");
      out.write("                        <div style=\"display:none; outline: solid #cccccc 1px\" id=\"test1\" class=\"col s12 m8 l9 opciones\"> \n");
      out.write("                            <form action=\"#\" autocomplete=\"off\">\n");
      out.write("                            <div class=\"container\">\n");
      out.write("                                <h4 style=\"margin-top: 50px\">Editar Perfil</h4>\n");
      out.write("\n");
      out.write("                                <br>\n");
      out.write("                                <p>Marque la casilla del campo que desea editar</p>\n");
      out.write("                                <div class=\"row\">\n");
      out.write("                                    <div class=\"input-field col s10\">\n");
      out.write("                                        <input value=\"");
      out.print(nombre);
      out.write("\" id=\"txtnombre\" name=\"txtnombre\" type=\"text\" disabled=\"disabled\">\n");
      out.write("                                        <label class=\"active\" for=\"txtnombre\">Nombre</label>\n");
      out.write("                                    </div>\n");
      out.write("                                    <div  class=\"col s2\">\n");
      out.write("                                        <p>\n");
      out.write("                                            <label>\n");
      out.write("                                                <input id=\"checkNombre\" type=\"checkbox\" />\n");
      out.write("                                                <span></span>\n");
      out.write("                                            </label>\n");
      out.write("                                        </p>\n");
      out.write("                                    </div>                           \n");
      out.write("                                    <div class=\"input-field col s10\">\n");
      out.write("                                        <input value=\"");
      out.print(usuario);
      out.write("\" id=\"txtusuario\" name=\"txtusuario\" type=\"text\" disabled=\"disabled\">\n");
      out.write("                                        <label class=\"active\" for=\"txtusuario\">Usuario</label>\n");
      out.write("                                    </div>\n");
      out.write("                                    <div  class=\"col s2\">\n");
      out.write("                                        <p>\n");
      out.write("                                            <label>\n");
      out.write("                                                <input id=\"checkUsuario\" type=\"checkbox\" />\n");
      out.write("                                                <span></span>\n");
      out.write("                                            </label>\n");
      out.write("                                        </p>\n");
      out.write("                                    </div>  \n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("                                    <div class=\"input-field col s10\">\n");
      out.write("                                        <input value=\"");
      out.print(biografia);
      out.write("\" id=\"txtbiografia\" name=\"txtbiografia\" type=\"text\" disabled=\"disabled\">\n");
      out.write("                                        <label class=\"active\" for=\"txtbiografia\">Biografía</label>\n");
      out.write("                                    </div>\n");
      out.write("                                    <div  class=\"col s2\">\n");
      out.write("                                        <p>\n");
      out.write("                                            <label>\n");
      out.write("                                                <input id=\"checkBiografia\" type=\"checkbox\" />\n");
      out.write("                                                <span></span>\n");
      out.write("                                            </label>\n");
      out.write("                                        </p>\n");
      out.write("                                    </div>  \n");
      out.write("                                </div>\n");
      out.write("\n");
      out.write("                                <h6 style=\"padding-top: 30px\">Información privada</h6>\n");
      out.write("\n");
      out.write("                                <div class=\"row\">\n");
      out.write("                                    <div class=\"input-field col s10\">\n");
      out.write("                                        <input value=\"");
      out.print(email);
      out.write("\" id=\"txtemail\" name='txtemail' type=\"email\" disabled=\"disabled\" class=\"validate\">\n");
      out.write("                                        <label class=\"active\" for=\"txtemail\">Correo</label>\n");
      out.write("                                    </div>\n");
      out.write("                                    <div  class=\"col s2\">\n");
      out.write("                                        <p>\n");
      out.write("                                            <label>\n");
      out.write("                                                <input id=\"checkEmail\" type=\"checkbox\" />\n");
      out.write("                                                <span></span>\n");
      out.write("                                            </label>\n");
      out.write("                                        </p>\n");
      out.write("                                    </div>  \n");
      out.write("                                </div>\n");
      out.write("\n");
      out.write("                                <div class=\"row\">\n");
      out.write("                                    <div class=\"input-field col s10\">\n");
      out.write("                                        <input value=\"");
      out.print(idpersonal);
      out.write("\" id=\"txtidpersonal\" name=\"txtidpersonal\" type=\"text\"disabled=\"disabled\">\n");
      out.write("                                        <label class=\"active\" for=\"txtidpersonal\">Identificación</label>\n");
      out.write("                                    </div>\n");
      out.write("                                    <div  class=\"col s2\">\n");
      out.write("                                        <p>\n");
      out.write("                                            <label>\n");
      out.write("                                                <input id=\"checkIdPersonal\" type=\"checkbox\" />\n");
      out.write("                                                <span></span>\n");
      out.write("                                            </label>\n");
      out.write("                                        </p>\n");
      out.write("                                    </div> \n");
      out.write("                                </div>\n");
      out.write("\n");
      out.write("                                <div class=\"row\">\n");
      out.write("                                    <div class=\"input-field col s10\">\n");
      out.write("                                        <input  value=\"");
      out.print(fechaNacimiento);
      out.write("\" type=\"text\" id=\"txtfechanacimiento\" disabled=\"disabled\" name=\"txtfechanacimiento\" class=\"datepicker\">\n");
      out.write("                                        <label class=\"active\" for=\"txtfechanacimiento\">Fecha Nacimiento</label>\n");
      out.write("                                    </div>\n");
      out.write("                                    <div  class=\"col s1\">\n");
      out.write("                                        <p>\n");
      out.write("                                            <label>\n");
      out.write("                                                <input id=\"checkFechaNacimiento\" type=\"checkbox\" />\n");
      out.write("                                                <span></span>\n");
      out.write("                                            </label>\n");
      out.write("                                        </p>\n");
      out.write("                                    </div>  \n");
      out.write("                                </div>\n");
      out.write("                                <div style=\"padding-bottom: 30px\" class=\"row\">\n");
      out.write("                                    <div class=\"col s12 center\">\n");
      out.write("                                        <button class=\"btn waves-effect waves-light light-blue\" type=\"submit\" name=\"btnModificarPerfil\">Enviar</button>  \n");
      out.write("\n");
      out.write("                                    </div>\n");
      out.write("                                </div>\n");
      out.write("\n");
      out.write("                            </div> \n");
      out.write("                    </form> \n");
      out.write("                        </div>\n");
      out.write("                                        \n");
      out.write("                        <div style=\"display:none; outline: solid #cccccc 1px\" id=\"test2\" class=\"col s12 m8 l9 opciones\"> \n");
      out.write("                            <form action=\"#\" autocomplete=\"off\">\n");
      out.write("                            <div class=\"container\">\n");
      out.write("                                <h4 style=\"margin-top: 50px\">Cambiar Contraseña</h4>\n");
      out.write("                                <br>\n");
      out.write("                                <div class=\"row\">\n");
      out.write("                                    <div class=\"input-field col s10\">\n");
      out.write("                                        <input id=\"txtnombre\" name=\"txtnombre\" type=\"text\">\n");
      out.write("                                        <label class=\"active\" for=\"txtnombre\">Contraseña actual</label>\n");
      out.write("                                    </div>                        \n");
      out.write("                                    <div class=\"input-field col s10\">\n");
      out.write("                                        <input id=\"txtusuario\" name=\"txtusuario\" type=\"text\">\n");
      out.write("                                        <label class=\"active\" for=\"txtusuario\">Nueva Contraseña</label>\n");
      out.write("                                    </div>\n");
      out.write("                                    <div class=\"input-field col s10\">\n");
      out.write("                                        <input id=\"txtbiografia\" name=\"txtbiografia\" type=\"text\">\n");
      out.write("                                        <label class=\"active\" for=\"txtbiografia\">Repetir Contraseña</label>\n");
      out.write("                                    </div>\n");
      out.write("                                </div>\n");
      out.write("                                <div style=\"padding-bottom: 30px\" class=\"row\">\n");
      out.write("                                    <div class=\"col s12 center\">\n");
      out.write("                                        <button class=\"btn waves-effect waves-light light-blue\" type=\"submit\" name=\"btnModificarPerfil\">Enviar</button>  \n");
      out.write("\n");
      out.write("                                    </div>\n");
      out.write("                                </div>\n");
      out.write("\n");
      out.write("                            </div> \n");
      out.write("                    </form> \n");
      out.write("                        </div>\n");
      out.write("\n");
      out.write("                   \n");
      out.write("                </div> \n");
      out.write("            </section>\n");
      out.write("        </main>\n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "footer.jsp", out, false);
      out.write("\n");
      out.write("        <script src=\"js/materialize.js\" type=\"text/javascript\"></script>\n");
      out.write("        <script src=\"js/inicializadorMaterialize.js\" type=\"text/javascript\"></script>\n");
      out.write("        <script>\n");
      out.write("            document.getElementById('checkNombre').onchange = function () {\n");
      out.write("                document.getElementById('txtnombre').disabled = !this.checked;\n");
      out.write("            };\n");
      out.write("            document.getElementById('checkUsuario').onchange = function () {\n");
      out.write("                document.getElementById('txtusuario').disabled = !this.checked;\n");
      out.write("            };\n");
      out.write("            document.getElementById('checkBiografia').onchange = function () {\n");
      out.write("                document.getElementById('txtbiografia').disabled = !this.checked;\n");
      out.write("            };\n");
      out.write("            document.getElementById('checkEmail').onchange = function () {\n");
      out.write("                document.getElementById('txtemail').disabled = !this.checked;\n");
      out.write("            };\n");
      out.write("            document.getElementById('checkFechaNacimiento').onchange = function () {\n");
      out.write("                document.getElementById('txtfechanacimiento').disabled = !this.checked;\n");
      out.write("            };\n");
      out.write("            document.getElementById('checkIdPersonal').onchange = function () {\n");
      out.write("                document.getElementById('txtidpersonal').disabled = !this.checked;\n");
      out.write("            };\n");
      out.write("        </script>\n");
      out.write("        <script>\n");
      out.write("            function openLink(evt, animName) {\n");
      out.write("              var i, x, tablinks;\n");
      out.write("              x = document.getElementsByClassName(\"opciones\");\n");
      out.write("              for (i = 0; i < x.length; i++) {\n");
      out.write("                 x[i].style.display = \"none\";\n");
      out.write("              }\n");
      out.write("              tablinks = document.getElementsByClassName(\"tablink\");\n");
      out.write("              for (i = 0; i < x.length; i++) {\n");
      out.write("                 tablinks[i].className = tablinks[i].className.replace(\" w3-blue\", \"\");\n");
      out.write("              }\n");
      out.write("              document.getElementById(animName).style.display = \"block\";\n");
      out.write("              evt.currentTarget.className += \" w3-blue\";\n");
      out.write("            }\n");
      out.write("            function myFunction(evt) {\n");
      out.write("                x = document.getElementById(\"activado\");\n");
      out.write("                x.className + =\" w3-blue\";\n");
      out.write("            }\n");
      out.write("        </script>\n");
      out.write("\n");
      out.write("    </body>\n");
      out.write("</html>");
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
