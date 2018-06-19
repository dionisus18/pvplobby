<%@page import="modelo.Region"%>
<%@page import="modelo.Provincia"%>
<%@page import="modelo.DAORegion"%>
<%@page import="modelo.DAOProvincia"%>
<%@page import="java.io.OutputStream"%>
<%@page import="java.io.InputStream"%>
<%@page import="modelo.Persona"%>
<%@page import="java.util.LinkedList"%>
<%@page import="modelo.DAOPersona"%>
<%@page import="java.time.LocalDate"%>
<%@page import="java.time.Period"%>
<%@page import="java.time.format.DateTimeFormatter"%>
<%
    DAOPersona dao = new DAOPersona();    
    DAOProvincia daoProv = new DAOProvincia();
    DAORegion daoR = new DAORegion();
    
    LinkedList<Persona> listaPersonas = new LinkedList();
    LinkedList<Provincia> listaProvincias = new LinkedList();
    LinkedList<Region> listaRegiones = new LinkedList();
    
    // variables locales
    String respuesta = (String) request.getAttribute("respuesta");
    String errores = (String) request.getAttribute("sErrores");
    String nombre = (String) request.getAttribute("sNombre");
    String apellido = (String) request.getParameter("sApellido");
    String Run = request.getParameter("sRUN");
    String imagen = request.getParameter("sImagen");

    if (errores == null) {
        errores = "";
    }
    if (nombre == null) {
        nombre = "";
    }
    if (apellido == null) {
        apellido = "";
    }
    if (Run == null) {
        Run = "";
    }
    if (imagen == null) {
        imagen = "";
    }
    if (respuesta == null) {
        respuesta = "";
    }
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>TEST CONEXION BASE DE DATOS</title>
        <link href="Style.css" rel="stylesheet" > 
    </head>
    <body>
        <header>
            <h1>EVA III??? Conexion a BD Persona</h1>  
        </header>
        <section>
            <div id="left">
                <article>
                    <h2>Administracion de personas</h2>
                    <p>
                        <%if (errores != null && !errores.equals("")) {%>
                        <%=errores%>  
                        <%}%>    
                    </p>
                    <form name="frmPersonas" method="POST" action="SERVPersona" >
                        <p>RUN: <input type="text" name="txtRUN" width="50px" value="<%=Run%>"></p>
                        <p>Nombre: <input type="text" name="txtNombre" width="50px" value="<%=nombre%>" ></p>
                        <p>Apellidos: <input type="text" name="txtApellido"  width="50px" value="<%=apellido%>" ></p>
                        <p>Fecha Nacimineto: <input type="date" name="txtFechaN"  width="50px" ></p>
                        <p>Region:<select name="txtRegion" autofocus="autofocus"> 
                                <%listaRegiones = daoR.consultar();%>  
                                <%for (Region lRegion :listaRegiones) { %>
                                <%if (lRegion != null) {%>
                                <option> <%=lRegion.getNombre() %> </option>    
                                <%}%>
                                <%}%> 
                            </select> </p>
                            <p>Provincia:<select name="txtProvincia"> 
                                <%listaProvincias = daoProv.consultar();%> 
                                <%for (Provincia lisProvincia :listaProvincias) { %>
                                <%if (lisProvincia != null) {%>
                                <option> <%= lisProvincia.getNombre() %> </option>    
                                <%}%>
                                <%}%> 
                                <!-- <%//listaRegiones = daoR.consultar();%> 
                                <%//for (Region lRegion :listaRegiones) { %>
                                <%//if (lRegion != null && lRegion.getNombre().equals(request.getParameter("txtRegion")) ) {%>
                                <%//listaProvincias = daoProv.consultar();%> 
                                <%//for (Provincia lisProvincia :listaProvincias) { %>
                                <%//if (lisProvincia != null && lisProvincia.getRegion_id() == lRegion.getId()) {%>
                                <option> <%//= lisProvincia.getNombre() %> </option>    
                                <%//}%>
                                <%//}%> 
                                <%//}%>
                                <%//}%> -->
                            </select> </p>

                            <p> URL de Imagen: <input type="text" name="txtRuta" width="50px" value="<%=imagen%>" > <input name="esteboton" type="submit" value="Visualizar"> </p>

                        <p>IMAGEN: <img src="<%= request.getParameter("txtRuta")%>" > </p>
             
                        <input type="submit"  value="Guardar" name="btnGuardar" >  
                        <br>
                        <p>Para Actualizar/Borrar introduzca la ID</p>

                        <p>ID: <input type="number" name="txtID" width="50px" ></p>
                        <input type="submit"  value="Modificar" name="btnModificar" >
                        <input type="submit"  value="Eliminar" name="btnEliminar" > 
                    </form>
                    <p>
                        <%if (respuesta != null) {%>
                        <%= respuesta%>  
                        <%}%>
                    </p>
                    <h2>Filtrado</h2>
                    <p>Eliga una opcion y luego filtre</p>
                    <input type="submit" value="Filtrar">
                </article>
            </div>
            <div id="right">
                <article>
                    <h2>Listado de Personas</h2>
                    <!--estilo temporal-->
                    <table cellspadding="1" cellspacing="1" id="lista" border="1" >
                        <thead>
                        <tr>
                            <th>ID</th>
                            <th>RUN</th>
                            <th>Nombre</th>
                            <th>Apellido</th>
                            <th>Ciudad</th>
                            <th>Region</th>
                            <th>Edad</th>
                            <th>Imagen</th>
                        </tr>    
                        </thead>
                        <tbody>
                        <!--Se creara una fila nueva por cada objeto 
                            Guardado en el listado-->
                        <%listaPersonas = dao.consultar();
                        for (Persona p : listaPersonas) {%>
                        <tr>
                            <td><%= p.getID()%></td>
                            <td><%= p.getRUN()%></td>
                            <td><%= p.getNombre()%></td>
                            <td><%= p.getApellido()%></td>
                            <td><%= p.calcularProvincia(p.getProvincia()) %></td>
                            <td><%= p.calcularRegion(p.getRegion()) %></td>
                            <td><% 
                                DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                                LocalDate fechaNac = LocalDate.parse(p.getFnacimiento().toString(), fmt);
                                LocalDate ahora = LocalDate.now();
                                Period periodo = Period.between(fechaNac, ahora); %>
                                <%= periodo.getYears() %></td>
                            <td><img class="imgPersona"  width="80px" src="<%= p.getImagen()%>" ></td>
                        </tr>
                        <%  }%>      
                        </tbody>
                    </table>
                </article>
            </div>
        </section> 
    </body>
</html>
