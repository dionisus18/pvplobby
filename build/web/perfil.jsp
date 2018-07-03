<%-- 
    Document   : login
    Created on : 19/06/2018, 12:50:56 AM
    Author     : Kevin
--%>

<%@page import="modelo.Publicacion"%>
<%@page import="java.util.LinkedList"%>
<%@page import="modelo.DAOPublicacion"%>
<%@page import="modelo.DAOPerfil"%>
<%@page import="modelo.Perfil"%>
<%@page import="modelo.DAOUsuario"%>
<%@page import="modelo.Usuario"%>

<%
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
        int count= dao3.contador(usuarioLocal.getIdUsuario());
        int seguidores = dao3.seguidores(usuarioLocal.getIdUsuario());
        int seguir = dao3.seguidos(usuarioLocal.getIdUsuario());
        

%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>PvPLobby</title>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <!--Import Google Icon Font-->
        <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
        <!--Import materialize.css-->
        <link href="css/materialize.min.css" rel="stylesheet" type="text/css"/>         
        <!--Let browser know website is optimized for mobile-->
        <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
        <link href="css/Style.css" rel="stylesheet" type="text/css"/>
        <script src="js/validacionRegistro.js" type="text/javascript"></script>
    </head>
    <body class="grey lighten-4">
        <jsp:include page="header.jsp"/>
        <main>
            <section>
                <div class="row" style="padding-top:50px">
                    <div class="col m4 l2 hide-on-med-and-down"></div>
                    <!-- Contenedor de Imagen !-->
                    <div class="col m12 l2 s12 center">
                        <div class="row">
                            <div class="col l12 s12" style="margin-top: 20px">
                                <img style="border: solid 1px black;" src="img/Union 4@2x.png" class="circle white" alt=""/>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col l12 s12">
                                  <a class="waves-effect waves-light btn modal-trigger white red-text" href="#modal1">Cerrar Sesíon</a> 
                            </div>   
                        </div>
                    </div>
                    <!-- Contenedor de Datos de Perfil !-->
                    <div class="col s12 m12 l4">
                        <div class="row valign-wrapper">
                            <div class="col l12" style="padding-left: 40px;">
                                <h5><%=session.getAttribute("user")%></h5>
                            </div> 
                            <div class="col l12" style="padding-top: 10px;">
                                <form action="SERVModificarPerfil" method="post">
                                <button class="btn waves-effect waves-light blue accent-3" type="submit" name="btnEditarPerfil">Editar Perfil
                                </button>    
                                </form>
                                
                            </div> 
                        </div>
                        <div class="row">
                            <div class="col l4 m4 s12 flow-text">
                                <h6>Publicaciones</h6>
                                <h6> <%= count %></h6>
                            </div>
                            <div class="col l4 m4 s12 flow-text">
                                <h6>Seguidores</h6>
                                <h6> <%= seguidores %></h6>
                            </div> 
                            <div class="col l4 m4 s12 flow-text">
                                <h6>Seguidos</h6>
                                <h6> <%= seguir %></h6>
                            </div> 
                        </div>
                            <div class="row">
                            <div class="col l12 m12 s12 flow-text">
                                <h5><%= PerfilLocal.getNombre() %></h5>
                            </div>
                            <div class="col l12 m12 s12 flow-text">
                                <h5>Biografía</h5>
                                <h6><%= PerfilLocal.getBiografia() %></h6>
                            </div> 
                                
                            </div>
                    </div>
                    <div class="col  l2 hide-on-med-and-down"></div>
                    <div class="col m4 l2 hide-on-med-and-down"></div>
                </div>
                <div class="row">
                    <div class="col m4 l2 hide-on-med-and-down"></div>
                    <div class="col s12 m12 l8">
                          <div class="row">
                            <div>
                              <ul class="tabs tabs-fixed-width tab-demo z-depth-1">
                                <li class="tab col l6 grey lighten-4 grey-text text-darken-4"><a href="#eventos">Eventos</a></li>
                                <li class="tab col l6 grey lighten-4 grey-text text-darken-4"><a class="active" href="#publicaciones">Publicaciones</a></li>
                              </ul>
                            </div>
                            <div id="eventos" class="col s12">
                                Test 1
                            </div>
                            <div id="publicaciones" class="col s12">
                                                               <form>
                                <table>
                                    <% if(listado != null){ 
                                                                            
                                        for(Publicacion elem : listado){ count++; %> 
                                    <tr>
                                   
                                        <td class="col s3"><div ><%=elem.getTitulo() %></div></td>
                                        <td class="col s6"><div ><%=elem.getCuerpo() %></div></td>
                                        <td class="col s3"><div><a class="waves-effect waves-light btn" href=<%= "\"detalle.jsp?Id=" + elem.getIdPublicacion() + "\"" %> ><%= elem.getIdPublicacion()%></a>
                                            </div></td>
                                       
                                    </tr>
                                       
                                <%}%>
                                <%}%>
                                </table>
                                 </form>
                                       
                                       
                                        
                                    
                            </div>
                          </div>                       
                    </div>
                    <div class="col m4 l2 hide-on-med-and-down"></div>
                </div>
                    
                <!-- Modal Structure -->
                <div id="modal1" class="modal">
                  <div class="modal-content">
                    <h4>Cerrar Sesíon</h4>
                    <p>¿Esta Seguro que desea cerrar la sesíon?</p>
                    <p>Si lo hace, sera redirigido a la pagina de inicio</p>
                    <p>¿Desea proceder?</p>
                  </div>
                  <div class="modal-footer">
                      <a href="logout.jsp" class="modal-close waves-effect waves-green btn-flat">Si, Cerrar Sesión</a>
                      <a href="#!" class="modal-close waves-effect waves-green btn-flat">No, Volver</a>
                  </div>
                </div>

            </section>
        </main>
        <jsp:include page="footer.jsp"/>
        <script src="js/materialize.min.js" type="text/javascript"></script>
        <script src="js/inicializadorMaterialize.js" type="text/javascript"></script>
    </body>
</html>