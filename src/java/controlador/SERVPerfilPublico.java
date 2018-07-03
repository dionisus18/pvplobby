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
import modelo.DAOPublicacion;
import modelo.DAOUsuario;
import modelo.Perfil;
import modelo.Publicacion;
import modelo.Usuario;

/**
 *
 * @author Kevin
 */
public class SERVPerfilPublico extends HttpServlet {

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
            DAOPerfil aOPerfil = new DAOPerfil();
            DAOUsuario aOUsuario = new DAOUsuario();
            LinkedList<Perfil> linkedList = aOPerfil.consultar();
            LinkedList<Usuario> linkedList2 = aOUsuario.consultar();
            LinkedList<Publicacion> linkedList3 = new LinkedList<>();
            Usuario localU = new Usuario();
            Perfil PerfilU = new Perfil();

            if (request.getSession(false).getAttribute("user") == null) {
                if (!response.isCommitted()) {
                    RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
                    rd.forward(request, response);
                }
            } else if (request.getParameter("idUsuario") != null) {
                int idUsuario = 0;
                try {
                    idUsuario = Integer.parseInt(request.getParameter("idUsuario"));
                } catch (NumberFormatException e) {
                    System.out.println(e);
                }
 
                for (Usuario aux : linkedList2) {
                    if (idUsuario == aux.getIdUsuario()) {
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
                DAOPublicacion dao3 = new DAOPublicacion();
                int count= dao3.contador(localU.getIdUsuario());
                int seguidores = dao3.seguidores(localU.getIdUsuario());
                int seguir = dao3.seguidos(localU.getIdUsuario());
                request.setAttribute("sseguidores", seguidores);
                request.setAttribute("sseguidos", seguir);
                request.setAttribute("spublicaciones", count);
                linkedList3 = dao3.seleccionarEventos(localU.getIdUsuario());
                request.setAttribute("listPublicacion", linkedList3);
                
                if (!response.isCommitted()) {
                    RequestDispatcher rd = request.getRequestDispatcher("perfilPublico.jsp");
                    rd.forward(request, response);
                }
            }

            if (!response.isCommitted()) {
                RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
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
