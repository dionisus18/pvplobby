
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
                <div class="row">
                    <div class="col s6 offset-s1">
                        <div class="col s12 m8 " style="margin-top: 10px">                        
                            <div class="row valign-wrapper">
                                <div class="col s2">
                                    <img src="img/ted.png" alt="" class="circle responsive-img"> <!-- notice the "circle" class -->
                                </div>
                                <div class="col s10">
                                    <span class="black-text">
                                        Sadistic10s3
                                    </span>
                                </div>
                            </div>                        
                        </div>
                        <div class="col s11">
                            <h3>Que buen momo #cMamut</h3><br/>
                            <p>ksjdjasdjjjsajdasj jajajajjajajja ajajaaaaaaaa xdd xdxd xdddddddddddddddddddddddd xd #Lol</p>
                            <div class="row">                            
                                <div class="col s11">                        
                                    <h5 class="grey-text">Comentarios <a class="right grey-text" onclick="">Más</a></h5>                        
                                    <textarea cols="5" rows="10" placeholder="Escribir Comentario aquí"></textarea>                                                     
                                </div>
                                <div class="col s11">
                                    <div class="card-panel grey lighten-5 z-depth-1">
                                        <div class="row valign-wrapper">
                                            <div class="col s2">
                                                <img src="img/Logo PvP Lobby.png" alt="" class="circle responsive-img"> <!-- notice the "circle" class -->
                                            </div>
                                            <div class="col s12">
                                                <span class="black-text">
                                                    <h6><strong>Name Surname<br/></strong> </h6>
                                                    <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Morbi quis sodales quam. Proin lacinia odio a blandit sagittis. Morbi vehicula iaculis felis. Nulla eleifend nunc non tellus porttitor, quis cursus magna commodo. </p>
                                                </span>
                                            </div>
                                        </div>
                                    </div>

                                </div>                        
                            </div>   
                        </div>
                    </div>
                    
                    <div class="col s4" style="margin-top: 130px">                        
                        <img width="120%" src="img/meme.jpg">                        
                    </div>
                 </div>
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
