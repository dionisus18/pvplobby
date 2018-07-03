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
    public String NOMBRE_USUARIO = "NombreUsuario";

    Database db = new Database();

    @Override
    public String insertar(Object obj) {
        String respuesta = "";
        Connection conn;
        PreparedStatement pst = null;
        ResultSet rs;
        String sql = "INSERT INTO publicacion (Titulo, Cuerpo, Usuario_IdUsuario) VALUES (?,?,?);";
        Publicacion miPublicacion = (Publicacion)obj;
        try{
            Class.forName(db.getDriver());
            conn = DriverManager.getConnection(db.getUrl(), db.getUsuario(), db.getPasssword());
            pst = conn.prepareStatement(sql, pst.RETURN_GENERATED_KEYS);
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
        public int insertar1(Object obj) {
        int idPublicacion = 0;
        Connection conn;
        PreparedStatement pst = null;
        ResultSet rs;
        String sql = "INSERT INTO publicacion (Titulo, Cuerpo, Usuario_IdUsuario) VALUES (?,?,?);";
        Publicacion miPublicacion = (Publicacion)obj;
        try{
            Class.forName(db.getDriver());
            conn = DriverManager.getConnection(db.getUrl(), db.getUsuario(), db.getPasssword());
            pst = conn.prepareStatement(sql, pst.RETURN_GENERATED_KEYS);
            pst.setString(1, miPublicacion.getTitulo());
            pst.setString(2, miPublicacion.getCuerpo());
            pst.setInt(3, miPublicacion.getUsuario_IdUsuario());
            int filas = pst.executeUpdate();
            //independiente de lo que se haga, Create, Update, Delete , se 
            //realiza una actualizacion de la tabla
            try (ResultSet generatedKeys = pst.getGeneratedKeys()){
                if (generatedKeys.next()) {
                    idPublicacion = generatedKeys.getInt(1);
                }
            } catch (Exception e) {
            }
            conn.close();
        } catch (ClassNotFoundException | SQLException e) {
            
        }
        
        return idPublicacion;
    }
    

    @Override
    public String eliminar(Object obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
        public LinkedList<Publicacion> seleccionarEventos(int idUsuario){
        LinkedList<Publicacion> listaPublicaciones = new LinkedList();
        Publicacion evento = new Publicacion();
        Connection conn;
        PreparedStatement pst;
        ResultSet rs;
        String sql = "select * from publicacion where Usuario_IdUsuario ="+ idUsuario +";";
        
        try {
            Class.forName(db.getDriver());
            conn = DriverManager.getConnection(db.getUrl(), db.getUsuario(), db.getPasssword());
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery(); // para ejecutar la consulta
            //recorrer la tabla persona y agregar objetos a la listaPersona
           while(rs.next())
               listaPublicaciones.add(new Publicacion(rs.getInt("IdPublicacion"),
                rs.getString(TITULO),
                rs.getString(CUERPO),
                rs.getInt(ID_USUARIO_PUBLICACION)   
               ));
           
           conn.close();
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e.toString());
        }
      
     return listaPublicaciones;
    
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
        String sql =    "select p.IdPublicacion, p.Titulo, p.Cuerpo, p.Usuario_IdUsuario, u.NombreUsuario from publicacion as p\n" +
                        "inner join usuario as u on u.IdUsuario = p.Usuario_IdUsuario\n" +
                        "where not exists (select * from evento e where e.Publicacion_IdPublicacion = p.IdPublicacion)\n" +
                        "GROUP BY p.IdPublicacion desc;";
        try {
            Class.forName(db.getDriver());
            conexion = DriverManager.getConnection(db.getUrl(), db.getUsuario(), db.getPasssword());
            pst = conexion.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next())
                listaPublicacion.add(new Publicacion(rs.getInt("IdPublicacion"),
                        rs.getString(TITULO),
                        rs.getString(CUERPO),
                        rs.getInt(ID_USUARIO_PUBLICACION),
                        rs.getString(NOMBRE_USUARIO)
                ));
                conexion.close();
            

        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Errores al consultar publicaciones: "+ e.getMessage());
        }
        return listaPublicacion;

    }
        public int contador(int id) {
        Connection conn;
        PreparedStatement pst;
        ResultSet rs;
        String sql = "select Count(*) from publicacion where Usuario_IdUsuario =" + id + ";";
        int count = 0;

        try {
            Class.forName(db.getDriver());
            conn = DriverManager.getConnection(db.getUrl(), db.getUsuario(), db.getPasssword());
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery(); // para ejecutar la consulta
            //recorrer la tabla persona y agregar objetos a la listaPersona
            while (rs.next()) {
                count = rs.getInt(1);
            }

            conn.close();
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e.toString());
        }

        return count;

    }

    public int seguidores(int id) {
        Connection conn;
        PreparedStatement pst;
        ResultSet rs;
        String sql = "select Count(*) from Usuario_sigue_usuario where Usuario_IdUsuario=" + id + ";";
        int count = 0;

        try {
            Class.forName(db.getDriver());
            conn = DriverManager.getConnection(db.getUrl(), db.getUsuario(), db.getPasssword());
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery(); // para ejecutar la consulta
            //recorrer la tabla persona y agregar objetos a la listaPersona
            while (rs.next()) {
                count = rs.getInt(1);
            }

            conn.close();
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e.toString());
        }

        return count;

    }

    public int seguidos(int id) {
        Connection conn;
        PreparedStatement pst;
        ResultSet rs;
        String sql = "select Count(*) from Usuario_sigue_usuario where Usuario_IdUsuario =" + id + ";";
        int count = 0;

        try {
            Class.forName(db.getDriver());
            conn = DriverManager.getConnection(db.getUrl(), db.getUsuario(), db.getPasssword());
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery(); // para ejecutar la consulta
            //recorrer la tabla persona y agregar objetos a la listaPersona
            while (rs.next()) {
                count = rs.getInt(1);
            }

            conn.close();
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e.toString());
        }

        return count;

    }

    @Override
    public LinkedList<?> filtrar(String campo, String criterio) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
