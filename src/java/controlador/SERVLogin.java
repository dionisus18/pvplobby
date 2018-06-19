package controlador;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import modelo.DAOUsuario;

import modelo.Usuario;


/**
 *
 * @author Kevin
 */
@WebServlet(urlPatterns = {"/SERVLogin"})
public class SERVLogin extends HttpServlet {

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
            /* TODO output your page here. You may use following sample code. */
            DAOUsuario daoUsuario = new DAOUsuario();
            Usuario localUsuario = new Usuario();
            String respuesta = "";
            String errores = "";
            boolean validador = false;
            String usuario = request.getParameter("usuario");
            String pass = request.getParameter("pass");
            RequestDispatcher rd = null;//hay que importalo
            
            LinkedList<Usuario> listaUsuarios = new LinkedList<>();
            
            try {
                if (request.getParameter("btnLogin") != null) {
                    
                    listaUsuarios = daoUsuario.consultar();
                    
                    if (listaUsuarios != null) {
                        for (Usuario listaUsuario : listaUsuarios) {
                            if (!usuario.equals("") && !pass.equals("")) {
                            if (!usuario.equals(listaUsuario.getNombreUsuario()) && !pass.equals(listaUsuario.getContraseña())) {
                                validador = false;
                            }else{
                                validador = true;
                                break;
                            }    
                            }
                        }
                    }
                    if (!validador) {
                        errores += "<p>Usuario o contraseña incorrectos</p>";
                    }
                    
                    if (usuario.equals("")) {
                        errores += "<p>Debe de ingresar el Usuario</p>";
                    }
                    if (pass.equals("")) {
                        errores += "<p>Debe de ingresar la Contraseña</p>";
                    }
                    
                    if (errores.equals("") && validador) {
                        
                        request.setAttribute("sUsuario", usuario);
                        if(!response.isCommitted()){
                        rd = request.getRequestDispatcher("perfil.jsp");
                        rd.forward(request, response);
                        }
                    }else{
                        request.setAttribute("susuario", usuario);
                        request.setAttribute("serrores", errores);
                        if(!response.isCommitted()){
                        rd = request.getRequestDispatcher("login.jsp");
                        rd.forward(request, response);
                        }
                    }
                }
            } catch (IOException | ServletException e) {
                respuesta = e.getMessage();
                request.setAttribute("respuesta", respuesta);
                rd = request.getRequestDispatcher("login.jsp");
                rd.forward(request, response);
                
            }
            if(!response.isCommitted()){
            rd = request.getRequestDispatcher("login.jsp");
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
