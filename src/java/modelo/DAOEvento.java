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
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Kevin
 */
public class DAOEvento implements Operaciones {
    Database db = new Database();
    
    
    @Override
    public String insertar(Object obj) {
        String respuesta = "";
        Connection conn;
        PreparedStatement pst;
        ResultSet rs;
        /*SE OMITE INSERTAR LA FECHA DE CREACION PORQUE LA BASE DE DATOS LA REGISTRA, BASANDOSE EN LA QUERY CON EL NOW()*/
        String sql = "INSERT INTO pvplobby.evento (FechaComienzo, FechaFinalizacion, FechaCreacion, HoraTermino, HoraInicio, EsPrivado, Publicacion_IdPublicacion)  VALUES(?,?,date_format(now(), '%Y-%m-%d'),?,?,?,?);";
        Evento miEvento = (Evento)obj;
        try{
            Class.forName(db.getDriver());
            conn = DriverManager.getConnection(db.getUrl(), db.getUsuario(), db.getPasssword());
            pst = conn.prepareStatement(sql);
            pst.setObject(1, miEvento.getFechaComienzo());
            pst.setObject(2, miEvento.getFechaFinalizacion());
            /*SE OMITE LA FILA 3 DEBIDO A QUE LA QUERY INSERTA LOS VALORES*/
            pst.setObject(4, miEvento.getHoraTermino());
            pst.setObject(5, miEvento.getHoraInicio());
            pst.setInt(6, miEvento.getEsPrivado());
            //pst.setInt(7, miEvento.getPublicacion_IdPublicacion());
            int filas = pst.executeUpdate();
            //independiente de lo que se haga, Create, Update, Delete , se 
            //realiza una actualizacion de la tabla
            respuesta = "Se a guardado" + filas + "Eventos";
            conn.close();
        } catch (ClassNotFoundException | SQLException e) {
            respuesta = "se cayo esta ve..." + e.getMessage();
        }
        
        return respuesta;
    }
    
    public String insertar1(Object obj) {
        String respuesta = "";
        Connection conn;
        PreparedStatement pst;
        /*SE OMITE INSERTAR LA FECHA DE CREACION PORQUE LA BASE DE DATOS LA REGISTRA, BASANDOSE EN LA QUERY CON EL NOW()*/
        String sql = "INSERT INTO evento (FechaCreacion, FechaComienzo, FechaFinalizacion, HoraTermino, HoraInicio, EsPrivado, Publicacion_IdPublicacion) VALUES(date_format(now(), '%Y-%m-%d'),?,?,?,?,?,?);";
        Evento miEvento = (Evento)obj;
        try{
            Class.forName(db.getDriver());
            conn = DriverManager.getConnection(db.getUrl(), db.getUsuario(), db.getPasssword());
            pst = conn.prepareStatement(sql);
            pst.setObject(1, miEvento.getFechaComienzo());
            pst.setObject(2, miEvento.getFechaFinalizacion());
            /*SE OMITE LA FILA 3 DEBIDO A QUE LA QUERY INSERTA LOS VALORES*/
            pst.setObject(3, miEvento.getHoraTermino());
            pst.setObject(4, miEvento.getHoraInicio());
            pst.setInt(5, miEvento.getEsPrivado());
            pst.setInt(6, miEvento.getIdPublicacion());
            //pst.setInt(7, miEvento.getPublicacion_IdPublicacion());
            int filas = pst.executeUpdate();
            //independiente de lo que se haga, Create, Update, Delete , se 
            //realiza una actualizacion de la tabla
            respuesta = "Se a guardado" + filas + "Eventos";
            conn.close();
        } catch (ClassNotFoundException | SQLException e) {
            respuesta = "se cayo esta ve..." + e.getMessage();
        }
        
        return respuesta;
    }
    
