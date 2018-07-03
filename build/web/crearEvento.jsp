<%-- 
    Document   : crearEvento
    Created on : 3/07/2018, 12:32:04 AM
    Author     : Kevin
--%>

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

                        </div>
                        <div class="row">
                            <form action="SERVFeed">
                                <button type="submit" style="margin-top: 20px; padding: 20px;" class="w3-button tablink w3-blue col s12">Volver</button>
                            </form>

                        </div>
                    </div>

                    <div style="outline: solid #cccccc 1px" class="col s12 m8 l9 opciones"> 
                        <form action="SERVCrearEvento" method="POST" autocomplete="off">
                            <div class="container">
                                <h4 style="margin-top: 50px">Crear Evento</h4>

                                <br>
                                <div class="row">
                                    <div class="input-field col s10">
                                        <input value="${stitulo}" id="txtNombre" name="txtTitulo" type="text">
                                        <label class="active" for="txtTitulo">Titulo</label>
                                    </div>                     
                                    <div class="input-field col s10">
                                        <textarea id="txtCuerpo" name="txtCuerpo" class="materialize-textarea" data-length="255"></textarea>
                                        <label for="txtCuerpo">Descripción de evento</label>
                                    </div>
                                    <div class="input-field col s10">
                                        <input  value="" type="text" id="txtFechaComienzo" name="txtFechaComienzo" class="datepicker">
                                        <label class="active" for="txtFechaComienzo">Fecha de comienzo de evento</label>
                                    </div>
                                </div>

                                <div class="row">
                                    <div class="input-field col s10">
                                        <input class="timepicker" value="" id="txtHoraComienzo" name='txtHoraComienzo' type="txt"  class="validate">
                                        <label class="active" for="txtHoraComiezo">Hora de comienzo</label>
                                    </div> 
                                </div>

                                <div class="row">
                                    <div class="input-field col s10">
                                        <input  value="" type="text" id="txtFechaTermino" name="txtFechaTermino" class="datepicker">
                                        <label class="active" for="txtFechaTermino">Fecha de termino de evento</label>
                                    </div>
                                </div>

                                <div class="row">
                                    <div class="input-field col s10">
                                        <input class="timepicker"  value="" type="text" id="txtHoraTermino" name="txtHoraTermino" class="datepicker">
                                        <label class="active" for="txtHoraTermino">Hora de termino de evento</label>
                                    </div>
                                </div>
                                <div class="row">
                                    <p>Tipo de privacidad del evento</p>
                                    <p>
                                        <label>
                                            <input id="esPublico" name="group1" type="radio" checked value="1" />
                                            <span>Publico</span>
                                        </label>
                                    </p>
                                    <p>
                                        <label>
                                            <input id="esPrivado" name="group1" type="radio" value="0" />
                                            <span>Privado</span>
                                        </label>
                                    </p>

                                </div>
                                <div style="padding-bottom: 30px" class="row">
                                    <div class="col s12 center">
                                        <button class="btn waves-effect waves-light light-blue" type="submit" name="btnCreacionEvento">Enviar</button>  

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

    </body>
</html>
