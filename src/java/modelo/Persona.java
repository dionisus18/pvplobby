package modelo;

import java.sql.Date;
import java.util.LinkedList;

public class Persona {

    private int ID;
    private String RUN;
    private String nombre;
    private String apellido;
    private int provincia;
    private int region;
    private java.sql.Date fnacimiento;
    private String ruta;
    private String imagen;

    DAOProvincia dao = new DAOProvincia();
    DAORegion dao2 = new DAORegion();
    LinkedList<Provincia> listaProvincias = new LinkedList();
    LinkedList<Region> listaRegiones = new LinkedList();

    public Persona(int ID, String RUN, String nombre, String apellido, int provincia, int region, Date fnacimiento, String imagen) {
        this.ID = ID;
        this.RUN = RUN;
        this.nombre = nombre;
        this.apellido = apellido;
        this.provincia = provincia;
        this.region = region;
        this.fnacimiento = fnacimiento;
        this.imagen = imagen;
    }

    public String calcularProvincia(int provincia_id) {
        listaProvincias = dao.consultar();
        String respuesta = "";
        for (Provincia listaProvincia : listaProvincias) {
            if (provincia_id == listaProvincia.getId()) {
                respuesta = listaProvincia.getNombre();
            }
        }
        return respuesta;
    }
    public int calcularProvincia(String provincia_nombre) {
        listaProvincias = dao.consultar();
        int respuesta = 0;
        for (Provincia listaProvincia : listaProvincias) {
            if (provincia_nombre.equals(listaProvincia.getNombre())) {
                respuesta = listaProvincia.getId();
            }
        }
        return respuesta;
    }

    public String calcularRegion(int region_id) {
        listaRegiones = dao2.consultar();
        String respuesta = "";
        for (Region listaRegion : listaRegiones) {
            if (region_id == listaRegion.getId()) {
                respuesta = listaRegion.getNombre();
            }
        }
        return respuesta;
    }

    public int calcularRegion(String region_nombre) {
        listaRegiones = dao2.consultar();
        int respuesta = 0;
        for (Region listaRegion : listaRegiones) {
            if (region_nombre.equals(listaRegion.getNombre())) {
                respuesta = listaRegion.getId();
            }
        }
        return respuesta;
    }

    public Persona() {
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getRUN() {
        return RUN;
    }

    public void setRUN(String RUN) {
        this.RUN = RUN;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getProvincia() {
        return provincia;
    }

    public void setProvincia(int provincia) {
        this.provincia = provincia;
    }

    public int getRegion() {
        return region;
    }

    public void setRegion(int region) {
        this.region = region;
    }

    public java.sql.Date getFnacimiento() {
        return fnacimiento;
    }

    public void setFnacimiento(java.sql.Date fnacimiento) {
        this.fnacimiento = fnacimiento;
    }

    public String getRuta() {
        return ruta;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

}
