package dacstpi.model;

import org.hibernate.validator.constraints.Email;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.List;

@Entity
@Table(name = "PedProd")
public class PedProd extends BaseLongEntity {

    //Relaciones de tabla

    @ManyToOne()
    @JoinColumn(name = "id_pedido")
    private Pedido pedido;

    @ManyToOne()
    @JoinColumn(name = "id_producto")
    private Producto producto;

    //Metodos

    public PedProd() {
    }

    public PedProd(Pedido pedido, Producto producto) {
        this.pedido = pedido;
        this.producto = producto;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }
}
