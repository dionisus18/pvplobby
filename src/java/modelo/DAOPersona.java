
package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;


public class DAOPersona implements Operaciones{
    
    //Lo primero: crear el objeto de Base de datos
    Database db = new Database();
    
    @Override
    public String insertar(Object obj) {
        String respuesta = "";
        Connection conn;
        PreparedStatement pst;
        ResultSet rs;
        String sql = "INSERT INTO Persona (RUN, Nombre, Apellido,provincia_id,region_id,fnacimiento, Imagen) VALUES(?,?,?,?,?,?,?);";
        Persona p = (Persona)obj;
        try{
            Class.forName(db.getDriver());
            conn = DriverManager.getConnection(db.getUrl(), db.getUsuario(), db.getPasssword());
            pst = conn.prepareStatement(sql);
            pst.setString(1, p.getRUN());
            pst.setString(2, p.getNombre());
            pst.setString(3, p.getApellido());
            pst.setInt(4, p.getProvincia());
            pst.setInt(5, p.getRegion());
            pst.setDate(6, p.getFnacimiento());
            pst.setString(7, p.getRuta());
            int filas = pst.executeUpdate();
            //independiente de lo que se haga, Create, Update, Delete , se 
            //realiza una actualizacion de la tabla
            respuesta = "Se a guardado" + filas + " personas nuevas";
            conn.close();
        } catch (ClassNotFoundException | SQLException e) {
            respuesta = "se cayo esta ve..." + e.toString();
        }
        
        return respuesta;
    }


    @Override
    public String eliminar(Object obj) {
        String respuesta = "";
        Connection conn;
        PreparedStatement pst;
        ResultSet rs;
        String sql = "DELETE From Persona WHERE ID = ?;";
        Persona p = (Persona)obj;
        try{
            Class.forName(db.getDriver());
            conn = DriverManager.getConnection(db.getUrl(), db.getUsuario(), db.getPasssword());
            pst = conn.prepareStatement(sql);
            pst.setInt(1, p.getID());
            int filas = pst.executeUpdate();
            //independiente de lo que se haga, Create, Update, Delete , se 
            //realiza una actualizacion de la tabla
            respuesta = "Se a Eliminado a la persona con ID: " + p.getID();
            conn.close();
        } catch (ClassNotFoundException | SQLException e) {
            respuesta = "se cayo esta ve..." + e.toString();
        }
        
        return respuesta;
    }

    @Override
    public String consultas(Object obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    

    @Override
    public LinkedList<Persona> consultar() {
       //Se reemplaza el ? por la Clase
       // y un retorno
       LinkedList<Persona> listaPersonas = new LinkedList();
       Connection conn;
        PreparedStatement pst;
        ResultSet rs;
        String sql = "SELECT * FROM persona;";
        try {
            Class.forName(db.getDriver());
            conn = DriverManager.getConnection(db.getUrl(), db.getUsuario(), db.getPasssword());
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery(); // para ejecutar la consulta
            //recorrer la tabla persona y agregar objetos a la listaPersona
            while (rs.next())
                //mientras haya otra fila en la tabla, avanza al siguiente
                
                listaPersonas.add( new Persona(rs.getInt("ID"),
                        rs.getString("RUN"),
                        rs.getString("nombre"),
                        rs.getString("apellido"), 
                        rs.getInt("PROVINCIA_id"), 
                        rs.getInt("REGION_id"), 
                        rs.getDate("fnacimiento"), 
                        rs.getString("imagen")
                        ));
                // una vez finalizado, cerar la conexion a la DB
                conn.close();
        } catch (ClassNotFoundException | SQLException e) {
        //EXISTEN 2 exception (MULTICATCH)
        }
       return listaPersonas;
    }

    @Override
    public LinkedList<?> filtrar(String campo, String criterio) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    //DAOPërsona se comunicara con Operaciones para que este realice las consultas a la DB
    //Crear metodos por default para luego cambiarlos

    @Override
    public String modificar(Object obj) {
        String respuesta = "";
        Connection conn;
        PreparedStatement pst;
        ResultSet rs;
        String sql = "UPDATE Persona SET RUN = ?, Nombre = ?, Apellido = ?, provincia_id = ?, region_id = ? , fnacimiento = ? Imagen = ? WHERE ID = ?;";
        Persona p = (Persona)obj;
        try{
            Class.forName(db.getDriver());
            conn = DriverManager.getConnection(db.getUrl(), db.getUsuario(), db.getPasssword());
            pst = conn.prepareStatement(sql);
            pst.setString(1, p.getRUN());
            pst.setString(2, p.getNombre());
            pst.setString(3, p.getApellido());
            pst.setInt(4, p.getProvincia());
            pst.setInt(5, p.getRegion());
            pst.setDate(6, p.getFnacimiento());
            pst.setString(7, p.getRuta());
            pst.setInt(8, p.getID());
            int filas = pst.executeUpdate();
            //independiente de lo que se haga, Create, Update, Delete , se 
            //realiza una actualizacion de la tabla
            respuesta = "Se a Actualizado la persona con ID: " + p.getID();
            conn.close();
        } catch (ClassNotFoundException | SQLException e) {
            respuesta = "se cayo esta ve..." + e.toString();
        }
        
        return respuesta;
    }
    
}
