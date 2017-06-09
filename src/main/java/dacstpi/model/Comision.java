package dacstpi.model;

import javax.validation.constraints.NotNull;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "Comision", schema = "")
public class Comision extends BaseLongEntity {

    //Campos

    @Column(name = "nombreComision", unique = true)
    @NotNull
    @Size(min = 5, max = 50)
    private String nombreComision;

    //Relaciones de tabla

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_producto")
    private List<Producto> productos;

    @ManyToMany
    @JoinColumn(name = "id_proveedor")
    private List<Proveedor> proveedores;

    @OneToOne
    @JoinColumn(name = "id_comisionFija")
    private ComisionFija comisionFija;

    @OneToOne
    @JoinColumn(name = "id_comisionPorcentual")
    private ComisionPorcentual comisionPorcentual;

    //Metodos

    public Comision() {
    }

    public Comision(@NotNull String nombreComision, ComisionFija comisionFija, ComisionPorcentual comisionPorcentual) {
        this.nombreComision = nombreComision;
        this.comisionFija = comisionFija;
        this.comisionPorcentual = comisionPorcentual;
    }

    public Comision(@NotNull String nombreComision) {
        this.nombreComision = nombreComision;
    }

    //@NotNull
    public String getNombreComision() {
        return nombreComision;
    }

    public void setNombreComision(@NotNull String nombreComision) {
        this.nombreComision = nombreComision;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }

    public List<Proveedor> getProveedores() {
        return proveedores;
    }

    public void setProveedores(List<Proveedor> proveedores) {
        this.proveedores = proveedores;
    }
}
