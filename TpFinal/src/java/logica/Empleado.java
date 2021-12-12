
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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Empleado implements Serializable {
    //atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Basic
    private String nombre;
    private String apellido;
    private String direccion;
    private String dni;
    private String nacionalidad;
    private String celular;
    private String email;
    private String cargo;
    private double sueldo;
    @Temporal(TemporalType.DATE)
    private Date fechaNac;
    @OneToOne
    private Usuario user;
    @OneToMany
    private List<Venta> listaVentas; 

    //constructores
    public Empleado() {
        this.listaVentas = new ArrayList<>();
    }

    public Empleado(int id, String nombre, String apellido, String direccion, String dni, String nacionalidad, String celular, String email, String cargo, double sueldo, Date fechaNac, Usuario user) {
        this();
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.dni = dni;
        this.nacionalidad = nacionalidad;
        this.celular = celular;
        this.email = email;
        this.cargo = cargo;
        this.sueldo = sueldo;
        this.fechaNac = fechaNac;
        this.user = user;
    }

    public Empleado(int id, String nombre, String apellido, String direccion, String dni, String nacionalidad, String celular, String email, String cargo, double sueldo, Date fechaNac, Usuario user ,List<Venta> listaVentas) {
        this(id, nombre, apellido, direccion, dni, nacionalidad, celular, email, cargo, sueldo, fechaNac, user);
        this.listaVentas = listaVentas;
    }

    
    //getters y setters
    
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

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

    public Date getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(Date fechaNac) {
        this.fechaNac = fechaNac;
    }

    public Usuario getUser() {
        return user;
    }

    public void setUser(Usuario user) {
        this.user = user;
    }

    public List<Venta> getListaVentas() {
        return listaVentas;
    }

    public void setListaVentas(List<Venta> listaVentas) {
        this.listaVentas = listaVentas;
    }
    
    //métodos
    
    
    
}
