package model;

import javax.validation.constraints.NotNull;

import javax.persistence.*;

@Entity
@Table(name = "ComisionPorcentual")
public class ComisionPorcentual extends BaseLongEntity {

    //Campos

    @Column(name = "valorPorcentual")
    @NotNull
    private Double valorPorcentual;

    //Relaciones de tabla

    @OneToOne
    @JoinColumn(name = "id_comision")
    private Comision comision;

    //Metodos

    public ComisionPorcentual() {
    }

    public ComisionPorcentual(@NotNull Double valorPorcentual, Comision comision) {
        this.valorPorcentual = valorPorcentual;
        this.comision = comision;
    }

    public ComisionPorcentual(@NotNull Double valorPorcentual) {
        this.valorPorcentual = valorPorcentual;
    }

    //@NotNull
    public Double getValorPorcentual() {
        return valorPorcentual;
    }

    public void setValorPorcentual(@NotNull Double valorPorcentual) {
        this.valorPorcentual = valorPorcentual;
    }
}
