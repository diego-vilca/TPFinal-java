
package logica;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class ServicioTuristico implements Serializable {
    
    //atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codigo;
    @Basic
    private String nombre;
    private String descripcion;
    private String destino;
    private double costo;
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @ManyToMany
    private List<PaqueteTuristico> listaPaquetes;
    @OneToMany
    private List<Venta> listaVentas;
    
    //constructores

    public ServicioTuristico() {
        this.listaPaquetes = new ArrayList<>();
        this.listaVentas = new ArrayList<>();
    }

    public ServicioTuristico(int codigo, String nombre, String descripcion, String destino, double costo, Date fecha) {
        this();
        this.codigo = codigo;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.destino = destino;
        this.costo = costo;
        this.fecha = fecha;
    }

    public ServicioTuristico(int codigo, String nombre, String descripcion, String destino, double costo, Date fecha, List<PaqueteTuristico> listaPaquetes, List<Venta> listaVentas) {
        this(codigo, nombre, descripcion, destino, costo, fecha);
        this.listaPaquetes = listaPaquetes;
        this.listaVentas = listaVentas;
    }

    //getters y setters

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public List<PaqueteTuristico> getListaPaquetes() {
        return listaPaquetes;
    }

    public void setListaPaquetes(List<PaqueteTuristico> listaPaquetes) {
        this.listaPaquetes = listaPaquetes;
    }

    public List<Venta> getListaVentas() {
        return listaVentas;
    }

    public void setListaVentas(List<Venta> listaVentas) {
        this.listaVentas = listaVentas;
    }
    
    //metodos
    
    public void agregarPaquete(PaqueteTuristico paquete){
        this.listaPaquetes.add(paquete);
    }
    
    public void agregarVenta(Venta venta){
        this.listaVentas.add(venta);
    }
}
