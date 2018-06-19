
package modelo;


public class Database {
    //tendra la informacion de la base de datos para conectarse
    private String driver;
    private String url;
    private String usuario;
    private String passsword;

    public Database() {
        this.driver = "com.mysql.cj.jdbc.Driver";
        this.url = "jdbc:mysql://localhost:3306/pvplobby?useSSL=false&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC"; //192.168.0.19
        this.usuario = "root";
        this.passsword = "23881969";
    }
    
    public void CambiarConexion(String url){
        this.url = url;
    }

    public String getDriver() {
        return driver;
    }

    public String getUrl() {
        return url;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getPasssword() {
        return passsword;
    }
   
}
