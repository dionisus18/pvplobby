
package modelo;

import java.util.Date;

public class Perfil {
    private int IdPerfil;//AI UN
    private String Nombre; //Not Null 50
    private String Biografia;//255
    private Date FechaNacimiento;
    private int EsPublico; //tinyint 2
    private String IdPersonal;//run
    private int Usuario_IdUsuario;//FK UN

    
    
    public Perfil(int IdPerfil, String Nombre, String Biografia, Date FechaNacimiento, int EsPublico, String IdPersonal, int Usuario_IdUsuario) {
        this.IdPerfil = IdPerfil;
        this.Nombre = Nombre;
        this.Biografia = Biografia;
        this.FechaNacimiento = FechaNacimiento;
        this.EsPublico = EsPublico;
        this.IdPersonal = IdPersonal;
        this.Usuario_IdUsuario = Usuario_IdUsuario;
    }
    
    public Perfil(){
    }

    public int getIdPerfil() {
        return IdPerfil;
    }

    public void setIdPerfil(int IdPerfil) {
        this.IdPerfil = IdPerfil;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getBiografia() {
        return Biografia;
    }

    public void setBiografia(String Biografia) {
        this.Biografia = Biografia;
    }

    public Date getFechaNacimiento() {
        return FechaNacimiento;
    }

    public void setFechaNacimiento(Date FechaNacimiento) {
        this.FechaNacimiento = FechaNacimiento;
    }

    public int getEsPublico() {
        return EsPublico;
    }

    public void setEsPublico(int EsPublico) {
        this.EsPublico = EsPublico;
    }

    public String getIdPersonal() {
        return IdPersonal;
    }

    public void setIdPersonal(String IdPersonal) {
        this.IdPersonal = IdPersonal;
    }

    public int getUsuario_IdUsuario() {
        return Usuario_IdUsuario;
    }

    public void setUsuario_IdUsuario(int Usuario_IdUsuario) {
        this.Usuario_IdUsuario = Usuario_IdUsuario;
    }
    
    
}
