package dacstpi.model;

import javax.persistence.*;
import javax.validation.constraints.Pattern;

@Entity
@Table(name = "Tarjeta")
public class Tarjeta extends BaseLongEntity
{

    //Campos

    @Column(name = "proveedorTarjeta")
    private String proveedorTarjeta;

    @Column(name = "codigoTarjeta", unique = true)
    private Long codigoTarjeta;

    @Column(name = "fechaVencimiento")
    @Pattern(regexp="^\\d{2}-\\d{2}-\\d{4}$",
            message="{invalid.Date}")
    //@Temporal(TemporalType.TIMESTAMP)
    private String fechaVencimientoTarjeta;

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

    public Tarjeta(String proveedorTarjeta, Long codigoTarjeta, String fechaVencimientoTarjeta, String nombreTitularTarjeta, Integer codigoValidezTarjeta, Integer cuotasTarjeta, FormaPago formaPago) {
        this.proveedorTarjeta = proveedorTarjeta;
        this.codigoTarjeta = codigoTarjeta;
        this.fechaVencimientoTarjeta = fechaVencimientoTarjeta;
        this.nombreTitularTarjeta = nombreTitularTarjeta;
        this.codigoValidezTarjeta = codigoValidezTarjeta;
        this.cuotasTarjeta = cuotasTarjeta;
        this.formaPago = formaPago;
    }

    public Tarjeta(String proveedorTarjeta, Long codigoTarjeta, String fechaVencimientoTarjeta, String nombreTitularTarjeta, Integer codigoValidezTarjeta, Integer cuotasTarjeta) {
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

    public Long getCodigoTarjeta() {
        return codigoTarjeta;
    }

    public void setCodigoTarjeta(Long codigoTarjeta) {
        this.codigoTarjeta = codigoTarjeta;
    }

    public String getFechaVencimientoTarjeta() {
        return fechaVencimientoTarjeta;
    }

    public void setFechaVencimientoTarjeta(String fechaVencimientoTarjeta) {
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
