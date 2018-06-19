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
public class DAOProvincia implements Operaciones{
    
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

    @Override
    public LinkedList<Provincia> consultar() {
       //Se reemplaza el ? por la Clase
       // y un retorno
        LinkedList<Provincia> listaProvincias = new LinkedList();
        Connection conn;
        PreparedStatement pst;
        ResultSet rs;
        String sql = "select * from provincia;";
        try {
            Class.forName(db.getDriver());
            conn = DriverManager.getConnection(db.getUrl(), db.getUsuario(), db.getPasssword());
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery(); // para ejecutar la consulta
            //recorrer la tabla persona y agregar objetos a la listaPersona
            while (rs.next())
                //mientras haya otra fila en la tabla, avanza al siguiente
                
                listaProvincias.add( new Provincia(rs.getInt("PROVINCIA_ID"),
                        rs.getString("PROVINCIA_NOMBRE"),
                        rs.getInt("PROVINCIA_REGION_ID")
                        ));

                // una vez finalizado, cerar la conexion a la DB
                conn.close();
        } catch (ClassNotFoundException | SQLException e) {
        //EXISTEN 2 exception (MULTICATCH)
        }
       return listaProvincias;
    }
    

    @Override
    public LinkedList<?> filtrar(String campo, String criterio) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


    
}
