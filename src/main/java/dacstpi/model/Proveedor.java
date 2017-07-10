package dacstpi.model;

import javax.validation.constraints.NotNull;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "Proveedor")
public class Proveedor extends BaseLongEntity
{

    //Campos

    @Column(name = "nombreProveedor", unique = true)
    @NotNull
    private String nombre;

    //Relaciones de tabla

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "proveedor")
    private Set<ProvCom> comision;

    @OneToMany()
    @JoinColumn(name = "id_producto")
    private List<Producto> productos;

    //Metodos

    public Proveedor() {
    }

    public Proveedor(@NotNull String nombre) {
        this.nombre = nombre;
    }

//    @NotNull
    public String getNombre() {
        return nombre;
    }

    public void setNombre(@NotNull String nombre) {
        this.nombre = nombre;
    }

    public Set<ProvCom> getComision() {
        return comision;
    }

    public void setComision(Set<ProvCom> comision) {
        this.comision = comision;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }
}
