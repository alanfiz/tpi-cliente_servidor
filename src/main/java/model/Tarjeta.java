package model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Tarjeta")
public class Tarjeta extends BaseLongEntity
{

    //Campos

    @Column(name = "proveedorTarjeta")
    private String proveedorTarjeta;

    @Column(name = "codigoTarjeta", unique = true)
    private Integer codigoTarjeta;

    @Column(name = "fechaVencimiento")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaVencimientoTarjeta;

    @Column(name = "nombreTitularTarjeta")
    private String nombreTitularTarjeta;

    @Column(name = "codigoValidezTarjeta", length = 3)
    private Integer codigoValidezTarjeta;

    @Column(name = "cuotasTarjeta")
    private Integer cuotasTarjeta;

    //Relaciones de tabla

    @OneToOne
    @JoinColumn(name = "id_formaPago")
    private FormaPago formaPago;

    //Metodos

    public Tarjeta() {
    }

    public Tarjeta(String proveedorTarjeta, Integer codigoTarjeta, Date fechaVencimientoTarjeta, String nombreTitularTarjeta, Integer codigoValidezTarjeta, Integer cuotasTarjeta, FormaPago formaPago) {
        this.proveedorTarjeta = proveedorTarjeta;
        this.codigoTarjeta = codigoTarjeta;
        this.fechaVencimientoTarjeta = fechaVencimientoTarjeta;
        this.nombreTitularTarjeta = nombreTitularTarjeta;
        this.codigoValidezTarjeta = codigoValidezTarjeta;
        this.cuotasTarjeta = cuotasTarjeta;
        this.formaPago = formaPago;
    }

    public Tarjeta(String proveedorTarjeta, Integer codigoTarjeta, Date fechaVencimientoTarjeta, String nombreTitularTarjeta, Integer codigoValidezTarjeta, Integer cuotasTarjeta) {
        this.proveedorTarjeta = proveedorTarjeta;
        this.codigoTarjeta = codigoTarjeta;
        this.fechaVencimientoTarjeta = fechaVencimientoTarjeta;
        this.nombreTitularTarjeta = nombreTitularTarjeta;
        this.codigoValidezTarjeta = codigoValidezTarjeta;
        this.cuotasTarjeta = cuotasTarjeta;
    }

    public String getProveedorTarjeta() {
        return proveedorTarjeta;
    }

    public void setProveedorTarjeta(String proveedorTarjeta) {
        this.proveedorTarjeta = proveedorTarjeta;
    }

    public Integer getCodigoTarjeta() {
        return codigoTarjeta;
    }

    public void setCodigoTarjeta(Integer codigoTarjeta) {
        this.codigoTarjeta = codigoTarjeta;
    }

    public Date getFechaVencimientoTarjeta() {
        return fechaVencimientoTarjeta;
    }

    public void setFechaVencimientoTarjeta(Date fechaVencimientoTarjeta) {
        this.fechaVencimientoTarjeta = fechaVencimientoTarjeta;
    }

    public String getNombreTitularTarjeta() {
        return nombreTitularTarjeta;
    }

    public void setNombreTitularTarjeta(String nombreTitularTarjeta) {
        this.nombreTitularTarjeta = nombreTitularTarjeta;
    }

    public Integer getCodigoValidezTarjeta() {
        return codigoValidezTarjeta;
    }

    public void setCodigoValidezTarjeta(Integer codigoValidezTarjeta) {
        this.codigoValidezTarjeta = codigoValidezTarjeta;
    }

    public Integer getCuotasTarjeta() {
        return cuotasTarjeta;
    }

    public void setCuotasTarjeta(Integer cuotasTarjeta) {
        this.cuotasTarjeta = cuotasTarjeta;
    }
}
