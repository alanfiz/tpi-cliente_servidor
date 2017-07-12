package dacstpi.model;

import javax.validation.constraints.NotNull;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "Pedido")
public class Pedido extends BaseLongEntity {

    //Campos

    @Column(name = "fechayhoraPedido")
    @Temporal(TemporalType.TIMESTAMP)
//    ^\d{2}-\d{2}-\d{4}
//    @Pattern(regexp="^(?:(?:31(\\/|-|\\.)(?:0?[13578]|1[02]))\\1|(?:(?:29|30)(\\/|-|\\.)(?:0?[1,3-9]|1[0-2])\\2))(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$|^(?:29(\\/|-|\\.)0?2\\3(?:(?:(?:1[6-9]|[2-9]\\d)?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00))))$|^(?:0?[1-9]|1\\d|2[0-8])(\\/|-|\\.)(?:(?:0?[1-9])|(?:1[0-2]))\\4(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$",
//            message="{invalid.Date}")
    private Date fechayhoraPedido;

    @Column(name = "estadoPedido")
    @Size(min = 5,max = 50)
    private String estadoPedido;

    //Relaciones de tabla

    @JoinColumn(name = "id_cliente")
    @ManyToOne
    private Cliente cliente;

    @ManyToOne()
    @JoinColumn(name = "id_formapago")
    private FormaPago formaPago;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "pedido")
    private Set<PedProd> productos;

    @OneToOne
    @JoinColumn(name = "id_venta")
    private Venta venta;

    //Metodos

    public Pedido() {
    }

    public Pedido(@NotNull Date fechayhoraPedido, @NotNull String estadoPedido, Cliente cliente, FormaPago formaPago, Venta venta) {
        this.fechayhoraPedido = fechayhoraPedido;
        this.estadoPedido = estadoPedido;
        this.cliente = cliente;
        this.formaPago = formaPago;
        this.venta = venta;
    }

    public Pedido(@NotNull Date fechayhoraPedido, @NotNull String estadoPedido) {
        this.fechayhoraPedido = fechayhoraPedido;
        this.estadoPedido = estadoPedido;
    }

    //@NotNull
    public Date getFechayhoraPedido() {
        return fechayhoraPedido;
    }

    public void setFechayhoraPedido(@NotNull Date fechayhoraPedido) {
        this.fechayhoraPedido = fechayhoraPedido;
    }

    //@NotNull
    public String getEstadoPedido() {
        return estadoPedido;
    }

    public void setEstadoPedido(@NotNull String estadoPedido) {
        this.estadoPedido = estadoPedido;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente( Cliente cliente) {
        this.cliente = cliente;
    }

    public FormaPago getFormaPago() {
        return formaPago;
    }

    public void setFormaPago(FormaPago formaPago) {
        this.formaPago = formaPago;
    }

    public Set<PedProd> getProductos() {
        return productos;
    }

    public void setProductos(Set<PedProd> productos) {
        this.productos = productos;
    }

    public Venta getVenta() {
        return venta;
    }

    public void setVenta(Venta venta) {
        this.venta = venta;
    }
}
