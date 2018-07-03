/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;

/**
 *
 * @author Kevin
 */
public class Evento{
    private int IdEvento;                   //PK tipo int en DB
    private LocalDate FechaComienzo;
    private LocalDate FechaFinalizacion;
    private LocalDate FechaCreacion;
    private LocalTime HoraTermino;
    private LocalTime HoraInicio;
    private int EsPrivado;                  // Tinyint 4 donde 1 es si y 0 es no
    private int IdPublicacion;      //PK tipo int en DB
    private String Titulo;          //60 char max
    private String Cuerpo;          // 200 char max
    private int IdUsuario;// FK tipo int en DB
    private String NombreUsuario;// FK tipo int en DB

    public Evento(int IdEvento, LocalDate FechaComienzo, LocalDate FechaFinalizacion, LocalDate FechaCreacion, LocalTime HoraTermino, LocalTime HoraInicio, int EsPrivado, int IdPublicacion, String Titulo, String Cuerpo, int IdUsuario, String NombreUsuario) {
        this.IdEvento = IdEvento;
        this.FechaComienzo = FechaComienzo;
        this.FechaFinalizacion = FechaFinalizacion;
        this.FechaCreacion = FechaCreacion;
        this.HoraTermino = HoraTermino;
        this.HoraInicio = HoraInicio;
        this.EsPrivado = EsPrivado;
        this.IdPublicacion = IdPublicacion;
        this.Titulo = Titulo;
        this.Cuerpo = Cuerpo;
        this.IdUsuario = IdUsuario;
        this.NombreUsuario = NombreUsuario;
    }

    public Evento(LocalDate FechaComienzo, LocalDate FechaFinalizacion, LocalDate FechaCreacion, LocalTime HoraTermino, LocalTime HoraInicio, int EsPrivado, int IdPublicacion) {
        this.FechaComienzo = FechaComienzo;
        this.FechaFinalizacion = FechaFinalizacion;
        this.FechaCreacion = FechaCreacion;
        this.HoraTermino = HoraTermino;
        this.HoraInicio = HoraInicio;
        this.EsPrivado = EsPrivado;
        this.IdPublicacion = IdPublicacion;
    }

    public Evento(int IdEvento, LocalDate FechaComienzo, LocalDate FechaFinalizacion, LocalDate FechaCreacion, LocalTime HoraTermino, int EsPrivado, int IdPublicacion) {
        this.IdEvento = IdEvento;
        this.FechaComienzo = FechaComienzo;
        this.FechaFinalizacion = FechaFinalizacion;
        this.FechaCreacion = FechaCreacion;
        this.HoraTermino = HoraTermino;
        this.EsPrivado = EsPrivado;
        this.IdPublicacion = IdPublicacion;
    }

    public Evento() {}

    public int getIdEvento() {
        return IdEvento;
    }

    public void setIdEvento(int IdEvento) {
        this.IdEvento = IdEvento;
    }

    public LocalDate getFechaComienzo() {
        return FechaComienzo;
    }

    public void setFechaComienzo(LocalDate FechaComienzo) {
        this.FechaComienzo = FechaComienzo;
    }

    public LocalDate getFechaFinalizacion() {
        return FechaFinalizacion;
    }

    public void setFechaFinalizacion(LocalDate FechaFinalizacion) {
        this.FechaFinalizacion = FechaFinalizacion;
    }

    public LocalDate getFechaCreacion() {
        return FechaCreacion;
    }

    public void setFechaCreacion(LocalDate FechaCreacion) {
        this.FechaCreacion = FechaCreacion;
    }

    public LocalTime getHoraTermino() {
        return HoraTermino;
    }

    public void setHoraTermino(LocalTime HoraTermino) {
        this.HoraTermino = HoraTermino;
    }

    public LocalTime getHoraInicio() {
        return HoraInicio;
    }

    public void setHoraInicio(LocalTime HoraInicio) {
        this.HoraInicio = HoraInicio;
    }

    public int getEsPrivado() {
        return EsPrivado;
    }

    public void setEsPrivado(int EsPrivado) {
        this.EsPrivado = EsPrivado;
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

    public int getIdUsuario() {
        return IdUsuario;
    }

    public void setIdUsuario(int IdUsuario) {
        this.IdUsuario = IdUsuario;
    }

    public String getNombreUsuario() {
        return NombreUsuario;
    }

    public void setNombreUsuario(String NombreUsuario) {
        this.NombreUsuario = NombreUsuario;
    }

    
    


    
    
    
    
    
}
