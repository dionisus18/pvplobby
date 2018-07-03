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
        if (request.getAttribute("sperfil") == null) {
              response.sendRedirect("perfil.jsp");  
            }
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
                    </div>
                    <!-- Contenedor de Datos de Perfil !-->
                    <div class="col s12 m12 l4">
                        <div class="row valign-wrapper">
                            <div class="col l12" style="padding-left: 40px;">
                                <h5>${puser.nombre}</h5>
                            </div> 
                            <div class="col l12" style="padding-top: 10px;">
                                <form action="SERVPerfilPublico" method="post">
                                <button class="btn waves-effect waves-light blue accent-3" type="submit" name="btnEditarPerfil">Seguir
                                </button>    
                                </form>   
                            </div> 
                        </div>
                        <div class="row">
                            <div class="col l4 m4 s12 flow-text">
                                <h6>Publicaciones</h6>
                                <h6>${spublicaciones}</h6>
                            </div>
                            <div class="col l4 m4 s12 flow-text">
                                <h6>Seguidores</h6>
                                <h6> ${sseguidores}</h6>
                            </div> 
                            <div class="col l4 m4 s12 flow-text">
                                <h6>Seguidos</h6>
                                <h6> ${sseguidos}</h6>
                            </div> 
                        </div>
                            <div class="row">
                            <div class="col l12 m12 s12 flow-text">
                                <h5>${sperfil.nombre}</h5>
                            </div>
                            <div class="col l12 m12 s12 flow-text">
                                <h5>Biografía</h5>
                                <h6>${sperfil.biografia}</h6>
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
                            <%@ taglib prefix="b" uri="http://java.sun.com/jsp/jstl/core"%>                                   
                            <b:if test="${listPublicacion != null}">
                                    <b:forEach items="${listPublicacion}" var="record">
                                            <div class="card-panel">
                                            <div class='row'>
                                                    
                                                <div class='col s6 left-align'>
                                                    <form id="frm-send" action="SERVPerfilPublico" method="POST">
                                                    <input type="hidden" name="idUsuario" value="${record.usuario_IdUsuario}">
                                                    <button class="btn-flat" type="submit" value="">${record.nombreUsuario}</button>
                                                    </form>  
                                                </div>
                                            </div>
                                            <div class="row">

                                            </div>
                                            <div class="row">
                                                <div class='col s12 left-align'>
                                                    <h5>${record.titulo}</h5>
                                                </div>
                                                <div style="margin-bottom: 30px" class='col s12 left-align'>
                                                    <p class="truncate">
                                                        ${record.cuerpo}
                                                    </p>
                                                </div>
                                                <div class="col s6 left-align">
                                                   <a class="btn-floating btn-flat waves-effect waves-red grey"><i class="material-icons">favorite_border</i></a>  
                                                </div>
                                                <div class="col s6 right-align">
                                                    <a class="btn-floating btn-flat waves-effect waves-purple grey"><i class="material-icons">comment</i></a>
                                                </div>
                                            </div>
                                        </div>      
                                    </b:forEach>
                                </table>
                            </b:if>
                            <%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/core"%>
                            <f:if test="${listPublicacion == null}">
                                <h5>No hay registros de publicaciones, Empieza tu mismo a compartir ahora!</h5>
                            </f:if>
                                       
                                       
                                        
                                    
                            </div>
                          </div>                       
                    </div>
                    <div class="col m4 l2 hide-on-med-and-down"></div>
                </div>
                    
                <!-- Modal Structure -->

            </section>
        </main>
        <jsp:include page="footer.jsp"/>
        <script src="js/materialize.min.js" type="text/javascript"></script>
        <script src="js/inicializadorMaterialize.js" type="text/javascript"></script>
    </body>
</html>