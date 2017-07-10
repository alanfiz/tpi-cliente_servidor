package dacstpi.model;

import javax.persistence.*;

@Entity
@Table(name = "ProvCom")
public class ProvCom extends BaseLongEntity {

    //Relaciones de tabla

    @ManyToOne()
    @JoinColumn(name = "id_proveedor")
    private Proveedor proveedor;

    @ManyToOne()
    @JoinColumn(name = "id_comision")
    private Comision comision;

    //Metodos

    public ProvCom() {
    }

    public ProvCom(Proveedor proveedor, Comision comision) {
        this.proveedor = proveedor;
        this.comision = comision;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    public Comision getComision() {
        return comision;
    }

    public void setComision(Comision comision) {
        this.comision = comision;
    }
}
