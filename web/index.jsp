<%
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
        <header>
            <nav>
                <div class="nav-wrapper grey darken-4">
                    <a href="index.jsp" class="brand-logo">PVPLobby</a>
                    <ul id="nav-mobile" class="right hide-on-med-and-down">
                        <li><a href="login.jsp"><i class="material-icons">account_box</i></a></li>
                    </ul>
                </div>
            </nav>
        </header>
        <main>
            <section class="container">
                <div class="row">
                    <div class="col m4 l1 hide-on-med-and-down"><p>s12 m4</p></div>
                    <div class="col s12 m12 l10">
                        <table class="striped">
                            <tr></tr>
                            <tr>
                                <td class="hide-on-small-and-down"> 
                                    <img class="responsive-img" src="img/Logo PvP Lobby.png" alt="logopvplobby"/>
                                </td>
                                <td class="col l8 m12 s12">

                                    <form id='registro' action="SERVUsuario" method="POST" autocomplete="off">
                                        <div class="row card-panel white">
                                            <h4 class="center-align col s12">Registro</h4>
                                            <p class="center-align col s12 ">Registrese para empezar a interactuar con la comunidad y explorar eventos</p>
                                            <div class="input-field col s12">
                                                <input id="usuario" name='usuario' type="text" class="validate" value="<%=usuario%>">
                                                <label for="usuario">Usuario</label>
                                            </div>
                                            <div class="input-field col s12">
                                                <input id="nombre" name='nombre' type="text" class="validate" value="<%=nombre%>">
                                                <label for="nombre">Nombre</label>

                                            </div>
                                            <div class="input-field col s12">
                                                <input id="email" name='email' type="email" class="validate" value="<%=email%>">
                                                <label for="email">Correo Electrónico</label>

                                            </div>
                                            <div class="input-field col s12">
                                                <input id="pass" name="pass" type="password" class="validate" value="<%=pass%>">
                                                <label for="pass">Contraseña</label>

                                            </div>
                                            <div class="input-field col s12">
                                                <input id="pass2" name="pass2" type="password" class="validate" value="<%=pass2%>">
                                                <label for="pass2">Repita Contraseña</label>                                               
                                            </div>
                                            <div class="input-field col s12">
                                                <button class="btn waves-effect waves-light blue accent-3 col s12" type="submit" name="btnRegistro">Registrarse
                                                    
                                                </button>         

                                            </div>
                                            <div class="input-field center-align col s12">
                                                <p>Al registrarte aceptas nuestras <a href="condiciones.jsp">Condiciones</a></p>
                                            </div>
                                        </div>     
                                    </form>
                                    
                                </td>
                            </tr>
                            <tr>
                                <td class="hide-on-med-and-down"></td>
                                <td class="col l8 m12 s12">
                                    <div class="center-align">
                                        <%if (errores != null && !errores.equals("")) {%>
                                        <%=divError + divErrortitle + errores + divError2%>
                                        <%}%>    
                                    </div>
                                </td>
                            </tr>
                            <tr>
                                <td class="hide-on-med-and-down"></td>
                                <td class="col l8 m12 s12">
                                    <div class="card-panel white center-align">
                                        <p>¿Ya Tienes cuenta? <a href="login.jsp">Iniciar Sesion</a></p>
                                    </div>
                                </td>
                            </tr>
                        </table>                        
                    </div>
                    <div class="col m4 l1 hide-on-med-and-down"><p>s12 m4</p></div>
                </div>
                <div class="row"></div>

            </section>
        </main>
        <footer class="page-footer grey lighten-2">
            <div class="row container center-align">
                <div class="col l4 s12">
                    <a href="informacion.jsp">INFORMACION</a>

                </div>
                <div class="col l4 s12">
                    <a href="privacidad.jsp">POLITICAS Y PRIVACIDAD</a>    
                </div>
                <div class="col l4 s12">
                    <a href="condiciones.jsp">CONDICIONES</a>    
                </div>
            </div>

            <div class="footer-copyright grey-text text-darken-3 ">
                <div class="container">
                    © 2018 PvPLobby
                </div>

            </div>
        </footer>   

        <script src="js/materialize.min.js" type="text/javascript"></script>
        <script src="js/inicializadorMaterialize.js" type="text/javascript"></script>

    </body>
</html>
