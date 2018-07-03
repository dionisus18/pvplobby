package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import modelo.Evento;
import java.util.LinkedList;

public final class feed_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_forEach_var_items;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_if_test;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_f_if_test;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_h_if_test;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_b_forEach_var_items;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_b_if_test;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_c_forEach_var_items = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_c_if_test = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_f_if_test = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_h_if_test = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_b_forEach_var_items = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_b_if_test = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_c_forEach_var_items.release();
    _jspx_tagPool_c_if_test.release();
    _jspx_tagPool_f_if_test.release();
    _jspx_tagPool_h_if_test.release();
    _jspx_tagPool_b_forEach_var_items.release();
    _jspx_tagPool_b_if_test.release();
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

      out.write('\r');
      out.write('\n');

if (request.getAttribute("listPublicacion") == null) {
        response.sendRedirect("SERVFeed");
    }

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("    <head>\r\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("        <title>Feed ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${user}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write(" </title>\r\n");
      out.write("        <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js\"></script>\r\n");
      out.write("        <!--Import Google Icon Font-->\r\n");
      out.write("        <link href=\"https://fonts.googleapis.com/icon?family=Material+Icons\" rel=\"stylesheet\">\r\n");
      out.write("        <!--Import materialize.css-->\r\n");
      out.write("        <link href=\"css/materialize.min.css\" rel=\"stylesheet\" type=\"text/css\"/>         \r\n");
      out.write("        <!--Let browser know website is optimized for mobile-->\r\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\"/>\r\n");
      out.write("        <link href=\"css/Style.css\" rel=\"stylesheet\" type=\"text/css\"/>\r\n");
      out.write("    </head>\r\n");
      out.write("    <body class=\"grey lighten-5\">\r\n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "header.jsp", out, false);
      out.write("\r\n");
      out.write("        <main>\r\n");
      out.write("            <section>\r\n");
      out.write("                <!-- Division de contenido en filas/columnas -->\r\n");
      out.write("                <div class=\"row\">\r\n");
      out.write("                    <!-- nota: style=\"position: fixed; bottom: 0%; top: 0%; padding-top: 100px;\" -->\r\n");
      out.write("                    <!-- nota: style=\"overflow-y: scroll; height: 100%;\" -->\r\n");
      out.write("\r\n");
      out.write("                    <!-- ***************** Contenido de usuario + miniFooter ****************** -->\r\n");
      out.write("                    <div style=\"padding-top: 30px; position: fixed;\"  class=\"col l2 m2 s12 center-align hide-on-small-and-down\">\r\n");
      out.write("                        <div>\r\n");
      out.write("                            <img style=\"border: solid 1px black;\" class=\"circle responsive-img white\" src=\"img/Union 4.png\" alt=\"\"/>\r\n");
      out.write("                            <h6>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${user}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</h6>\r\n");
      out.write("                            ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "miniFooter.jsp", out, false);
      out.write("    \r\n");
      out.write("                        </div>    \r\n");
      out.write("                    </div>\r\n");
      out.write("\r\n");
      out.write("                    <!-- Espacio de relleno -->\r\n");
      out.write("                    <div class=\"col l4 m4 s12\" ></div>\r\n");
      out.write("\r\n");
      out.write("                    <!-- **********************Contenido principal ********************** -->\r\n");
      out.write("                    <div class=\"col l4 m4 s12 center-align\">\r\n");
      out.write("\r\n");
      out.write("                        <div class=\"row\">\r\n");
      out.write("                            <div class=\"col l12\">\r\n");
      out.write("                                <ul class=\"tabs\">\r\n");
      out.write("                                    <li class=\"tab col s6\"><a class=\"active\" href=\"#contenidoEvento\">Eventos</a></li>\r\n");
      out.write("                                    <li class=\"tab col s6\"><a href=\"#contenidoPublicacion\">Publicaciones</a></li>  \r\n");
      out.write("                                </ul>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </div>\r\n");
      out.write("\r\n");
      out.write("                        <div class=\"row\">\r\n");
      out.write("                            <div id=\"contenidoEvento\" class=\"col s12\">\r\n");
      out.write("                                <div class=\"card-panel\">\r\n");
      out.write("                                    <form id=\"frmEvento\" action=\"SERVCrearEvento\" method=\"POST\">\r\n");
      out.write("                                        <div class=\"input-field\">\r\n");
      out.write("                                            <input id=\"etitulo\" name='etitulo' type=\"text\" class=\"validate\">\r\n");
      out.write("                                            <label for=\"etitulo\">Titulo de evento</label>\r\n");
      out.write("                                        </div>\r\n");
      out.write("                                        <div class=\"input-field right-align\">\r\n");
      out.write("                                            <button class=\"btn waves-effect waves-light blue accent-3\" type=\"submit\" name=\"btnCrearEvento\">Crear Evento\r\n");
      out.write("                                            </button>         \r\n");
      out.write("                                        </div>\r\n");
      out.write("                                    </form>\r\n");
      out.write("                                        \r\n");
      out.write("                                    ");
      if (_jspx_meth_h_if_0(_jspx_page_context))
        return;
      out.write("  \r\n");
      out.write("                                </div>\r\n");
      out.write("\r\n");
      out.write("                                \r\n");
      out.write("                                ");
      if (_jspx_meth_c_if_0(_jspx_page_context))
        return;
      out.write("    \r\n");
      out.write("\r\n");
      out.write("                            </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("                                \r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("                            ");
      if (_jspx_meth_h_if_1(_jspx_page_context))
        return;
      out.write("    \r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("                        </div>\r\n");
      out.write("                        <div id=\"contenidoPublicacion\" class=\"col s12\">\r\n");
      out.write("                            <div class=\"card-panel\">\r\n");
      out.write("                                <form id=\"frmPublicaciones\" action=\"SERVCrearEvento\" method=\"POST\">\r\n");
      out.write("                                    <div class=\"input-field\">\r\n");
      out.write("                                        <input id=\"ptitulo\" name='ptitulo' type=\"text\" class=\"validate\">\r\n");
      out.write("                                        <label for=\"ptitulo\">Titulo de publicación</label>\r\n");
      out.write("                                    </div>\r\n");
      out.write("                                    <div class=\"input-field right-align\">\r\n");
      out.write("                                        <button class=\"btn waves-effect waves-light blue accent-3\" type=\"submit\" name=\"btnCrearPublicacion\">Crear Publicacion\r\n");
      out.write("                                        </button>         \r\n");
      out.write("                                    </div>\r\n");
      out.write("                                </form>\r\n");
      out.write("                            </div>\r\n");
      out.write("                            \r\n");
      out.write("                            ");
      if (_jspx_meth_b_if_0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("                            \r\n");
      out.write("                            ");
      if (_jspx_meth_f_if_0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("\r\n");
      out.write("                <!-- Espacio de relleno -->\r\n");
      out.write("                <div class=\"col l4 m4 s12\"></div>\r\n");
      out.write("                </div>\r\n");
      out.write("            </section>\r\n");
      out.write("        </main>\r\n");
      out.write("        <div class=\"hide-on-med-and-up\">\r\n");
      out.write("            ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "footer.jsp", out, false);
      out.write("  \r\n");
      out.write("        </div>\r\n");
      out.write("        <script src=\"js/materialize.min.js\" type=\"text/javascript\"></script>\r\n");
      out.write("        <script src=\"js/inicializadorMaterialize.js\" type=\"text/javascript\"></script>\r\n");
      out.write("    </body>\r\n");
      out.write("</html>\r\n");
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

  private boolean _jspx_meth_h_if_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  h:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_h_if_0 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_h_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_h_if_0.setPageContext(_jspx_page_context);
    _jspx_th_h_if_0.setParent(null);
    _jspx_th_h_if_0.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${errores != null}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null)).booleanValue());
    int _jspx_eval_h_if_0 = _jspx_th_h_if_0.doStartTag();
    if (_jspx_eval_h_if_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("                                        ");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${errores}", java.lang.String.class, (PageContext)_jspx_page_context, null));
        out.write("\r\n");
        out.write("                                    ");
        int evalDoAfterBody = _jspx_th_h_if_0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_h_if_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_h_if_test.reuse(_jspx_th_h_if_0);
      return true;
    }
    _jspx_tagPool_h_if_test.reuse(_jspx_th_h_if_0);
    return false;
  }

  private boolean _jspx_meth_c_if_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_0 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_0.setPageContext(_jspx_page_context);
    _jspx_th_c_if_0.setParent(null);
    _jspx_th_c_if_0.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${listEvento != null}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null)).booleanValue());
    int _jspx_eval_c_if_0 = _jspx_th_c_if_0.doStartTag();
    if (_jspx_eval_c_if_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("                                    ");
        if (_jspx_meth_c_forEach_0((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_if_0, _jspx_page_context))
          return true;
        out.write("\r\n");
        out.write("                                ");
        int evalDoAfterBody = _jspx_th_c_if_0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_if_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_0);
      return true;
    }
    _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_0);
    return false;
  }

  private boolean _jspx_meth_c_forEach_0(javax.servlet.jsp.tagext.JspTag _jspx_th_c_if_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_forEach_0 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _jspx_tagPool_c_forEach_var_items.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_forEach_0.setPageContext(_jspx_page_context);
    _jspx_th_c_forEach_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_if_0);
    _jspx_th_c_forEach_0.setItems((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${listEvento}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    _jspx_th_c_forEach_0.setVar("record");
    int[] _jspx_push_body_count_c_forEach_0 = new int[] { 0 };
    try {
      int _jspx_eval_c_forEach_0 = _jspx_th_c_forEach_0.doStartTag();
      if (_jspx_eval_c_forEach_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n");
          out.write("                                        <div class=\"card-panel\">\r\n");
          out.write("                                            <div class='row'>\r\n");
          out.write("                                                    \r\n");
          out.write("                                                <div class='col s6 left-align'>\r\n");
          out.write("                                                    <form id=\"frm-send\" action=\"SERVPerfilPublico\" method=\"POST\">\r\n");
          out.write("                                                        <input type=\"hidden\" id=\"idUsuario\" name=\"idUsuario\" value=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${record.idUsuario}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\">\r\n");
          out.write("                                                    <button id=\"btnPerfilPublico\" class=\"btn-flat\" type=\"submit\">");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${record.nombreUsuario}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</button>\r\n");
          out.write("                                                    </form>  \r\n");
          out.write("                                                </div>\r\n");
          out.write("                                                <div class=\"col s6 right-align\">\r\n");
          out.write("                                                    ");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${record.fechaCreacion}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\r\n");
          out.write("                                                </div>\r\n");
          out.write("                                            </div>\r\n");
          out.write("                                            <div class=\"row\">\r\n");
          out.write("\r\n");
          out.write("                                            </div>\r\n");
          out.write("                                            <div class=\"row\">\r\n");
          out.write("                                                <div class='col s12 left-align'>\r\n");
          out.write("                                                    <h5>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${record.titulo}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</h5>\r\n");
          out.write("                                                </div>\r\n");
          out.write("                                                <div class='col s12 left-align'>\r\n");
          out.write("                                                    <p class=\"truncate\">\r\n");
          out.write("                                                        ");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${record.cuerpo}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\r\n");
          out.write("                                                    </p>\r\n");
          out.write("                                                </div>\r\n");
          out.write("                                                    <div style=\"margin-bottom: 20px\" class='col s12 left-align'>\r\n");
          out.write("                                                    <h5>Comienza el ");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${record.fechaComienzo}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write(" a las ");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${record.horaInicio}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write(" Horas </h5>\r\n");
          out.write("                                                </div>\r\n");
          out.write("                                                <div class=\"col s6 left-align\">\r\n");
          out.write("                                                   <a class=\"btn-floating btn-flat waves-effect waves-red grey\"><i class=\"material-icons\">favorite_border</i></a>  \r\n");
          out.write("                                                </div>\r\n");
          out.write("                                                <div class=\"col s6 right-align\">\r\n");
          out.write("                                                    <a class=\"btn-floating btn-flat waves-effect waves-purple grey\"><i class=\"material-icons\">comment</i></a>\r\n");
          out.write("                                                </div>\r\n");
          out.write("                                            </div>\r\n");
          out.write("                                        </div>      \r\n");
          out.write("                                    ");
          int evalDoAfterBody = _jspx_th_c_forEach_0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_forEach_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_forEach_0[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_forEach_0.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_forEach_0.doFinally();
      _jspx_tagPool_c_forEach_var_items.reuse(_jspx_th_c_forEach_0);
    }
    return false;
  }

  private boolean _jspx_meth_h_if_1(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  h:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_h_if_1 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_h_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_h_if_1.setPageContext(_jspx_page_context);
    _jspx_th_h_if_1.setParent(null);
    _jspx_th_h_if_1.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${listEvento == null}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null)).booleanValue());
    int _jspx_eval_h_if_1 = _jspx_th_h_if_1.doStartTag();
    if (_jspx_eval_h_if_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("                                <h5>No hay registros de Eventos, Empieza tu mismo a compartir ahora!</h5>\r\n");
        out.write("                            ");
        int evalDoAfterBody = _jspx_th_h_if_1.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_h_if_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_h_if_test.reuse(_jspx_th_h_if_1);
      return true;
    }
    _jspx_tagPool_h_if_test.reuse(_jspx_th_h_if_1);
    return false;
  }

  private boolean _jspx_meth_b_if_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  b:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_b_if_0 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_b_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_b_if_0.setPageContext(_jspx_page_context);
    _jspx_th_b_if_0.setParent(null);
    _jspx_th_b_if_0.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${listPublicacion != null}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null)).booleanValue());
    int _jspx_eval_b_if_0 = _jspx_th_b_if_0.doStartTag();
    if (_jspx_eval_b_if_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("                                <table>\r\n");
        out.write("                                    ");
        if (_jspx_meth_b_forEach_0((javax.servlet.jsp.tagext.JspTag) _jspx_th_b_if_0, _jspx_page_context))
          return true;
        out.write("\r\n");
        out.write("                                </table>\r\n");
        out.write("                            ");
        int evalDoAfterBody = _jspx_th_b_if_0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_b_if_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_b_if_test.reuse(_jspx_th_b_if_0);
      return true;
    }
    _jspx_tagPool_b_if_test.reuse(_jspx_th_b_if_0);
    return false;
  }

  private boolean _jspx_meth_b_forEach_0(javax.servlet.jsp.tagext.JspTag _jspx_th_b_if_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  b:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_b_forEach_0 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _jspx_tagPool_b_forEach_var_items.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_b_forEach_0.setPageContext(_jspx_page_context);
    _jspx_th_b_forEach_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_b_if_0);
    _jspx_th_b_forEach_0.setItems((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${listPublicacion}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    _jspx_th_b_forEach_0.setVar("record");
    int[] _jspx_push_body_count_b_forEach_0 = new int[] { 0 };
    try {
      int _jspx_eval_b_forEach_0 = _jspx_th_b_forEach_0.doStartTag();
      if (_jspx_eval_b_forEach_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n");
          out.write("                                            <div class=\"card-panel\">\r\n");
          out.write("                                            <div class='row'>\r\n");
          out.write("                                                    \r\n");
          out.write("                                                <div class='col s6 left-align'>\r\n");
          out.write("                                                    <form id=\"frm-send\" action=\"SERVPerfilPublico\" method=\"POST\">\r\n");
          out.write("                                                    <input type=\"hidden\" name=\"idUsuario\" value=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${record.usuario_IdUsuario}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\">\r\n");
          out.write("                                                    <button class=\"btn-flat\" type=\"submit\" value=\"\">");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${record.nombreUsuario}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</button>\r\n");
          out.write("                                                    </form>  \r\n");
          out.write("                                                </div>\r\n");
          out.write("                                            </div>\r\n");
          out.write("                                            <div class=\"row\">\r\n");
          out.write("\r\n");
          out.write("                                            </div>\r\n");
          out.write("                                            <div class=\"row\">\r\n");
          out.write("                                                <div class='col s12 left-align'>\r\n");
          out.write("                                                    <h5>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${record.titulo}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</h5>\r\n");
          out.write("                                                </div>\r\n");
          out.write("                                                <div style=\"margin-bottom: 30px\" class='col s12 left-align'>\r\n");
          out.write("                                                    <p class=\"truncate\">\r\n");
          out.write("                                                        ");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${record.cuerpo}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\r\n");
          out.write("                                                    </p>\r\n");
          out.write("                                                </div>\r\n");
          out.write("                                                <div class=\"col s6 left-align\">\r\n");
          out.write("                                                   <a class=\"btn-floating btn-flat waves-effect waves-red grey\"><i class=\"material-icons\">favorite_border</i></a>  \r\n");
          out.write("                                                </div>\r\n");
          out.write("                                                <div class=\"col s6 right-align\">\r\n");
          out.write("                                                    <a class=\"btn-floating btn-flat waves-effect waves-purple grey\"><i class=\"material-icons\">comment</i></a>\r\n");
          out.write("                                                </div>\r\n");
          out.write("                                            </div>\r\n");
          out.write("                                        </div>      \r\n");
          out.write("                                    ");
          int evalDoAfterBody = _jspx_th_b_forEach_0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_b_forEach_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_b_forEach_0[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_b_forEach_0.doCatch(_jspx_exception);
    } finally {
      _jspx_th_b_forEach_0.doFinally();
      _jspx_tagPool_b_forEach_var_items.reuse(_jspx_th_b_forEach_0);
    }
    return false;
  }

  private boolean _jspx_meth_f_if_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  f:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_f_if_0 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_f_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_f_if_0.setPageContext(_jspx_page_context);
    _jspx_th_f_if_0.setParent(null);
    _jspx_th_f_if_0.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${listPublicacion == null}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null)).booleanValue());
    int _jspx_eval_f_if_0 = _jspx_th_f_if_0.doStartTag();
    if (_jspx_eval_f_if_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("                                <h5>No hay registros de publicaciones, Empieza tu mismo a compartir ahora!</h5>\r\n");
        out.write("                            ");
        int evalDoAfterBody = _jspx_th_f_if_0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_f_if_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_f_if_test.reuse(_jspx_th_f_if_0);
      return true;
    }
    _jspx_tagPool_f_if_test.reuse(_jspx_th_f_if_0);
    return false;
  }
}
