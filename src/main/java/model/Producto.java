package model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Producto")
public class Producto extends BaseLongEntity
{

    //Campos

    @Column(name = "nombreProducto")
    private String nombreProducto;

    @Column(name = "marcaProducto")
    private String marcaProducto;

    @Column(name = "origenProducto")
    private String origenProducto;

    @Column(name = "precioUnitarioProducto")
    private Double precioUnitarioProducto;

    //Relaciones de tabla

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_pedido")
    private List<Pedido> pedidos;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_comision")
    private List<Comision> comision;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_proveedor")
    private Proveedor proveedor;

    //Metodos

    public Producto() {
    }

    public Producto(String nombreProducto, String marcaProducto, String origenProducto, Double precioUnitarioProducto, Proveedor proveedor) {
        this.nombreProducto = nombreProducto;
        this.marcaProducto = marcaProducto;
        this.origenProducto = origenProducto;
        this.precioUnitarioProducto = precioUnitarioProducto;
        this.proveedor = proveedor;
    }

    public Producto(String nombreProducto, String marcaProducto, String origenProducto, Double precioUnitarioProducto) {
        this.nombreProducto = nombreProducto;
        this.marcaProducto = marcaProducto;
        this.origenProducto = origenProducto;
        this.precioUnitarioProducto = precioUnitarioProducto;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public String getMarcaProducto() {
        return marcaProducto;
    }

    public void setMarcaProducto(String marcaProducto) {
        this.marcaProducto = marcaProducto;
    }

    public String getOrigenProducto() {
        return origenProducto;
    }

    public void setOrigenProducto(String origenProducto) {
        this.origenProducto = origenProducto;
    }

    public Double getPrecioUnitarioProducto() {
        return precioUnitarioProducto;
    }

    public void setPrecioUnitarioProducto(Double precioUnitarioProducto) {
        this.precioUnitarioProducto = precioUnitarioProducto;
    }

    public List<Pedido> getPedido() {
        return pedidos;
    }

    public void setPedido(List<Pedido> pedido) {
        this.pedidos = pedido;
    }

    public List<Comision> getComision() {
        return comision;
    }

    public void setComision(List<Comision> comision) {
        this.comision = comision;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }
}
