/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Kevin
 */
public class Provincia {
    private int id;
    private String nombre;
    private int region_id;

    public Provincia(int id, String nombre, int region_id) {
        this.id = id;
        this.nombre = nombre;
        this.region_id = region_id;
    }

    public Provincia() {
    }
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getRegion_id() {
        return region_id;
    }

    public void setRegion_id(int region_id) {
        this.region_id = region_id;
    }
    
    
}
