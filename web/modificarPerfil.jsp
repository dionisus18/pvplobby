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
        <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
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
            <section style="padding-top: 30px; padding-bottom: 30px; " class="container">
                <div style="border: solid #cccccc 1px;" class="row card">

                    <div class="col s12 m4 l3 center"> <!-- Note that "m4 l3" was added -->
                        <div style="padding-top: 50px;" class="row">
                            <img style="border: solid black 1px;" src="img/Union 4.png" class="imgPersona circle white">
                        </div>
                        <div class="row">
                            <h4>${user}</h4>
                        </div>
                        <div class="row">
                            <a href="">Editar foto del perfil</a>
                        </div>
                        <div class="row">
                            <button style="margin-top: 20px; padding: 20px;" class="w3-button tablink w3-blue col s12" onclick="openLink(event, 'test1')">Modificar Perfil</button>
                            <button style="margin-top: 20px; padding: 20px;" class="w3-button tablink  col s12" onclick="openLink(event, 'test2')">Cambiar Contraseña</button>
                        </div>
                    </div>

                    <div style="outline: solid #cccccc 1px" id="test1" class="col s12 m8 l9 opciones"> 
                        <form action="SERVModificarPerfil" method="POST" autocomplete="off">
                            <div class="container">
                                <h4 style="margin-top: 50px">Editar Perfil</h4>

                                <br>
                                <p>Marque la casilla del campo que desea editar</p>
                                <div class="row">
                                    <div class="input-field col s10">
                                        <input value="${sperfil.nombre}" id="txtnombre" name="txtnombre" type="text" disabled="disabled">
                                        <label class="active" for="txtnombre">Nombre</label>
                                    </div>
                                    <div  class="col s2">
                                        <p>
                                            <label>
                                                <input id="checkNombre" type="checkbox" />
                                                <span></span>
                                            </label>
                                        </p>
                                    </div>                           
                                    <div class="input-field col s10">
                                        <input value="${susuario.nombreUsuario}" id="txtusuario" name="txtusuario" type="text" disabled="disabled">
                                        <label class="active" for="txtusuario">Usuario</label>
                                    </div>
                                    <div  class="col s2">
                                        <p>
                                            <label>
                                                <input id="checkUsuario" type="checkbox" />
                                                <span></span>
                                            </label>
                                        </p>
                                    </div>  
                                    <div class="input-field col s10">
                                        <input value="${sperfil.biografia}" id="txtbiografia" name="txtbiografia" type="text" disabled="disabled">
                                        <label class="active" for="txtbiografia">Biografía</label>
                                    </div>
                                    <div  class="col s2">
                                        <p>
                                            <label>
                                                <input id="checkBiografia" type="checkbox" />
                                                <span></span>
                                            </label>
                                        </p>
                                    </div>  
                                </div>

                                <h6 style="padding-top: 30px">Información privada</h6>

                                <div class="row">
                                    <div class="input-field col s10">
                                        <input value="${susuario.email}" id="txtemail" name='txtemail' type="email" disabled="disabled" class="validate">
                                        <label class="active" for="txtemail">Correo</label>
                                    </div>
                                    <div  class="col s2">
                                        <p>
                                            <label>
                                                <input id="checkEmail" type="checkbox" />
                                                <span></span>
                                            </label>
                                        </p>
                                    </div>  
                                </div>

                                <div class="row">
                                    <div class="input-field col s10">
                                        <input value="${sperfil.idPersonal}" id="txtidpersonal" name="txtidpersonal" type="text"disabled="disabled">
                                        <input value="${sperfil.idPerfil}" id="txtidperfil" name="txtidperfil" type="text"disabled="disabled">
                                        <label class="active" for="txtidpersonal">Identificación</label>
                                    </div>
                                    <div  class="col s2">
                                        <p>
                                            <label>
                                                <input id="checkIdPersonal" type="checkbox" />
                                                <span></span>
                                            </label>
                                        </p>
                                    </div> 
                                </div>

                                <div class="row">
                                    <div class="input-field col s10">
                                        <input  value="${sperfil.fechaNacimiento}" type="text" id="txtfechanacimiento" disabled="disabled" name="txtfechanacimiento" class="datepicker">
                                        <label class="active" for="txtfechanacimiento">Fecha Nacimiento</label>
                                    </div>
                                    <div  class="col s1">
                                        <p>
                                            <label>
                                                <input id="checkFechaNacimiento" type="checkbox" />
                                                <span></span>
                                            </label>
                                        </p>
                                    </div>  
                                </div>
                                <div style="padding-bottom: 30px" class="row">
                                    <div class="col s12 center">
                                        <button class="btn waves-effect waves-light light-blue" type="submit" name="btnModificarPerfil">Enviar</button>  

                                    </div>
                                </div>

                            </div> 
                        </form> 
                    </div>

                    <div style="display:none; outline: solid #cccccc 1px" id="test2" class="col s12 m8 l9 opciones"> 
                        <form action="#" autocomplete="off">
                            <div class="container">
                                <h4 style="margin-top: 50px">Cambiar Contraseña</h4>
                                <br>
                                <div class="row">
                                    <div class="input-field col s10">
                                        <input id="txtpass" name="txtpass" type="password">
                                        <label class="active" for="txtpass">Contraseña actual</label>
                                    </div>                        
                                    <div class="input-field col s10">
                                        <input id="txtpassnew" name="txpassnew" type="password">
                                        <label class="active" for="txtpassnew">Nueva Contraseña</label>
                                    </div>
                                    <div class="input-field col s10">
                                        <input id="txtpassnew2" name="txtpassnew2" type="password">
                                        <label class="active" for="txtpassnew2">Repetir Contraseña</label>
                                    </div>
                                </div>
                                <div style="padding-bottom: 30px" class="row">
                                    <div class="col s12 center">
                                        <button class="btn waves-effect waves-light light-blue" type="submit" name="btnModificarPerfil">Enviar</button>  

                                    </div>
                                </div>

                            </div> 
                        </form> 
                    </div>


                </div> 
            </section>
        </main>
        <jsp:include page="footer.jsp"/>
        <script src="js/materialize.js" type="text/javascript"></script>
        <script src="js/inicializadorMaterialize.js" type="text/javascript"></script>
        <script>
                                document.getElementById('checkNombre').onchange = function () {
                                    document.getElementById('txtnombre').disabled = !this.checked;
                                };
                                document.getElementById('checkUsuario').onchange = function () {
                                    document.getElementById('txtusuario').disabled = !this.checked;
                                };
                                document.getElementById('checkBiografia').onchange = function () {
                                    document.getElementById('txtbiografia').disabled = !this.checked;
                                };
                                document.getElementById('checkEmail').onchange = function () {
                                    document.getElementById('txtemail').disabled = !this.checked;
                                };
                                document.getElementById('checkFechaNacimiento').onchange = function () {
                                    document.getElementById('txtfechanacimiento').disabled = !this.checked;
                                };
                                document.getElementById('checkIdPersonal').onchange = function () {
                                    document.getElementById('txtidpersonal').disabled = !this.checked;
                                };
        </script>
        <script>
            function openLink(evt, animName) {
                var i, x, tablinks;
                x = document.getElementsByClassName("opciones");
                for (i = 0; i < x.length; i++) {
                    x[i].style.display = "none";
                }
                tablinks = document.getElementsByClassName("tablink");
                for (i = 0; i < x.length; i++) {
                    tablinks[i].className = tablinks[i].className.replace(" w3-blue", "");
                }
                document.getElementById(animName).style.display = "block";
                evt.currentTarget.className += " w3-blue";
            }
        </script>

    </body>
</html>