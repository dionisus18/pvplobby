/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.DAOPerfil;
import modelo.DAOUsuario;
import modelo.Perfil;
import modelo.Usuario;

/**
 *
 * @author Kevin
 */
public class SERVModificarPerfil extends HttpServlet {

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

            DAOPerfil aOPerfil = new DAOPerfil();
            DAOUsuario aOUsuario = new DAOUsuario();
            LinkedList<Perfil> linkedList = aOPerfil.consultar();
            LinkedList<Usuario> linkedList2 = aOUsuario.consultar();
            Usuario localU = new Usuario();
            Perfil PerfilU = new Perfil();

            if (request.getSession(false).getAttribute("user") == null) {
                if (!response.isCommitted()) {
                    RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
                    rd.forward(request, response);
                }
            } else {
                String Usuario = (String) request.getSession(false).getAttribute("user");
                for (Usuario aux : linkedList2) {
                    if (Usuario.equals(aux.getNombreUsuario())) {
                        localU = aux;
                        request.setAttribute("susario", localU);
                        break;
                    }
                }
                for (Perfil aux : linkedList) {
                    if (localU.getIdUsuario() == aux.getUsuario_IdUsuario()) {
                        PerfilU = aux;
                        request.setAttribute("sperfil", PerfilU);
                        break;
                    }
                }
                if (!response.isCommitted()) {
                    RequestDispatcher rd = request.getRequestDispatcher("modificarPerfil.jsp");
                    rd.forward(request, response);
                }
            }

            if (!response.isCommitted()) {
                RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
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
        DAOUsuario daoUsuario = new DAOUsuario();
        DAOPerfil daoPerfil = new DAOPerfil();
        Usuario localUsuario = new Usuario();
        Perfil localPerfil = new Perfil();

//Atributos
        String respuesta = "";
        String errores = "";
        String nombre = request.getParameter("txtnombre");
        String fechanacimiento = request.getParameter("txtfechanacimiento");
        String biografia = request.getParameter("txtbiografia");
        String idpersonal = request.getParameter("txtidpersonal");
        String usuario = request.getParameter("txtusuario");
        String email = request.getParameter("txtemail");

        RequestDispatcher rd = null;//hay que importalo
        LinkedList<Usuario> listaUsuarios = new LinkedList<>();
        LinkedList<Perfil> PerList = new LinkedList<>();

        try {
            if (request.getParameter("btnModificarPerfil") != null) {
                    DAOPerfil aOPerfil = new DAOPerfil();
            DAOUsuario aOUsuario = new DAOUsuario();
            LinkedList<Perfil> linkedList = aOPerfil.consultar();
            LinkedList<Usuario> linkedList2 = aOUsuario.consultar();
            Usuario localU = new Usuario();
            Perfil PerfilU = new Perfil();

            if (request.getSession(false).getAttribute("user") == null) {
                if (!response.isCommitted()) {
                    rd = request.getRequestDispatcher("index.jsp");
                    rd.forward(request, response);
                }
            } else {
                String Usuario = (String) request.getSession(false).getAttribute("user");
                for (Usuario aux : linkedList2) {
                    if (Usuario.equals(aux.getNombreUsuario())) {
                        localU = aux;
                        request.setAttribute("susario", localU);
                        break;
                    }
                }
                for (Perfil aux : linkedList) {
                    if (localU.getIdUsuario() == aux.getUsuario_IdUsuario()) {
                        PerfilU = aux;
                        request.setAttribute("sperfil", PerfilU);
                        break;
                    }
                }
            
                Perfil idPerfil = (Perfil) (request.getAttribute("sperfil"));
                if (biografia.equals("")) {
                    errores += "<p>Debe la Biografia</p>";
                }
                if (errores.equals("")) {
                    PerfilU.setBiografia(biografia);
                    daoPerfil.ActualizarBiografia(PerfilU);
                    if (!response.isCommitted()) {
                        rd = request.getRequestDispatcher("modificarPerfil.jsp");
                        rd.forward(request, response);
                    }
                }

            }
            }
        } catch (IOException | ServletException e) {
            System.out.println(e);
        }

        try {
            if (request.getParameter("btnEditarPerfil") != null) {
                DAOPerfil aOPerfil = new DAOPerfil();
                DAOUsuario aOUsuario = new DAOUsuario();
                LinkedList<Perfil> linkedList = aOPerfil.consultar();
                LinkedList<Usuario> linkedList2 = aOUsuario.consultar();
                Usuario localU = new Usuario();
                Perfil PerfilU = new Perfil();

                if (request.getSession(false).getAttribute("user") == null) {
                    if (!response.isCommitted()) {
                        rd = request.getRequestDispatcher("index.jsp");
                        rd.forward(request, response);
                    }
                } else {
                    String Usuario = (String) request.getSession(false).getAttribute("user");
                    for (Usuario aux : linkedList2) {
                        if (Usuario.equals(aux.getNombreUsuario())) {
                            localU = aux;
                            request.setAttribute("susario", localU);
                            break;
                        }
                    }
                    for (Perfil aux : linkedList) {
                        if (localU.getIdUsuario() == aux.getUsuario_IdUsuario()) {
                            PerfilU = aux;
                            request.setAttribute("sperfil", PerfilU);
                            break;
                        }
                    }
                    if (!response.isCommitted()) {
                        rd = request.getRequestDispatcher("modificarPerfil.jsp");
                        rd.forward(request, response);
                    }
                }
                if (!response.isCommitted()) {
                    rd = request.getRequestDispatcher("modificarPerfil.jsp");
                    rd.forward(request, response);
                }
            }

        } catch (IOException | ServletException e) {
        }

        try {
            if (request.getParameter("btnCambiarContraseña") != null) {
                String pass = request.getParameter("txtpass");
                String passnew = request.getParameter("txtpassnew");
                String passnew2 = request.getParameter("txtpassnew2");

                if (pass.equals("")) {
                    errores += "<p>Debe de ingresar la Actual Contraseña</p>";
                } else {
                }
                if (passnew.equals("")) {
                    errores += "<p>Debe de ingresar la Nueva Contraseña</p>";
                }
                if (passnew2.equals("")) {
                    errores += "<p>Debe de ingresar la Contraseña de confirmacion</p>";
                }
                if (!passnew.equals(passnew2)) {
                    errores += "<p>Las contraseñas ingresadas no coninciden</p>";
                }
            }

        } catch (Exception e) {
        }

        if (!response.isCommitted()) {
            rd = request.getRequestDispatcher("index.jsp");
            rd.forward(request, response);
        }
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
