package model;

import javax.validation.constraints.NotNull;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Proveedor")
public class Proveedor extends BaseLongEntity
{

    //Campos

    @Column(name = "nombreProveedor", unique = true)
    @NotNull
    private String nombre;

    //Relaciones de tabla

    @ManyToMany
    @JoinColumn(name = "id_comision")
    private List<Comision> comision;

    @OneToMany(fetch = FetchType.LAZY)
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

    public List<Comision> getComision() {
        return comision;
    }

    public void setComision(List<Comision> comision) {
        this.comision = comision;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }
}
