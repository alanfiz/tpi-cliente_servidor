package dacstpi.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;


@Entity
@Table(name = "UserRol")
public class UserRol extends BaseLongEntity {

//Campos

    @Column(name="username", unique = true)
    @NotNull
    @Size(min = 3,max =20)
    private String username;

    @Column(name="rol", unique = true)
    @NotNull
    @Size(min = 3,max =20)
    private String rol;

    //Relaciones de tabla

    @OneToOne()
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;

    @OneToOne()
    @JoinColumn(name = "id_administrador")
    private Administrador administrador;

    //Metodos


    public UserRol() {
    }

    public UserRol(String username, String rol, Cliente cliente, Administrador administrador) {
        this.username = username;
        this.rol = rol;
        this.cliente = cliente;
        this.administrador = administrador;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Administrador getAdministrador() {
        return administrador;
    }

    public void setAdministrador(Administrador administrador) {
        this.administrador = administrador;
    }
}