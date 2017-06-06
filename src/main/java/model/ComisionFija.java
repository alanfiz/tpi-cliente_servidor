package model;

import org.jetbrains.annotations.NotNull;

import javax.persistence.*;

@Entity
@Table(name = "ComisionFija")
public class ComisionFija extends BaseLongEntity {

    //Campos

    @Column(name="valorfijo")
    @NotNull
    private Double valorfijo;

    //Relaciones de tabla

    @OneToOne
    @JoinColumn(name = "id_comision")
    private Comision comision;

    //Metodos

    public ComisionFija() {
    }

    public ComisionFija(@NotNull Double valorfijo, Comision comision) {
        this.valorfijo = valorfijo;
        this.comision = comision;
    }

    public ComisionFija(@NotNull Double valorfijo) {
        this.valorfijo = valorfijo;
    }

    //@NotNull
    public Double getValorfijo() {
        return valorfijo;
    }

    public void setValorfijo(@NotNull Double valorfijo) {
        this.valorfijo = valorfijo;
    }
}
