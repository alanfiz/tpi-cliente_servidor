package model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "FormaPago")
public class FormaPago extends BaseLongEntity
{

    //Campos

    @Column(name = "nombreFormaPago")
    private String nombreFormaPago;

    //Relaciones de tabla

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_pedido")
    private List<Pedido> pedidos;

    @OneToOne
    @JoinColumn(name = "id_tarjeta")
    private Tarjeta tarjeta;

    //Metodos

    public FormaPago() {
    }

    public FormaPago(String nombreFormaPago, Tarjeta tarjeta) {
        this.nombreFormaPago = nombreFormaPago;
        this.tarjeta = tarjeta;
    }

    public FormaPago(String nombreFormaPago) {
        this.nombreFormaPago = nombreFormaPago;
    }

    public String getNombreFormaPago() {
        return nombreFormaPago;
    }

    public void setNombreFormaPago(String nombreFormaPago) {
        this.nombreFormaPago = nombreFormaPago;
    }

    public List<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(List<Pedido> pedidos) {
        this.pedidos = pedidos;
    }

    public Tarjeta getTarjeta() {
        return tarjeta;
    }

    public void setTarjeta(Tarjeta tarjeta) {
        this.tarjeta = tarjeta;
    }
}
