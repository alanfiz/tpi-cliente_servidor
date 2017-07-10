package dacstpi.model;

import org.hibernate.validator.constraints.Email;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Table(name = "Administrador")
public class Administrador extends BaseLongEntity {

    //Campos

    @Column(name = "usuarioAdmin", unique = true)
    @NotNull
    @Size(min = 3, max = 20)
    private String usuarioAdmin;

    @Column(name = "passwordAdmin")
    @NotNull
    @Size(min = 6, max = 20)
    private String passwordAdmin;

    @Column(name = "nombreAdmin")
    @NotNull
    @Size(min = 3, max = 50)
    private String nombreAdmin;

    @Column(name = "apellidoAdmin")
    @NotNull
    @Size(min = 3, max = 50)
    private String apellidoAdmin;


    @Column(name = "emailAdmin", unique = true)
    @NotNull
    @Email
    private String emailAdmin;


    @Column(name = "paisAdmin")
    @NotNull
    @Size(min = 5, max = 50)
    private String paisAdmin;

    @Column(name = "provinciaAdmin")
    @NotNull
    @Size(min = 5, max = 50)
    private String provinciaAdmin;

    @Column(name = "ciudadAdmin")
    @NotNull
    @Size(min = 5, max = 50)
    private String ciudadAdmin;

    @Column(name = "codpostAdmin")
    @NotNull
    private Integer codpostAdmin;

    @Column(name = "dniAdmin", unique = true)
    @NotNull
    @Min(value = 1000000)
    @Max(value = 99999999)
    private Integer dniAdmin;

//Relaciones de tabla

    @OneToOne()
    @JoinColumn(name = "id_userRol")
    private UserRol userRol;

//Metodos


    public Administrador() {
    }

    public Administrador(String usuarioAdmin, String passwordAdmin, String nombreAdmin, String apellidoAdmin, String emailAdmin, String paisAdmin, String provinciaAdmin, String ciudadAdmin, Integer codpostAdmin, Integer dniAdmin, UserRol userRol) {
        this.usuarioAdmin = usuarioAdmin;
        this.passwordAdmin = passwordAdmin;
        this.nombreAdmin = nombreAdmin;
        this.apellidoAdmin = apellidoAdmin;
        this.emailAdmin = emailAdmin;
        this.paisAdmin = paisAdmin;
        this.provinciaAdmin = provinciaAdmin;
        this.ciudadAdmin = ciudadAdmin;
        this.codpostAdmin = codpostAdmin;
        this.dniAdmin = dniAdmin;
        this.userRol = userRol;
    }

    public String getUsuarioAdmin() {
        return usuarioAdmin;
    }

    public void setUsuarioAdmin(String usuarioAdmin) {
        this.usuarioAdmin = usuarioAdmin;
    }

    public String getPasswordAdmin() {
        return passwordAdmin;
    }

    public void setPasswordAdmin(String passwordAdmin) {
        this.passwordAdmin = passwordAdmin;
    }

    public String getNombreAdmin() {
        return nombreAdmin;
    }

    public void setNombreAdmin(String nombreAdmin) {
        this.nombreAdmin = nombreAdmin;
    }

    public String getApellidoAdmin() {
        return apellidoAdmin;
    }

    public void setApellidoAdmin(String apellidoAdmin) {
        this.apellidoAdmin = apellidoAdmin;
    }

    public String getEmailAdmin() {
        return emailAdmin;
    }

    public void setEmailAdmin(String emailAdmin) {
        this.emailAdmin = emailAdmin;
    }

    public String getPaisAdmin() {
        return paisAdmin;
    }

    public void setPaisAdmin(String paisAdmin) {
        this.paisAdmin = paisAdmin;
    }

    public String getProvinciaAdmin() {
        return provinciaAdmin;
    }

    public void setProvinciaAdmin(String provinciaAdmin) {
        this.provinciaAdmin = provinciaAdmin;
    }

    public String getCiudadAdmin() {
        return ciudadAdmin;
    }

    public void setCiudadAdmin(String ciudadAdmin) {
        this.ciudadAdmin = ciudadAdmin;
    }

    public Integer getCodpostAdmin() {
        return codpostAdmin;
    }

    public void setCodpostAdmin(Integer codpostAdmin) {
        this.codpostAdmin = codpostAdmin;
    }

    public Integer getDniAdmin() {
        return dniAdmin;
    }

    public void setDniAdmin(Integer dniAdmin) {
        this.dniAdmin = dniAdmin;
    }

    public UserRol getUserRol() {
        return userRol;
    }

    public void setUserRol(UserRol userRol) {
        this.userRol = userRol;
    }
}