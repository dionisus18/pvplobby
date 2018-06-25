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
            pst.setDate(1, miEvento.getFechaComienzo());
            pst.setDate(2, miEvento.getFechaFinalizacion());
            /*SE OMITE LA FILA 3 DEBIDO A QUE LA QUERY INSERTA LOS VALORES*/
            pst.setTime(4, miEvento.getHoraTermino());
            pst.setTime(5, miEvento.getHoraInicio());
            pst.setInt(6, miEvento.getEsPrivado());
            pst.setInt(7, miEvento.getPublicacion_IdPublicacion());
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
        
        /*-------------------------------- NOTA --------------------------------------------
        ESTA CUESTION SOLO INVOCA LA TABLA EVENTO PERO NO LOS OTROS DATOS ASOCIADOS A LA PUBLICACION
        USAR METODO*******************listadoEventos()*****************************
        */
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
       return listaEventos;       
    }

    @Override
    public LinkedList<?> filtrar(String campo, String criterio) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public LinkedList<Evento> listadoEventos() {
        LinkedList<Evento> listaEventos = new LinkedList();
        Connection conexion;
        PreparedStatement pst;
        ResultSet rs;
        String sql = "SELECT * FROM pvplobby.evento INNER JOIN pvplobby.publicacion ON IdPublicacion = Publicacion_IdPublicacion;";
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
                        rs.getDate("FechaComienzo"),
                        rs.getDate("FechaFinalizacion"),
                        rs.getDate("FechaCreacion"), 
                        rs.getTime("HoraTermino"), 
                        rs.getTime("HoraInicio"),
                        rs.getInt("EsPrivado"),
                        rs.getInt("Publicacion_IdPublicacion"),
                        rs.getInt("IdPublicacion"),
                        rs.getString("Titulo"),
                        rs.getString("Cuerpo"),
                        rs.getInt("Usuario_IdUsuario")
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
