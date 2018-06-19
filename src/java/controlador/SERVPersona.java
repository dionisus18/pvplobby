package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.DAOPersona;
import modelo.DAOProvincia;
import modelo.DAORegion;
import modelo.Persona;
import modelo.Provincia;
import modelo.Region;

public class SERVPersona extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8;");
        try (PrintWriter out = response.getWriter()) {
            //INTERMEDIARIO ENTRE CLIENTE Y LA BASE DE DATOS
            DAOPersona dao = new DAOPersona();
            Persona p = new Persona();
            LinkedList<Persona> listaPersonas = new LinkedList();
            String respuesta = "";
            String errores = "";
            String nombre = request.getParameter("txtNombre");
            String apellido = request.getParameter("txtApellido");
            String provincia = request.getParameter("txtProvincia");
            String region = request.getParameter("txtRegion");
            String fechaN = request.getParameter("txtFechaN");
            String Run = request.getParameter("txtRUN");
            String imagen = request.getParameter("txtRuta");
            RequestDispatcher rd = null;//hay que importalo

            try {
                    DAOProvincia dao1 = new DAOProvincia();
                    DAORegion dao2 = new DAORegion();
                    LinkedList<Provincia> listaProvincias = new LinkedList();
                    LinkedList<Region> listaRegiones = new LinkedList();
                //Es para los botones del formulario
                if (request.getParameter("btnGuardar") != null) {

                    if (nombre.equals("")) {
                        errores += "<p>Debe de ingresar el nombre</p>";
                    }
                    if (fechaN.equals("")) {
                        errores += "<p>Debe de ingresar la fecha de nacimiento</p>";
                    }
                    if (apellido.equals("")) {
                        errores += "<p>Debe de ingresar el apellido</p>";
                    }
                    if (Run.equals("")) {
                        errores += "<p>Debe de ingresar el RUN</p>";
                    }
                    if (imagen.equals("")) {
                        errores += "<p>Debe de ingresar la url de la imagen</p>";
                    }
                    
                    
                    
                    if (errores.equals("")) {
                        p.setRUN(Run);
                        p.setNombre(nombre);
                        p.setApellido(apellido);
                        p.setProvincia((p.calcularProvincia(provincia)));
                        p.setRegion(p.calcularRegion(region));
                        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                        LocalDate fechaNac = LocalDate.parse(fechaN, fmt);
                        Date date = java.sql.Date.valueOf(fechaNac);
                        p.setFnacimiento(date);
                        p.setRuta(imagen);
                        respuesta = dao.insertar(p); // es el retorno que se tiene al INSERT
                        request.setAttribute("respuesta", respuesta);

                    } else {
                        request.setAttribute("sNombre", nombre);
                        request.setAttribute("sRUN", Run);
                        request.setAttribute("sApellido", apellido);
                        request.setAttribute("sImagen", imagen);
                        request.setAttribute("sErrores", errores);
                        rd = request.getRequestDispatcher("index.jsp");
                        rd.forward(request, response);
                    }
                }
            } catch (NumberFormatException e) {
            }
            if (request.getParameter("btnModificar") != null) {
                if (nombre.equals("")) {
                    errores += "<p>Debe de ingresar el nombre</p>";
                }
                if (apellido.equals("")) {
                    errores += "<p>Debe de ingresar el apellido</p>";
                }
                if (Run.equals("")) {
                    errores += "<p>Debe de ingresar el RUN</p>";
                }
                if (imagen.equals("")) {
                    errores += "<p>Debe de ingresar la url de la imagen</p>";
                }
                if (fechaN.equals("")) {
                    errores += "<p>Debe de ingresar la fecha de nacimiento</p>";
                }
                if (provincia.equals("")) {
                    errores += "<p>Debe de ingresar la provincia</p>";
                }
                if (region.equals("")) {
                    errores += "<p>Debe de ingresar la region</p>";
                }
                if (errores.equals("")) {
                    p.setRUN(request.getParameter("txtRUN"));
                    p.setNombre(request.getParameter("txtNombre"));
                    p.setApellido(request.getParameter("txtApellido"));
                    p.setRuta(request.getParameter("txtRuta"));
                    p.setID(Integer.parseInt(request.getParameter("txtID")));
                    respuesta = dao.modificar(p); // es el retorno que se tiene al UPDATE
                    request.setAttribute("respuesta", respuesta);
                } else {
                    request.setAttribute("sNombre", nombre);
                    request.setAttribute("sRUN", Run);
                    request.setAttribute("sApellido", apellido);
                    request.setAttribute("sImagen", imagen);
                    request.setAttribute("sErrores", errores);
                    rd = request.getRequestDispatcher("index.jsp");
                    rd.forward(request, response);
                }
            } else if (request.getParameter("btnEliminar") != null) {
                p.setID(Integer.parseInt(request.getParameter("txtID")));
                respuesta = dao.eliminar(p); // es el retorno que se tiene al DELETE
                request.setAttribute("respuesta", respuesta);
            }
            rd = request.getRequestDispatcher("index.jsp");
            rd.forward(request, response);
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
