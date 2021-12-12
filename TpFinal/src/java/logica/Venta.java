
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
    
    //constructores

    public Venta() {
    }

    public Venta(int numVenta, Date fechaVenta, String medioPago) {
        this.numVenta = numVenta;
        this.fechaVenta = fechaVenta;
        this.medioPago = medioPago;
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
    
    
    
}
