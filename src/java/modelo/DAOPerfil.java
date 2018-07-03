
package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;


public class DAOPerfil implements Operaciones{
    
    Database db = new Database();

    @Override
    public String insertar(Object obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
    public Perfil seleccionarPerfil(int id){
        Perfil perfil = new Perfil();
        Connection conn;
        PreparedStatement pst;
        ResultSet rs;
        String sql = "select * from perfil where Usuario_IdUsuario ="+ id +";";
        try {
            Class.forName(db.getDriver());
            conn = DriverManager.getConnection(db.getUrl(), db.getUsuario(), db.getPasssword());
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery(); // para ejecutar la consulta
            //recorrer la tabla persona y agregar objetos a la listaPersona
           if(rs.next()){
                perfil.setIdPerfil(rs.getInt("IdPerfil"));
                perfil.setNombre(rs.getString("Nombre"));
                perfil.setBiografia(rs.getString("Biografia"));
                perfil.setFechaNacimiento(rs.getDate("FechaNacimiento"));
                perfil.setEsPublico(rs.getInt("EsPublico"));
                perfil.setIdPersonal(rs.getString("IdPersonal"));
                perfil.setUsuario_IdUsuario(rs.getInt("Usuario_IdUsuario"));
           }
                //mientras haya otra fila en la tabla, avanza al siguiente
                

                // una vez finalizado, cerar la conexion a la DB
                conn.close();
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e.toString());
        }
       return perfil; //To change body of generated methods, choose Tools | Templates. //To change body of generated methods, choose Tools | Templates.
    }
        public Perfil selecionarPerfil(int id){
        Perfil perfil = new Perfil();
        Connection conn;
        PreparedStatement pst;
        ResultSet rs;
        String sql = "select * from perfil where Usuario_IdUsuario ="+ id +";";
        try {
            Class.forName(db.getDriver());
            conn = DriverManager.getConnection(db.getUrl(), db.getUsuario(), db.getPasssword());
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery(); // para ejecutar la consulta
            //recorrer la tabla persona y agregar objetos a la listaPersona
           if(rs.next()){
                perfil.setIdPerfil(rs.getInt("IdPerfil"));
                perfil.setNombre(rs.getString("Nombre"));
                perfil.setBiografia(rs.getString("Biografia"));
                perfil.setFechaNacimiento(rs.getDate("FechaNacimiento"));
                perfil.setEsPublico(rs.getInt("EsPublico"));
                perfil.setIdPersonal(rs.getString("IdPersonal"));
                perfil.setUsuario_IdUsuario(rs.getInt("Usuario_IdUsuario"));
           }
                //mientras haya otra fila en la tabla, avanza al siguiente
                

                // una vez finalizado, cerar la conexion a la DB
                conn.close();
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e.toString());
        }
       return perfil; //To change body of generated methods, choose Tools | Templates. //To change body of generated methods, choose Tools | Templates.
    
    }

        public void ActualizarBiografia(Object obj){
        Connection conn;
        PreparedStatement pst = null;
        ResultSet rs;
        String sql = "UPDATE perfil SET Biografia = ? WHERE perfil.IdPerfil = ?;";
        Perfil miPerfil = (Perfil)obj;
        try{
            Class.forName(db.getDriver());
            conn = DriverManager.getConnection(db.getUrl(), db.getUsuario(), db.getPasssword());
            pst = conn.prepareStatement(sql);
            pst.setString(1, miPerfil.getBiografia());
            pst.setInt(2, miPerfil.getIdPerfil());
            int filas = pst.executeUpdate();
            //independiente de lo que se haga, Create, Update, Delete , se 
            //realiza una actualizacion de la tabla
            
            conn.close();
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e);
        }
        
        }
    
    
    
    public Publicacion vistaEventos(int id){        
        Publicacion evento = new Publicacion();
        Connection conn;
        PreparedStatement pst;
        ResultSet rs;
        String sql = "select * from publicacion where IdPublicacion ="+ id +";";
        int count=0;
        
        try {
            Class.forName(db.getDriver());
            conn = DriverManager.getConnection(db.getUrl(), db.getUsuario(), db.getPasssword());
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery(); // para ejecutar la consulta
            //recorrer la tabla persona y agregar objetos a la listaPersona
           if(rs.next()){
                evento.setIdPublicacion(rs.getInt("IdPublicacion"));
                evento.setTitulo(rs.getString("titulo"));
                evento.setCuerpo(rs.getString("cuerpo"));
                evento.setUsuario_IdUsuario(rs.getInt("Usuario_IdUsuario"));
                
           }
                //mientras haya otra fila en la tabla, avanza al siguiente
                

                // una vez finalizado, cerar la conexion a la DB
                conn.close();
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e.toString());
        }
      
     return evento;
     
    
    }
    
    public LinkedList<Publicacion> consultaEvento(int id){
        LinkedList<Publicacion> listaEvento = new LinkedList();
        Connection conn;
        PreparedStatement pst;
        ResultSet rs;
        String sql = "SELECT * FROM publicacion where IdPublicacion ="+ id +";";
        try {
            Class.forName(db.getDriver());
            conn = DriverManager.getConnection(db.getUrl(), db.getUsuario(), db.getPasssword());
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery(); // para ejecutar la consulta
            //recorrer la tabla persona y agregar objetos a la listaPersona
            while (rs.next())
                //mientras haya otra fila en la tabla, avanza al siguiente
                
                listaEvento.add( new Publicacion(rs.getInt("IdPublicacion"),
                        rs.getString("Titulo"),
                        rs.getString("Cuerpo"),                        
                        rs.getInt("Usuario_IdUsuario")                       
                        ));
                // una vez finalizado, cerar la conexion a la DB
                conn.close();
        } catch (ClassNotFoundException | SQLException e) {
        //EXISTEN 2 exception (MULTICATCH)
        }
       return listaEvento; //To change body of generated methods, choose Tools | Templates. //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public LinkedList<Perfil> consultar() {
        LinkedList<Perfil> listaPerfil = new LinkedList();
        Connection conexion;
        PreparedStatement pst;
        ResultSet rs;
        String sql = "SELECT * FROM perfil;";
        try {
            Class.forName(db.getDriver());
            conexion = DriverManager.getConnection(db.getUrl(), db.getUsuario(), db.getPasssword());
            pst = conexion.prepareStatement(sql);
            rs = pst.executeQuery(); // para ejecutar la consulta
            //recorrer la tabla persona y agregar objetos a la listaPersona
            while (rs.next())
                //mientras haya otra fila en la tabla, avanza al siguiente
                
                listaPerfil.add( new Perfil(rs.getInt("IdPerfil"),
                        rs.getString("Nombre"),
                        rs.getString("Biografia"),
                        rs.getDate("FechaNacimiento"), 
                        rs.getInt("EsPublico"), 
                        rs.getString("IdPersonal"), 
                        rs.getInt("Usuario_IdUsuario") 
                        ));
                // una vez finalizado, cerar la conexion a la DB
                conexion.close();
        } catch (ClassNotFoundException | SQLException e) {
        //EXISTEN 2 exception (MULTICATCH)
        }
       return listaPerfil; //To change body of generated methods, choose Tools | Templates. //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public LinkedList<?> filtrar(String campo, String criterio) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