    public void insertarConPublicacion(Object publicacion, Object evento) throws SQLException{

        Connection conn = null;
        PreparedStatement pst = null;
        PreparedStatement pst2 = null;
        ResultSet rs;
        /*SE OMITE INSERTAR LA FECHA DE CREACION PORQUE LA BASE DE DATOS LA REGISTRA, BASANDOSE EN LA QUERY CON EL NOW()*/
        String sql = "INSERT INTO publicacion (Titulo, Cuerpo, Usuario_IdUsuario) VALUES (?,?,?);";
        String sql2 = "INSERT INTO evento (FechaCreacion, FechaComienzo, FechaFinalizacion, HoraTermino, HoraInicio, EsPrivado, Publicacion_IdPublicacion) VALUES(date_format(now(), '%Y-%m-%d'),?,?,?,?,?,last_insert_id());";
        Evento miEvento = (Evento)evento;
        Publicacion miPubli = (Publicacion)publicacion;
        try{
            
            Class.forName(db.getDriver());
            conn = DriverManager.getConnection(db.getUrl(), db.getUsuario(), db.getPasssword());
            
            conn.setAutoCommit(false);
            pst = conn.prepareStatement(sql);
            pst2 = conn.prepareStatement(sql2);
            
             /*INSERT DE PUBLICACION*/
            pst.setString(1, miPubli.getTitulo());
            pst.setString(2, miPubli.getCuerpo());
            pst.setInt(3, miPubli.getUsuario_IdUsuario());
            
            /*INSERT DE EVENTO*/
            /*SE OMITE LA FILA 1,7 DEBIDO A QUE LA QUERY INSERTA LOS VALORES*/
            pst2.setObject(1, miEvento.getFechaComienzo());
            pst2.setObject(2, miEvento.getFechaFinalizacion());
            pst2.setObject(3, miEvento.getHoraInicio());
            pst2.setObject(4, miEvento.getHoraTermino());
            pst2.setInt(5, miEvento.getEsPrivado());
            //pst.setInt(7, miEvento.getPublicacion_IdPublicacion());
            conn.commit();
           
            
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e);
            if (conn != null) {
                try {
                System.err.print("Transaction is being rolled back");
                conn.rollback();
                } catch (SQLException ex) {
                    System.out.println(ex);
                }
            }
        }finally{
            if (pst != null) {
                pst.close();
            }
            if (pst2 != null) {
                pst2.close();
            }
            conn.setAutoCommit(true);
        }

    }
    
     public void insertarConPublicacion1(Object publicacion, Object evento) throws SQLException{

        Connection conn = null;
        PreparedStatement pst = null;
        PreparedStatement pst2 = null;
        ResultSet rs;
        /*SE OMITE INSERTAR LA FECHA DE CREACION PORQUE LA BASE DE DATOS LA REGISTRA, BASANDOSE EN LA QUERY CON EL NOW()*/
        String sql = "INSERT INTO publicacion (Titulo, Cuerpo, Usuario_IdUsuario) VALUES (?,?,?);";
        String sql2 = "INSERT INTO evento (FechaCreacion, FechaComienzo, FechaFinalizacion, HoraTermino, HoraInicio, EsPrivado, Publicacion_IdPublicacion)\n" +
                      " VALUES(date_format(now(), '%Y-%m-%d'),?,?,?,?,?,last_insert_id());";
        Evento miEvento = (Evento)evento;
        Publicacion miPubli = (Publicacion)publicacion;
        try{
            
            Class.forName(db.getDriver());
            conn = DriverManager.getConnection(db.getUrl(), db.getUsuario(), db.getPasssword());
            
            conn.setAutoCommit(false);
            pst = conn.prepareStatement(sql);
            pst2 = conn.prepareStatement(sql2);
            
             /*INSERT DE PUBLICACION*/
            pst.setString(1, miPubli.getTitulo());
            pst.setString(2, miPubli.getCuerpo());
            pst.setInt(3, miPubli.getUsuario_IdUsuario());
            
            /*INSERT DE EVENTO*/
            /*SE OMITE LA FILA 1,7 DEBIDO A QUE LA QUERY INSERTA LOS VALORES*/
            pst2.setObject(1, miEvento.getFechaComienzo());
            pst2.setObject(2, miEvento.getFechaFinalizacion());
            pst2.setObject(3, miEvento.getHoraInicio());
            pst2.setObject(4, miEvento.getHoraTermino());
            pst2.setInt(5, miEvento.getEsPrivado());
            //pst.setInt(7, miEvento.getPublicacion_IdPublicacion());
            conn.commit();
           
            
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e);
            if (conn != null) {
                try {
                System.err.print("Transaction is being rolled back");
                conn.rollback();
                } catch (SQLException ex) {
                    System.out.println(ex);
                }
            }
        }finally{
            if (pst != null) {
                pst.close();
            }
            if (pst2 != null) {
                pst2.close();
            }
            conn.setAutoCommit(true);
        }

    }

    @Override
    public String eliminar(Object obj) {
        /*Es mejor eliminar el evento mediante cascada de la bd 
        debido a que esta ligado a una publicacion. 
        Entonces no vale la pena borrarlo solo, eso si igual dejo la query
        
        DELETE FROM pvplobby.evento 
        WHERE
            IdEvento = ?;   
        
        */
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
    public LinkedList<Evento> consultar() {
        return null;
        
        /*-------------------------------- NOTA --------------------------------------------
        ESTA CUESTION SOLO INVOCA LA TABLA EVENTO PERO NO LOS OTROS DATOS ASOCIADOS A LA PUBLICACION
        USAR METODO*******************listadoEventos()*****************************
        */
        /*
       LinkedList<Evento> listaEventos = new LinkedList();
       Evento miEvento = new Evento();
       Connection conexion;
        PreparedStatement pst;
        ResultSet rs;
        String sql = "SELECT * FROM Evento;";
        try {
            Class.forName(db.getDriver());
            conexion = DriverManager.getConnection(db.getUrl(), db.getUsuario(), db.getPasssword());
            pst = conexion.prepareStatement(sql);
            rs = pst.executeQuery(); // para ejecutar la consulta
            //recorrer la tabla persona y agregar objetos a la listaPersona
            while (rs.next())
                //mientras haya otra fila en la tabla, avanza al siguiente
                miEvento.EventoUnico(rs.getInt("IdEvento"), rs.getDate("FechaComienzo"), rs.getDate("FechaFinalizacion"), 
                        rs.getDate("FechaCreacion"), rs.getTime("HoraTermino"), rs.getTime("HoraInicio"), rs.getInt("EsPrivado"), rs.getInt("Publicacion_IdPublicacion"));
                listaEventos.add(miEvento);
                // una vez finalizado, cerar la conexion a la DB
                conexion.close();
        } catch (SQLException e) {
            System.out.println("Error al sortear los eventos, Detalles: " + e.getMessage());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DAOEvento.class.getName()).log(Level.SEVERE, null, ex);
        }
     return listaEventos; */        
    }

    @Override
    public LinkedList<?> filtrar(String campo, String criterio) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    /*
        public Evento infoEvento(int id){
        Evento evt = new Evento();
        Connection conn;
        PreparedStatement pst;
        ResultSet rs;
        String sql = "select * from evento where IdEvento ="+ id +";";
        try {
            Class.forName(db.getDriver());
            conn = DriverManager.getConnection(db.getUrl(), db.getUsuario(), db.getPasssword());
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery(); // para ejecutar la consulta
            //recorrer la tabla persona y agregar objetos a la listaPersona
           if(rs.next()){
                evt.setFechaComienzo(rs.getDate("FechaComienzo"));
                evt.setFechaFinalizacion(rs.getDate("FechaFinalizacion"));
                evt.setFechaCreacion(rs.getDate("FechaCreacion"));
                evt.setHoraTermino(rs.getTime("HoraTermino"));
                evt.setHoraInicio(rs.getTime("HoraInicio"));
                evt.setEsPrivado(rs.getInt("EsPrivado"));
                evt.setPublicacion_IdPublicacion(rs.getInt("Publicacion_IdPublicacion"));
           }
                //mientras haya otra fila en la tabla, avanza al siguiente
                

                // una vez finalizado, cerar la conexion a la DB
                conn.close();
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e.toString());
        }
       return evt; //To change body of generated methods, choose Tools | Templates. //To change body of generated methods, choose Tools | Templates.
    }
    */
    public LinkedList<Evento> listadoEventos() {
        LinkedList<Evento> listaEventos = new LinkedList();
        Connection conexion;
        PreparedStatement pst;
        ResultSet rs;
        String sql = "SELECT p.IdPublicacion, p.Titulo, p.Cuerpo,u.IdUsuario, u.NombreUsuario, e.IdEvento, e.FechaComienzo, e.FechaFinalizacion, e.FechaCreacion, e.HoraTermino, e.HoraInicio, e.EsPrivado FROM publicacion AS p\n" +
                    "INNER JOIN evento AS e ON e.Publicacion_IdPublicacion = p.IdPublicacion\n" +
                    "INNER JOIN usuario AS u ON u.IdUsuario = p.Usuario_IdUsuario\n" +
                    "GROUP BY p.IdPublicacion desc;";
        try {
            Class.forName(db.getDriver());
            conexion = DriverManager.getConnection(db.getUrl(), db.getUsuario(), db.getPasssword());
            pst = conexion.prepareStatement(sql);
            rs = pst.executeQuery(); // para ejecutar la consulta
         
            //recorrer la tabla persona y agregar objetos a la listaPersona
            while (rs.next())
                //mientras haya otra fila en la tabla, avanza al siguiente
                
                /*NOTA EL ORDEN DE RECIBIR LOS DATOS TIENE QUE SER IGUAL AL DE LA QUERY Y AL DEL METODO DE LA CLASE SI NO GG*/

                listaEventos.add( new Evento(rs.getInt("IdEvento"),
                        rs.getObject("FechaComienzo", LocalDate.class),
                        rs.getObject("FechaFinalizacion", LocalDate.class),
                        rs.getObject("FechaCreacion", LocalDate.class), 
                        rs.getObject("HoraTermino", LocalTime.class), 
                        rs.getObject("HoraInicio", LocalTime.class),
                        rs.getInt("EsPrivado"),
                        rs.getInt("IdPublicacion"),
                        rs.getString("Titulo"),
                        rs.getString("Cuerpo"),
                        rs.getInt("IdUsuario"),
                        rs.getString("NombreUsuario")
                        ));
                // una vez finalizado, cerar la conexion a la DB
                conexion.close();
        } catch (SQLException e) {
            System.out.println("error al sortear los eventos ligados a publicaciones, Detalles: " + e.getMessage());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DAOEvento.class.getName()).log(Level.SEVERE, null, ex);
        }
       return listaEventos;
    }
    
}
