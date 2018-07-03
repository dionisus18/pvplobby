
<%@page import="modelo.DAOPublicacion"%>
<%@page import="java.awt.Button"%>
<%@page import="modelo.Evento"%>
<%@page import="modelo.DAOEvento"%>
<%@page import="modelo.DAOPerfil"%>
<%@page import="modelo.Perfil"%>
<%@page import="modelo.DAOUsuario"%>
<%@page import="modelo.Usuario"%>
<%@page import="modelo.Publicacion" %>
<%
    DAOUsuario dao = new DAOUsuario();
    DAOPerfil dao2 = new DAOPerfil();
    DAOPublicacion dao4 = new DAOPublicacion();
    Usuario usuarioLocal = (Usuario) request.getAttribute("usuarioclase");
    Perfil PerfilLocal = (Perfil) request.getAttribute("perfil");
    Publicacion evento = (Publicacion) request.getAttribute("evento");
    DAOEvento dao3 = new DAOEvento();
    Evento evt = (Evento) request.getAttribute("evt");
    Usuario dueño = (Usuario) request.getAttribute("us");
    String ss = request.getParameter("Id");
    
    int xx = Integer.parseInt(ss);
    int l = 1 ;
    int seguidores = dao4.seguidores(xx);
    if(xx == 2){
        seguidores = 3;
    }
    
    
    //LinkedList<Publicacion> lista = (LinkedList) request.getAttribute("listaEvento");
    
    if (session.getAttribute("user") == null) {
        response.sendRedirect("login.jsp");
    }
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
        Perfil ps = new Perfil();
        Publicacion pb = new Publicacion();
        ps = dao2.selecionarPerfil(usuarioLocal.getIdUsuario());
        evento = dao2.vistaEventos(xx); 
        evt = dao3.infoEvento(evento.getIdPublicacion());        
        dueño = dao.buscarDueño(evento.getUsuario_IdUsuario());
        
        
      
        
        if (ps == null) {
                System.out.println("Error no se consigue ningun perfil o esta mala la query");
            }else{
            PerfilLocal = ps;        
           
        }
        
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
                <!--Columna Derecha -->
                <div class="row">
                    <div class="col s5 offset-s1">
                        <h2><%= evento.getTitulo() %></h2>
                        <p style="text-align: justify;"><%=evento.getCuerpo() %><br/>
                        
                        <div class="col s12">                            
                            <h5 class="grey-text" style="margin-top: 50px"><strong>Restricciones</strong></h5>
                        <br/>
                        <p style="text-align: justify;">No se han registrado restricciones por el momento.</p>
                            
                        <br/>
                        
                        <a class="waves-effect waves-light btn" id="boton"></a>
                        
                        <script>
                            
                            class Toggable {
                                constructor(element){
                                  // inicializar el estado interno

                                  this.element = element; // inicializa
                                  this.element.innerHTML = "Seguir"; // toma el valor inicial del boton
                                  this.activated = false; // booleano inicial
                                  this.onClick = this.onClick.bind(this); // activa la referencia del metodo onClick
                                  this.element.addEventListener("click" , this.onClick); // referencia al onCLick externo

                                }
                                  onClick(ev){
                                      // cambiar esto interno ON/Off
                                      // llamar a toggleText
                                    console.log("Esto tiene this" , this);// muestra lo que contine this // true - false
                                    this.activated= !this.activated; // Entrega un valor diferente del actual
                                    this.toggleText();// cambia el texto mediante la funcion toggleText
                                    }

                                    toggleText(){
                                      //cambiar texto

                                      this.element.innerHTML = this.activated ? "Siguiendo" : "Seguir";
                                      // contiene un IF , Si esta ativado cambia el texto a On sino a OFF
                                    }

                                    }

                                    const button = document.getElementById("boton");
                                    const miBoton = new Toggable(button)
                                    
                        </script>
                        <a class="waves-effect waves-light btn" >Asistiré</a>
                        <a class="waves-effect waves-light btn" onclick="suma()" id="inc"><i class="material-icons left">favorite</i>5</a>
                             
                        </div>
                        
                    </div>
                    <!-- Columna izquierda -->
                    <div class="col s6" style="margin-top: 50px">
                        <div class="col s12 m8 offset-m2 ">
                            <div class="card-panel grey lighten-5 z-depth-1">
                                <div class="row valign-wrapper">
                                    <div class="col s3">
                                        <img src="img/Logo PvP Lobby.png" alt="" class="circle responsive-img"> <!-- notice the "circle" class -->
                                    </div>
                                    <div class="col s9">
                                        <span class="black-text">
                                            <h6><strong><br/><%= dueño.getNombreUsuario() %></strong> </h6>
                                            <p>Organizador de Evento</p> 
                                        </span>
                                    </div>
                                </div>
                            </div>
                            <div class="card-panel grey lighten-5 z-depth-1">
                                <div class="row valign-wrapper">
                                    <%if(seguidores > 0){ %>
                                    <div class="col s3">
                                        <img src="img/Logo PvP Lobby.png" alt="" class="circle responsive-img"> <!-- notice the "circle" class -->
                                    </div>   
                                     <div class="col s3">
                                        <img src="img/Logo PvP Lobby.png" alt="" class="circle responsive-img"> <!-- notice the "circle" class -->
                                    </div> 
                                     <div class="col s3">
                                        <img src="img/Logo PvP Lobby.png" alt="" class="circle responsive-img"> <!-- notice the "circle" class -->
                                    </div> 
                                     <div class="col s3">
                                        <img src="img/Logo PvP Lobby.png" alt="" class="circle responsive-img"> <!-- notice the "circle" class -->
                                    </div>
                                    <%}%>
                                </div>
                            </div>
                         
                            </div>
                        
                         <div class="col s12">
                             <%if ( evento.getIdPublicacion() == 1){ %>
                             <img class="col s12 m8 offset-m2  " src="img/heroes.jpg"> 
                             <%}%> 
                             <%if ( evento.getIdPublicacion() == 2){ %>
                             <img class="col s12 m8 offset-m2  " src="img/t2_vs_logo.jpg"> 
                             <%}%> 
                             <%if ( evento.getIdPublicacion() == 3){ %>
                             <img class="col s12 m8 offset-m2  " src="img/mainhead.png"> 
                             <%}%> 
                            <br/>
                        </div>
                        <div class="col s12 m8 offset-m2">
                            <h6 class="grey-text" style="margin-top: 50px"><strong>Fechas y Horarios:</strong></h6>
                        <br/>
                        <p>Empieza : <%=evt.getFechaComienzo() %>, a las <%=evt.getHoraInicio() %></p>
                        <p>Termina : <%= evt.getFechaFinalizacion() %> a las <%=evt.getHoraTermino()%></p>
                        </div>
                        </div>

                    </div>
                <div class="row">
                    <div class="col s4"></div>
                    <div class="col s4">                        
                        <h5 class="grey-text">Comentarios <a class="right grey-text" onclick="">Más</a></h5>                        
                        <textarea cols="5" rows="10"></textarea>
                        <a style="margin-top: 20px" class="waves-effect waves-light btn" onclick="">Enviar</a>                        
                    </div>
                    <div class="col s4"></div>
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
