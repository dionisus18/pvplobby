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
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.DAOUsuario;
import modelo.Perfil;
import modelo.Usuario;

/**
 *
 * @author Kevin
 */
@WebServlet(name = "SERVUsuario", urlPatterns = {"/SERVUsuario"})
public class SERVUsuario extends HttpServlet {

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
            /* TODO output your page here. You may use following sample code. */
            DAOUsuario daoUsuario = new DAOUsuario();
            Usuario localUsuario = new Usuario();
            Perfil localPerfil = new Perfil();
            String respuesta = "";
            String errores = "";
            String nombre = request.getParameter("nombre");
            String usuario = request.getParameter("usuario");
            String email = request.getParameter("email");
            String pass = request.getParameter("pass");
            String pass2 = request.getParameter("pass2");
            RequestDispatcher rd = null;//hay que importalo
            LinkedList<Usuario> listaUsuarios = new LinkedList<>();

            
            try {
                if (request.getParameter("btnRegistro") != null) {
                    
                    listaUsuarios = daoUsuario.consultar();
                    
                    if (listaUsuarios != null) {
                        for (Usuario listaUsuario : listaUsuarios) {
                            if (!usuario.equals("")) {
                            if (usuario.equals(listaUsuario.getNombreUsuario())) {
                                errores += "<p>Ese Usuario ya esta registrado</p>";
                            }    
                            }
                            if (!email.equals("")){
                            if (email.equals(listaUsuario.getEmail())) {
                                errores += "<p>Ese Correo ya esta registrado</p>";   
                            }
                            }

                            
                        }
                    }
                    
                    if (nombre.equals("")) {
                        errores += "<p>Debe de ingresar el Nombre</p>";
                    }
                    if (usuario.equals("")) {
                        errores += "<p>Debe de ingresar el Usuario</p>";
                    }
                    if (email.equals("")) {
                        errores += "<p>Debe de ingresar el Correo</p>";
                    }
                    if (pass.equals("")) {
                        errores += "<p>Debe de ingresar la Contraseña</p>";
                    }
                    if (pass2.equals("")) {
                        errores += "<p>Debe de ingresar la Contraseña de confirmacion</p>";
                    }
                    
                    if(!pass2.equals("") && !pass.equals("")){
                        if (!pass.equals(pass2)) {
                            errores += "<p>Las Contraseñas no coinciden</p>";
                        }
                    }
                    
                    if (errores.equals("")) {
                        localUsuario.setNombreUsuario(usuario);
                        localUsuario.setEmail(email);
                        localUsuario.setContraseña(pass);
                        respuesta = daoUsuario.insertar(localUsuario); // es el retorno que se tiene al INSERT
                        request.setAttribute("respuesta", respuesta);
                    }else{
                        request.setAttribute("snombre", nombre);
                        request.setAttribute("susuario", usuario);
                        request.setAttribute("semail", email);
                        request.setAttribute("serrores", errores);
                        rd = request.getRequestDispatcher("index.jsp");
                        rd.forward(request, response);
                    }
                }
            } catch (IOException | ServletException e) {
                respuesta = e.getMessage();
                request.setAttribute("respuesta", respuesta);
                rd = request.getRequestDispatcher("index.jsp");
                rd.forward(request, response);
                
            }
            if(!response.isCommitted()){
            rd = request.getRequestDispatcher("index.jsp");
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
