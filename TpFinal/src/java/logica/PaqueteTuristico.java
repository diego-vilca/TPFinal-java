
package logica;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class PaqueteTuristico implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codigoPaquete;
    @Basic
    private double costo;
    @ManyToMany
    private List<ServicioTuristico> listaServicios;
    @OneToMany
    private List<Venta> listaVentas;
    
    //constructores

    public PaqueteTuristico() {
        this.listaServicios = new ArrayList<>();
        this.listaVentas = new ArrayList<>();
    }

    public PaqueteTuristico(int codigoPaquete, double costo) {
        this();
        this.codigoPaquete = codigoPaquete;
        this.costo = costo;
    }

    public PaqueteTuristico(int codigoPaquete, double costo, List<ServicioTuristico> listaServicios) {
        this(codigoPaquete, costo);
        this.listaServicios = listaServicios;
    }

    public PaqueteTuristico(int codigoPaquete, double costo, List<ServicioTuristico> listaServicios, List<Venta> listaVentas) {
        this(codigoPaquete, costo, listaServicios);
        this.listaVentas = listaVentas;
    }
    
    
    //getters y setters

    public int getCodigoPaquete() {
        return codigoPaquete;
    }

    public void setCodigoPaquete(int codigoPaquete) {
        this.codigoPaquete = codigoPaquete;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public List<ServicioTuristico> getListaServicios() {
        return listaServicios;
    }

    public void setListaServicios(List<ServicioTuristico> listaServicios) {
        this.listaServicios = listaServicios;
    }

    public List<Venta> getListaVentas() {
        return listaVentas;
    }

    public void setListaVentas(List<Venta> listaVentas) {
        this.listaVentas = listaVentas;
    }
    
    
    //Metodos
    
    //Agregar servicio a la lista
    public void agregarServicio(ServicioTuristico servicio){
        this.listaServicios.add(servicio);
    }
    
    
    
    
    
    
    
}
