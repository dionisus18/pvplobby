
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

    @Override
    public LinkedList<Perfil> consultar() {
        LinkedList<Perfil> listaPerfil = new LinkedList();
        Connection conn;
        PreparedStatement pst;
        ResultSet rs;
        String sql = "SELECT * FROM perfil;";
        try {
            Class.forName(db.getDriver());
            conn = DriverManager.getConnection(db.getUrl(), db.getUsuario(), db.getPasssword());
            pst = conn.prepareStatement(sql);
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
                conn.close();
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
