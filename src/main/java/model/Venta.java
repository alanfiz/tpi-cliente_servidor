package model;


import javax.persistence.*;

@Entity
@Table(name = "Venta")
public class Venta extends BaseLongEntity
{

    //Campos

    @Column(name = "precioUnitarioVenta", precision = 2)
    private Double precioUnitarioVenta;

    @Column(name = "precioFinalVenta", precision = 2)
    private Double precioFinalVenta;

    @Column(name = "costoEnvioVenta", precision = 2)
    private Double costoEnvioVenta;

    @Column(name = "impuestoVenta", precision = 2)
    private Double impuestoVenta;

    //Relaciones de tabla

    @OneToOne
    @JoinColumn(name = "id_pedido")
    private Pedido pedido;

    //Metodos

    public Venta() {
    }

    public Venta(Double precioUnitarioVenta, Double precioFinalVenta, Double costoEnvioVenta, Double impuestoVenta, Pedido pedido) {
        this.precioUnitarioVenta = precioUnitarioVenta;
        this.precioFinalVenta = precioFinalVenta;
        this.costoEnvioVenta = costoEnvioVenta;
        this.impuestoVenta = impuestoVenta;
        this.pedido = pedido;
    }

    public Venta(Double precioUnitarioVenta, Double precioFinalVenta, Double costoEnvioVenta, Double impuestoVenta) {
        this.precioUnitarioVenta = precioUnitarioVenta;
        this.precioFinalVenta = precioFinalVenta;
        this.costoEnvioVenta = costoEnvioVenta;
        this.impuestoVenta = impuestoVenta;
    }

    public Double getPrecioUnitarioVenta() {
        return precioUnitarioVenta;
    }

    public void setPrecioUnitarioVenta(Double precioUnitarioVenta) {
        this.precioUnitarioVenta = precioUnitarioVenta;
    }

    public Double getPrecioFinalVenta() {
        return precioFinalVenta;
    }

    public void setPrecioFinalVenta(Double precioFinalVenta) {
        this.precioFinalVenta = precioFinalVenta;
    }

    public Double getCostoEnvioVenta() {
        return costoEnvioVenta;
    }

    public void setCostoEnvioVenta(Double costoEnvioVenta) {
        this.costoEnvioVenta = costoEnvioVenta;
    }

    public Double getImpuestoVenta() {
        return impuestoVenta;
    }

    public void setImpuestoVenta(Double impuestoVenta) {
        this.impuestoVenta = impuestoVenta;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }
}

