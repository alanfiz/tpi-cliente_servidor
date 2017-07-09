package dacstpi.model;

import javax.persistence.*;

@Entity
@Table(name = "ProdCom")
public class ProdCom extends BaseLongEntity {

    //Relaciones de tabla

    @ManyToOne()
    @JoinColumn(name = "id_producto")
    private Producto producto;

    @ManyToOne()
    @JoinColumn(name = "id_comision")
    private Comision comision;

    //Metodos

    public ProdCom() {
    }

    public ProdCom(Producto producto, Comision comision) {
        this.producto = producto;
        this.comision = comision;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Comision getComision() {
        return comision;
    }

    public void setComision(Comision comision) {
        this.comision = comision;
    }
}
