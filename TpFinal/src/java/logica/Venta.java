
package logica;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Venta implements Serializable {
    //atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int numVenta;
    @Temporal(TemporalType.DATE)
    private Date fechaVenta;
    @Basic
    private String medioPago;
    private Cliente cliente;
    private Empleado empleado;
    private ServicioTuristico servicio;
    private PaqueteTuristico paquete;
    
    //constructores

    public Venta() {
    }

    
    public Venta(int numVenta, Date fechaVenta, String medioPago, Cliente cliente, Empleado empleado, ServicioTuristico servicio) {
        this.numVenta = numVenta;
        this.fechaVenta = fechaVenta;
        this.medioPago = medioPago;
        this.cliente = cliente;
        this.empleado = empleado;
        this.servicio = servicio;
    }

    public Venta(int numVenta, Date fechaVenta, String medioPago, Cliente cliente, Empleado empleado, PaqueteTuristico paquete) {
        this.numVenta = numVenta;
        this.fechaVenta = fechaVenta;
        this.medioPago = medioPago;
        this.cliente = cliente;
        this.empleado = empleado;
        this.paquete = paquete;
    }
    
    
    public Venta(int numVenta, Date fechaVenta, String medioPago, Cliente cliente, Empleado empleado, ServicioTuristico servicio, PaqueteTuristico paquete) {
        this.numVenta = numVenta;
        this.fechaVenta = fechaVenta;
        this.medioPago = medioPago;
        this.cliente = cliente;
        this.empleado = empleado;
        this.servicio = servicio;
        this.paquete = paquete;
    }
    
    
    
    //getters y setters
   

    public int getNumVenta() {
        return numVenta;
    }

    public void setNumVenta(int numVenta) {
        this.numVenta = numVenta;
    }

    public Date getFechaVenta() {
        return fechaVenta;
    }

    public void setFechaVenta(Date fechaVenta) {
        this.fechaVenta = fechaVenta;
    }

    public String getMedioPago() {
        return medioPago;
    }

    public void setMedioPago(String medioPago) {
        this.medioPago = medioPago;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public ServicioTuristico getServicio() {
        return servicio;
    }

    public void setServicio(ServicioTuristico servicio) {
        this.servicio = servicio;
    }

    public PaqueteTuristico getPaquete() {
        return paquete;
    }

    public void setPaquete(PaqueteTuristico paquete) {
        this.paquete = paquete;
    }
    
    //Métodos
}
