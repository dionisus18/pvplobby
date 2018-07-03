<%-- 
    Document   : feed
    Created on : 25/06/2018, 01:33:26 PM
    Author     : Kevin
--%>
<%
if (request.getAttribute("listPublicacion") == null) {
        response.sendRedirect("SERVFeed");
    }
%>
<%@page import="modelo.Evento"%>
<%@page import="java.util.LinkedList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Feed ${user} </title>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <!--Import Google Icon Font-->
        <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
        <!--Import materialize.css-->
        <link href="css/materialize.min.css" rel="stylesheet" type="text/css"/>         
        <!--Let browser know website is optimized for mobile-->
        <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
        <link href="css/Style.css" rel="stylesheet" type="text/css"/>
    </head>
    <body class="grey lighten-5">
        <jsp:include page="header.jsp" />
        <main>
            <section>
                <!-- Division de contenido en filas/columnas -->
                <div class="row">
                    <!-- nota: style="position: fixed; bottom: 0%; top: 0%; padding-top: 100px;" -->
                    <!-- nota: style="overflow-y: scroll; height: 100%;" -->

                    <!-- ***************** Contenido de usuario + miniFooter ****************** -->
                    <div style="padding-top: 30px; position: fixed;"  class="col l2 m2 s12 center-align hide-on-small-and-down">
                        <div>
                            <img style="border: solid 1px black;" class="circle responsive-img white" src="img/Union 4.png" alt=""/>
                            <h6>${user}</h6>
                            <jsp:include page="miniFooter.jsp" />    
                        </div>    
                    </div>

                    <!-- Espacio de relleno -->
                    <div class="col l4 m4 s12" ></div>

                    <!-- **********************Contenido principal ********************** -->
                    <div class="col l4 m4 s12 center-align">

                        <div class="row">
                            <div class="col l12">
                                <ul class="tabs">
                                    <li class="tab col s6"><a class="active" href="#contenidoEvento">Eventos</a></li>
                                    <li class="tab col s6"><a href="#contenidoPublicacion">Publicaciones</a></li>  
                                </ul>
                            </div>
                        </div>

                        <div class="row">
                            <div id="contenidoEvento" class="col s12">
                                <div class="card-panel">
                                    <form id="frmEvento" action="SERVCrearEvento" method="POST">
                                        <div class="input-field">
                                            <input id="etitulo" name='etitulo' type="text" class="validate">
                                            <label for="etitulo">Titulo de evento</label>
                                        </div>
                                        <div class="input-field right-align">
                                            <button class="btn waves-effect waves-light blue accent-3" type="submit" name="btnCrearEvento">Crear Evento
                                            </button>         
                                        </div>
                                    </form>
                                    <%@ taglib prefix="h" uri="http://java.sun.com/jsp/jstl/core"%>    
                                    <h:if test="${errores != null}">
                                        ${errores}
                                    </h:if>  
                                </div>

                                <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
                                <c:if test="${listEvento != null}">
                                    <c:forEach items="${listEvento}" var="record">
                                        <div class="card-panel">
                                            <div class='row'>
                                                    
                                                <div class='col s6 left-align'>
                                                    <form id="frm-send" action="SERVPerfilPublico" method="POST">
                                                        <input type="hidden" id="idUsuario" name="idUsuario" value="${record.idUsuario}">
                                                    <button id="btnPerfilPublico" class="btn-flat" type="submit">${record.nombreUsuario}</button>
                                                    </form>  
                                                </div>
                                                <div class="col s6 right-align">
                                                    ${record.fechaCreacion}
                                                </div>
                                            </div>
                                            <div class="row">

                                            </div>
                                            <div class="row">
                                                <div class='col s12 left-align'>
                                                    <h5>${record.titulo}</h5>
                                                </div>
                                                <div class='col s12 left-align'>
                                                    <p class="truncate">
                                                        ${record.cuerpo}
                                                    </p>
                                                </div>
                                                    <div style="margin-bottom: 20px" class='col s12 left-align'>
                                                    <h5>Comienza el ${record.fechaComienzo} a las ${record.horaInicio} Horas </h5>
                                                </div>
                                                <div class="col s6 left-align">
                                                   <a class="btn-floating btn-flat waves-effect waves-red grey"><i class="material-icons">favorite_border</i></a>  
                                                </div>
                                                <div class="col s6 right-align">
                                                    <a class="btn-floating btn-flat waves-effect waves-purple grey"><i class="material-icons">comment</i></a>
                                                </div>
                                            </div>
                                        </div>      
                                    </c:forEach>
                                </c:if>    

                            </div>



                            <%@ taglib prefix="h" uri="http://java.sun.com/jsp/jstl/core"%>    


                            <h:if test="${listEvento == null}">
                                <h5>No hay registros de Eventos, Empieza tu mismo a compartir ahora!</h5>
                            </h:if>    


                        </div>
                        <div id="contenidoPublicacion" class="col s12">
                            <div class="card-panel">
                                <form id="frmPublicaciones" action="SERVCrearEvento" method="POST">
                                    <div class="input-field">
                                        <input id="ptitulo" name='ptitulo' type="text" class="validate">
                                        <label for="ptitulo">Titulo de publicación</label>
                                    </div>
                                    <div class="input-field right-align">
                                        <button class="btn waves-effect waves-light blue accent-3" type="submit" name="btnCrearPublicacion">Crear Publicacion
                                        </button>         
                                    </div>
                                </form>
                            </div>
                            <%@ taglib prefix="b" uri="http://java.sun.com/jsp/jstl/core"%>
                            <b:if test="${listPublicacion != null}">
                                <table>
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

                <!-- Espacio de relleno -->
                <div class="col l4 m4 s12"></div>
                </div>
            </section>
        </main>
        <div class="hide-on-med-and-up">
            <jsp:include page="footer.jsp" />  
        </div>
        <script src="js/materialize.min.js" type="text/javascript"></script>
        <script src="js/inicializadorMaterialize.js" type="text/javascript"></script>
    </body>
</html>
