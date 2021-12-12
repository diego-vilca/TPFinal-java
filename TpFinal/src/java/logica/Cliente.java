
package logica;

import java.util.Date;
import java.util.List;
import javax.persistence.OneToMany;


public class Cliente {
    
    private int id;
    private String nombre;
    private String apellido;
    private String direccion;
    private String dni;
    private Date fechaNac;
    private String nacionalidad;
    private String celular;
    private String email;
    @OneToMany
    private List<Venta> listaVenta;
}
