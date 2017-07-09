package dacstpi.model;

import javax.validation.constraints.NotNull;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "Comision", schema = "")
public class Comision extends BaseLongEntity {

    //Campos

    @Column(name = "nombreComision", unique = true)
    @NotNull
    @Size(min = 5, max = 50)
    private String nombreComision;

    //Relaciones de tabla

    @OneToMany(mappedBy = "comision")
//    @JoinColumn(name = "id_producto")
    private Set<ProdCom> productos;

    @OneToMany(mappedBy = "comision")
    private Set<ProvCom> proveedores;

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

    public Set<ProdCom> getProductos() {
        return productos;
    }

    public void setProductos(Set<ProdCom> productos) {
        this.productos = productos;
    }

    public Set<ProvCom> getProveedores() {
        return proveedores;
    }

    public void setProveedores(Set<ProvCom> proveedores) {
        this.proveedores = proveedores;
    }

    public ComisionFija getComisionFija() {
        return comisionFija;
    }

    public void setComisionFija(ComisionFija comisionFija) {
        this.comisionFija = comisionFija;
    }

    public ComisionPorcentual getComisionPorcentual() {
        return comisionPorcentual;
    }

    public void setComisionPorcentual(ComisionPorcentual comisionPorcentual) {
        this.comisionPorcentual = comisionPorcentual;
    }
}
