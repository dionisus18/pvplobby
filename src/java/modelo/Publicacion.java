package modelo;

/**
 *
 * @author Kevin
 */
public class Publicacion {
    protected int IdPublicacion;      //PK tipo int en DB
    protected String Titulo;          //60 char max
    protected String Cuerpo;          // 200 char max
    protected int Usuario_IdUsuario;  //FK tipo int en DB
    protected String NombreUsuario;  //FK tipo int en DB

    public Publicacion(int IdPublicacion, String Titulo, String Cuerpo, int Usuario_IdUsuario) {
        this.IdPublicacion = IdPublicacion;
        this.Titulo = Titulo;
        this.Cuerpo = Cuerpo;
        this.Usuario_IdUsuario = Usuario_IdUsuario;
    }

    public Publicacion(int IdPublicacion, String Titulo, String Cuerpo, int Usuario_IdUsuario, String NombreUsuario) {
        this.IdPublicacion = IdPublicacion;
        this.Titulo = Titulo;
        this.Cuerpo = Cuerpo;
        this.Usuario_IdUsuario = Usuario_IdUsuario;
        this.NombreUsuario = NombreUsuario;
    }
    public Publicacion(){}
    

    public String getNombreUsuario() {
        return NombreUsuario;
    }

    public void setNombreUsuario(String NombreUsuario) {
        this.NombreUsuario = NombreUsuario;
    }

    public int getIdPublicacion() {
        return IdPublicacion;
    }

    public void setIdPublicacion(int IdPublicacion) {
        this.IdPublicacion = IdPublicacion;
    }

    public String getTitulo() {
        return Titulo;
    }

    public void setTitulo(String Titulo) {
        this.Titulo = Titulo;
    }

    public String getCuerpo() {
        return Cuerpo;
    }

    public void setCuerpo(String Cuerpo) {
        this.Cuerpo = Cuerpo;
    }

    public int getUsuario_IdUsuario() {
        return Usuario_IdUsuario;
    }

    public void setUsuario_IdUsuario(int Usuario_IdUsuario) {
        this.Usuario_IdUsuario = Usuario_IdUsuario;
    }


    
    



   
}
