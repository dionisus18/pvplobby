/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.LinkedList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.DAOEvento;
import modelo.DAOPublicacion;
import modelo.DAOUsuario;
import modelo.Evento;
import modelo.Publicacion;
import modelo.Usuario;

/**
 *
 * @author Kevin
 */
public class SERVCrearEvento extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            String titulo = "";
            String cuerpo = "";
            String fechaC = "";
            String fechaT = "";
            String HoraC = "";
            String HoraT = "";
            String erroress = "";
            int EsPrivado = 0;
            int UserID = 0;
            RequestDispatcher rd = null;

            if (request.getParameter("btnCrearEvento") != null) {
                titulo = request.getParameter("etitulo");
                if (titulo.trim().equals("")) {
                    erroress += "<p>Debe de ingresar el titulo</p>";
                }

                if (erroress.equals("")) {
                    request.setAttribute("stitulo", titulo);
                    if (!response.isCommitted()) {
                        rd = request.getRequestDispatcher("crearEvento.jsp");
                        rd.forward(request, response);
                    }
                } else {
                    request.setAttribute("errores", erroress);
                    if (!response.isCommitted()) {
                        rd = request.getRequestDispatcher("feed.jsp");
                        rd.forward(request, response);
                    }
                }

            }

            if (request.getParameter("btnCrearPublicacion") != null) {
                titulo = request.getParameter("ptitulo");
                if (titulo.trim().equals("")) {
                    erroress += "<p>Debe de ingresar el titulo</p>";
                }

                if (erroress.equals("")) {
                    request.setAttribute("ptitulo", titulo);
                    if (!response.isCommitted()) {
                        rd = request.getRequestDispatcher("crearPublicacion.jsp");
                        rd.forward(request, response);
                    }
                } else {
                    request.setAttribute("errores", erroress);
                    if (!response.isCommitted()) {
                        rd = request.getRequestDispatcher("feed.jsp");
                        rd.forward(request, response);
                    }
                }

            }

            if (request.getParameter("btnCreacionEvento") != null) {
                Publicacion miPubli = new Publicacion();
                Evento miEvento = new Evento();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
                DateTimeFormatter hformatter = DateTimeFormatter.ofPattern("HH:mm:ss");
                LocalDate localDate = LocalDate.now();
                LocalDate FechaComienzo;
                LocalDate FechaTermino;
                LocalTime now;
                LocalTime HoraComienzo;
                LocalTime HoraTermino;

                ArrayList<String> errores = new ArrayList<>();

                DAOUsuario daoUsuario = new DAOUsuario();
                Usuario localUsuario = new Usuario();
                LinkedList<Usuario> listaUsuarios = new LinkedList<>();
                String usuario = (String) request.getSession(false).getAttribute("user");
                if (usuario == null) {
                    if (!response.isCommitted()) {
                        rd = request.getRequestDispatcher("index.jsp");
                        rd.forward(request, response);
                    }

                } else {
                    listaUsuarios = daoUsuario.consultar();

                    if (listaUsuarios != null) {
                        for (Usuario miUsuario : listaUsuarios) {
                            if (usuario.equals(miUsuario.getNombreUsuario())) {
                                localUsuario = miUsuario;
                                UserID = miUsuario.getIdUsuario();
                                break;
                            }
                        }
                    }

                    titulo = request.getParameter("txtTitulo");
                    cuerpo = request.getParameter("txtCuerpo");
                    fechaC = request.getParameter("txtFechaComienzo");
                    fechaT = request.getParameter("txtFechaTermino");
                    HoraT = request.getParameter("txtHoraTermino");
                    HoraC = request.getParameter("txtHoraComienzo");

                    if (request.getParameter("esPublico") != null) {
                        if (request.getParameter("esPublico").equals("1")) {
                            EsPrivado = 1;
                        }

                    } else if (request.getParameter("esPrivado") != null) {
                        if (request.getParameter("esPrivado").equals("0")) {
                            EsPrivado = 0;
                        }
                    }

                    if (titulo.equals("")) {
                        errores.add("<p>Debe de ingresar el titulo</p>");
                    }
                    if (cuerpo.equals("")) {
                        errores.add("<p>Debe de ingresar la descripción</p>");
                    }
                    if (fechaC.equals("")) {
                        errores.add("<p>Debe de ingresar la Fecha Comienzo</p>");
                    }
                    if (fechaT.equals("")) {
                        errores.add("<p>Debe de ingresar la Fecha de Termino</p>");
                    }
                    if (HoraC.equals("")) {
                        errores.add("<p>Debe de ingresar la Hora de Comienzo</p>");
                    }
                    if (HoraT.equals("")) {
                        errores.add("<p>Debe de ingresar la Hora de Termino</p>");
                    }

                    if (errores.isEmpty()) {
                        HoraC = HoraC + ":00";
                        HoraT = HoraT + ":00";
                        FechaComienzo = LocalDate.parse(fechaC, formatter);
                        FechaTermino = LocalDate.parse(fechaT, formatter);
                        HoraComienzo = LocalTime.parse(HoraC, hformatter);
                        HoraTermino = LocalTime.parse(HoraT, hformatter);

                        miEvento.setEsPrivado(EsPrivado);
                        miEvento.setFechaComienzo(FechaComienzo);
                        miEvento.setFechaFinalizacion(FechaTermino);
                        miEvento.setHoraInicio(HoraComienzo);
                        miEvento.setHoraTermino(HoraTermino);
                        miEvento.setEsPrivado(EsPrivado);

                        miPubli.setTitulo(titulo);
                        miPubli.setCuerpo(cuerpo);
                        miPubli.setUsuario_IdUsuario(UserID);

                        DAOEvento aOEvento = new DAOEvento();
                        DAOPublicacion aOEvento2 = new DAOPublicacion();

                        try {
                            //aOEvento.insertarConPublicacion(miPubli, miEvento);
                            int insertar1 = aOEvento2.insertar1(miPubli);
                            if (insertar1 > 0) {
                                miEvento.setIdPublicacion(insertar1);
                                aOEvento.insertar1(miEvento);
                            }

                        } catch (Exception e) {
                            System.out.println(e);
                        }

                        if (!response.isCommitted()) {
                            rd = request.getRequestDispatcher("feed.jsp");
                            rd.forward(request, response);
                        }
                    } else {
                        request.setAttribute("errores", errores);
                        request.setAttribute("stitulo", titulo);
                        request.setAttribute("scuerpo", cuerpo);
                        request.setAttribute("sfechaC", fechaC);
                        request.setAttribute("sfechaT", fechaT);
                        request.setAttribute("sHoraC", HoraC);
                        request.setAttribute("eHoraT", HoraT);
                        if (!response.isCommitted()) {
                            rd = request.getRequestDispatcher("crearEvento.jsp");
                            rd.forward(request, response);
                        }
                    }

                }

            }
            if (request.getParameter("btnCreacionPublicacion") != null) {
                Publicacion miPubli = new Publicacion();

                ArrayList<String> errores = new ArrayList<>();

                DAOUsuario daoUsuario = new DAOUsuario();
                Usuario localUsuario = new Usuario();
                LinkedList<Usuario> listaUsuarios = new LinkedList<>();
                String usuario = (String) request.getSession(false).getAttribute("user");
                if (usuario == null) {
                    if (!response.isCommitted()) {
                        rd = request.getRequestDispatcher("index.jsp");
                        rd.forward(request, response);
                    }

                } else {
                    listaUsuarios = daoUsuario.consultar();

                    if (listaUsuarios != null) {
                        for (Usuario miUsuario : listaUsuarios) {
                            if (usuario.equals(miUsuario.getNombreUsuario())) {
                                localUsuario = miUsuario;
                                UserID = miUsuario.getIdUsuario();
                                break;
                            }
                        }
                    }

                    titulo = request.getParameter("txtTitulo");
                    cuerpo = request.getParameter("txtCuerpo");

                    if (titulo.equals("")) {
                        errores.add("<p>Debe de ingresar el titulo</p>");
                    }
                    if (cuerpo.equals("")) {
                        errores.add("<p>Debe de ingresar la descripción</p>");
                    }

                    if (errores.isEmpty()) {

                        miPubli.setTitulo(titulo);
                        miPubli.setCuerpo(cuerpo);
                        miPubli.setUsuario_IdUsuario(UserID);

                        DAOPublicacion aOEvento2 = new DAOPublicacion();

                        try {
                            //aOEvento.insertarConPublicacion(miPubli, miEvento);
                            aOEvento2.insertar1(miPubli);

                        } catch (Exception e) {
                            System.out.println(e);
                        }

                        if (!response.isCommitted()) {
                            rd = request.getRequestDispatcher("feed.jsp");
                            rd.forward(request, response);
                        }
                    } else {
                        request.setAttribute("errores", errores);
                        request.setAttribute("stitulo", titulo);
                        request.setAttribute("scuerpo", cuerpo);

                        if (!response.isCommitted()) {
                            rd = request.getRequestDispatcher("crearPublicacion.jsp");
                            rd.forward(request, response);
                        }
                    }

                }

            }

            if (!response.isCommitted()) {
                rd = request.getRequestDispatcher("feed.jsp");
                rd.forward(request, response);
            }

        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
