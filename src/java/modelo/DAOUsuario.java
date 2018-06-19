/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Kevin
 */


public class DAOUsuario implements Operaciones{
    
    Database db = new Database();
    
    @Override
    public String insertar(Object obj) {
        String respuesta = "";
        Connection conn;
        PreparedStatement pst;
        ResultSet rs;
        String sql = "INSERT INTO usuario (NombreUsuario, Contraseña, Email) VALUES(?,?,?);";
        Usuario u = (Usuario)obj;
        try{
            Class.forName(db.getDriver());
            conn = DriverManager.getConnection(db.getUrl(), db.getUsuario(), db.getPasssword());
            pst = conn.prepareStatement(sql);
            pst.setString(1, u.getNombreUsuario());
            pst.setString(2, u.getContraseña());
            pst.setString(3, u.getEmail());
            int filas = pst.executeUpdate();
            //independiente de lo que se haga, Create, Update, Delete , se 
            //realiza una actualizacion de la tabla
            respuesta = "Se a guardado" + filas + " Usuarios nuevos";
            conn.close();
        }catch (SQLException e) {
             respuesta = "Ha ocurrido un error" + e.getMessage();
            System.out.println(e.getMessage());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DAOUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return respuesta;
    
    }
        public String insertarPerfilConNombre(Object obj) {
        String respuesta = "";
        Connection conn;
        PreparedStatement pst;
        ResultSet rs;
        String sql = "INSERT INTO perfil (Nombre, EsPublico, Usuario_IdUsuario) VALUES(?,?,?);";
        Perfil p = (Perfil)obj;
        try{
             try {
                 Class.forName(db.getDriver());
             } catch (ClassNotFoundException ex) {
                 Logger.getLogger(DAOUsuario.class.getName()).log(Level.SEVERE, null, ex);
             }
            conn = DriverManager.getConnection(db.getUrl(), db.getUsuario(), db.getPasssword());
            pst = conn.prepareStatement(sql);
            pst.setString(1, p.getNombre());
            pst.setInt(2, p.getEsPublico());
            pst.setInt(3, p.getUsuario_IdUsuario());
            int filas = pst.executeUpdate();
            //independiente de lo que se haga, Create, Update, Delete , se 
            //realiza una actualizacion de la tabla
            respuesta = "Se a guardado" + filas + " personas nuevas";
            conn.close();
        }catch (SQLException e) {
            respuesta = "Se a encontrado errores" + e.toString();
        }
        return respuesta;
    
    }

    @Override
    public String eliminar(Object obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String modificar(Object obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String consultas(Object obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public LinkedList<Usuario> consultar() {
         LinkedList<Usuario> listaUsuario = new LinkedList();
        Connection conn;
        PreparedStatement pst;
        ResultSet rs;
        String sql = "SELECT * FROM usuario;";
        try {
            Class.forName(db.getDriver());
            conn = DriverManager.getConnection(db.getUrl(), db.getUsuario(), db.getPasssword());
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery(); // para ejecutar la consulta
            //recorrer la tabla persona y agregar objetos a la listaPersona
            while (rs.next())
                //mientras haya otra fila en la tabla, avanza al siguiente
                
                listaUsuario.add( new Usuario(rs.getInt("IdUsuario"),
                        rs.getString("NombreUsuario"),
                        rs.getString("Contraseña"),
                        rs.getString("Email") 
                        ));
                // una vez finalizado, cerar la conexion a la DB
                conn.close();
        } catch (ClassNotFoundException | SQLException e) {
        //EXISTEN 2 exception (MULTICATCH)
        }
       return listaUsuario; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public LinkedList<?> filtrar(String campo, String criterio) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
