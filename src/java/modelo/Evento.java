/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.Date;
import java.sql.Time;



/**
 *
 * @author Kevin
 */
public class Evento extends Publicacion{
    private int IdEvento;                   //PK tipo int en DB
    private Date FechaComienzo;
    private Date FechaFinalizacion;
    private Date FechaCreacion;
    private Time HoraTermino;
    private Time HoraInicio;
    private int EsPrivado;                  // Tinyint 4 donde 1 es si y 0 es no
    private int Publicacion_IdPublicacion;  // FK tipo int en DB
    
    /*METODO PRINCIPAL, EVENTO HEREDA DE PUBLICACION*/
    public Evento(int IdEvento, Date FechaComienzo, Date FechaFinalizacion, Date FechaCreacion, Time HoraTermino, Time HoraInicio, int EsPrivado, int Publicacion_IdPublicacion, int IdPublicacion, String Titulo, String Cuerpo, int Usuario_IdUsuario) {
        super(IdPublicacion, Titulo, Cuerpo, Usuario_IdUsuario);
        this.IdEvento = IdEvento;
        this.FechaComienzo = FechaComienzo;
        this.FechaFinalizacion = FechaFinalizacion;
        this.FechaCreacion = FechaCreacion;
        this.HoraTermino = HoraTermino;
        this.HoraInicio = HoraInicio;
        this.EsPrivado = EsPrivado;
        this.Publicacion_IdPublicacion = Publicacion_IdPublicacion;
    }

    @Override
    public int getIdPublicacion() {
        return IdPublicacion;
    }

    @Override
    public void setIdPublicacion(int IdPublicacion) {
        this.IdPublicacion = IdPublicacion;
    }

    @Override
    public String getTitulo() {
        return Titulo;
    }

    @Override
    public void setTitulo(String Titulo) {
        this.Titulo = Titulo;
    }

    @Override
    public String getCuerpo() {
        return Cuerpo;
    }

    @Override
    public void setCuerpo(String Cuerpo) {
        this.Cuerpo = Cuerpo;
    }

    @Override
    public int getUsuario_IdUsuario() {
        return Usuario_IdUsuario;
    }

    @Override
    public void setUsuario_IdUsuario(int Usuario_IdUsuario) {
        this.Usuario_IdUsuario = Usuario_IdUsuario;
    }
    
      
    public void EventoUnico(int IdEvento, Date FechaComienzo, Date FechaFinalizacion, Date FechaCreacion, Time HoraTermino, Time HoraInicio, int EsPrivado, int Publicacion_IdPublicacion) {
        this.IdEvento = IdEvento;
        this.FechaComienzo = FechaComienzo;
        this.FechaFinalizacion = FechaFinalizacion;
        this.FechaCreacion = FechaCreacion;
        this.HoraTermino = HoraTermino;
        this.HoraInicio = HoraInicio;
        this.EsPrivado = EsPrivado;
        this.Publicacion_IdPublicacion = Publicacion_IdPublicacion;
    }
    
    public Evento(){};

    public int getIdEvento() {
        return IdEvento;
    }

    public void setIdEvento(int IdEvento) {
        this.IdEvento = IdEvento;
    }

    public Date getFechaComienzo() {
        return FechaComienzo;
    }

    public void setFechaComienzo(Date FechaComienzo) {
        this.FechaComienzo = FechaComienzo;
    }

    public Date getFechaFinalizacion() {
        return FechaFinalizacion;
    }

    public void setFechaFinalizacion(Date FechaFinalizacion) {
        this.FechaFinalizacion = FechaFinalizacion;
    }

    public Date getFechaCreacion() {
        return FechaCreacion;
    }

    public void setFechaCreacion(Date FechaCreacion) {
        this.FechaCreacion = FechaCreacion;
    }

    public Time getHoraTermino() {
        return HoraTermino;
    }

    public void setHoraTermino(Time HoraTermino) {
        this.HoraTermino = HoraTermino;
    }

    public Time getHoraInicio() {
        return HoraInicio;
    }

    public void setHoraInicio(Time HoraInicio) {
        this.HoraInicio = HoraInicio;
    }

    public int getEsPrivado() {
        return EsPrivado;
    }

    public void setEsPrivado(int EsPrivado) {
        this.EsPrivado = EsPrivado;
    }

    public int getPublicacion_IdPublicacion() {
        return Publicacion_IdPublicacion;
    }

    public void setPublicacion_IdPublicacion(int Publicacion_IdPublicacion) {
        this.Publicacion_IdPublicacion = Publicacion_IdPublicacion;
    }
    
    

 
    
    
    
    
}
