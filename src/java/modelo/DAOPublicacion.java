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

/**
 *
 * @author Kevin
 */
public class DAOPublicacion implements Operaciones {

    //VARIABLES DE TRABAJO
    public String ID_PUBLICACION = "IdPublicacion";
    public String TITULO = "Titulo";
    public String CUERPO = "Cuerpo";
    public String ID_USUARIO_PUBLICACION = "Usuario_IdUsuario";

    Database db = new Database();

    @Override
    public String insertar(Object obj) {
        String respuesta = "";
        Connection conn;
        PreparedStatement pst;
        ResultSet rs;
        String sql = "INSERT INTO Evento ("+TITULO+", "+CUERPO+", "+ID_USUARIO_PUBLICACION+") VALUES(?,?,?);";
        Publicacion miPublicacion = (Publicacion)obj;
        try{
            Class.forName(db.getDriver());
            conn = DriverManager.getConnection(db.getUrl(), db.getUsuario(), db.getPasssword());
            pst = conn.prepareStatement(sql);
            pst.setString(1, miPublicacion.getTitulo());
            pst.setString(2, miPublicacion.getCuerpo());
            pst.setInt(3, miPublicacion.getUsuario_IdUsuario());
            int filas = pst.executeUpdate();
            //independiente de lo que se haga, Create, Update, Delete , se 
            //realiza una actualizacion de la tabla
            respuesta = "Se a guardado" + filas + " Eventos Nuevos";
            conn.close();
        } catch (ClassNotFoundException | SQLException e) {
            respuesta = "se cayo esta ve..." + e.toString();
        }
        
        return respuesta;
    }

    @Override
    public String eliminar(Object obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public String eliminarPublicacion(int idPublicacion){
        String respuesta = "";
        Connection conn;
        PreparedStatement pst;
        ResultSet rs;
        String sql = "DELETE FROM publicacion WHERE ID ="+ idPublicacion+";";
        try{
            Class.forName(db.getDriver());
            conn = DriverManager.getConnection(db.getUrl(), db.getUsuario(), db.getPasssword());
            pst = conn.prepareStatement(sql);
            pst.setInt(1, idPublicacion);
            int filas = pst.executeUpdate();
            //independiente de lo que se haga, Create, Update, Delete , se 
            //realiza una actualizacion de la tabla
            respuesta = "Se Eliminado Publicacion ID: " + idPublicacion;
            conn.close();
        } catch (ClassNotFoundException | SQLException e) {
            respuesta = "se cayo esta ve..." + e.toString();
        }
        
        return respuesta;
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
    public LinkedList<Publicacion> consultar() {
        LinkedList<Publicacion> listaPublicacion = new LinkedList<>();
        Connection conexion;
        PreparedStatement pst;
        ResultSet rs;
        String sql = "select * from publicacion";
        try {
            Class.forName(db.getDriver());
            conexion = DriverManager.getConnection(db.getUrl(), db.getUsuario(), db.getPasssword());
            pst = conexion.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next())
                listaPublicacion.add(new Publicacion(rs.getInt("IdPublicacion"),
                        rs.getString(TITULO),
                        rs.getString(CUERPO),
                        rs.getInt(ID_USUARIO_PUBLICACION)
                ));
                conexion.close();
            

        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Errores al consultar publicaciones: "+ e.getMessage());
        }
        return listaPublicacion;

    }

    @Override
    public LinkedList<?> filtrar(String campo, String criterio) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
