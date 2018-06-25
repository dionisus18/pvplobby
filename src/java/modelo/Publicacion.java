package modelo;

/**
 *
 * @author Kevin
 */
public class Publicacion {
    private int IdPublicacion;      //PK tipo int en DB
    private String Titulo;          //60 char max
    private String Cuerpo;          // 200 char max
    private int Usuario_IdUsuario;  //FK tipo int en DB

    public Publicacion(int IdPublicacion, String Titulo, String Cuerpo, int Usuario_IdUsuario) {
        this.IdPublicacion = IdPublicacion;
        this.Titulo = Titulo;
        this.Cuerpo = Cuerpo;
        this.Usuario_IdUsuario = Usuario_IdUsuario;
    }
    
    public Publicacion(){}

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
