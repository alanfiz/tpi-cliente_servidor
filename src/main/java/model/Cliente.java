package model;

import org.hibernate.validator.constraints.Email;
import org.jetbrains.annotations.NotNull;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "Cliente")
public class Cliente extends BaseLongEntity {

        //Campos

        @Column(name="usuarioCliente", unique = true)
        @NotNull
        @Size(min = 1,max =20)
        private String usuarioCliente;

        @Column(name="passwordCliente")
        @NotNull
        @Size(min = 6,max = 20)
        private String passwordCliente;

        @Column(name = "nombreCliente")
        @NotNull
        @Size(min = 5,max = 50)
        private String nombreCliente;

        @Column (name = "apellidoCliente")
        @NotNull
        @Size (min = 5, max = 50)
        private String apellidoCliente;

        @Column (name = "telefonoCliente" )
        @NotNull
        //@Size(min = 8,max = 15)
        private Integer telefonoCliente;

        @Column (name = "emailCliente", unique = true)
        @NotNull
        @Email
        private String emailCliente;

        @Column(name = "calleCliente")
        @NotNull
        @Size(min = 5,max = 50)
        private String calleCliente;

        @Column(name = "numeroCalleCliente")
        @NotNull
        private Integer numeroCalleCliente;

        @Column(name = "infoAdicionalCliente")
        @Size(min = 3,max = 200)
        private String infoAdicionalCliente;

        @Column(name = "paisCliente")
        @NotNull
        @Size(min = 5,max = 50)
        private String paisCliente;

        @Column(name = "provinciaCliente")
        @NotNull
        @Size(min = 5,max = 50)
        private String provinciaCliente;

        @Column(name = "ciudadCliente")
        @NotNull
        @Size(min = 5,max = 50)
        private String ciudadCliente;

        @Column(name = "codpostCliente")
        @NotNull
        private Integer codpostCliente;

        @Column(name = "dniCliente", unique = true)
        @NotNull
        //@Size(min = 7, max = 9)
        private Integer dni;

        //Relaciones de tabla

        @OneToMany(fetch = FetchType.LAZY)
        @JoinColumn(name = "id_pedido")
        private List<Pedido> pedidos;

        //Metodos

        public Cliente() {
        }

        public Cliente(@NotNull String usuarioCliente, @NotNull String passwordCliente, @NotNull String nombreCliente, @NotNull String apellidoCliente, @NotNull Integer telefonoCliente, @NotNull String emailCliente, @NotNull String calleCliente, @NotNull Integer numeroCalleCliente, String infoAdicionalCliente, @NotNull String paisCliente, @NotNull String provinciaCliente, @NotNull String ciudadCliente, @NotNull Integer codpostCliente, @NotNull Integer dni) {
                this.usuarioCliente = usuarioCliente;
                this.passwordCliente = passwordCliente;
                this.nombreCliente = nombreCliente;
                this.apellidoCliente = apellidoCliente;
                this.telefonoCliente = telefonoCliente;
                this.emailCliente = emailCliente;
                this.calleCliente = calleCliente;
                this.numeroCalleCliente = numeroCalleCliente;
                this.infoAdicionalCliente = infoAdicionalCliente;
                this.paisCliente = paisCliente;
                this.provinciaCliente = provinciaCliente;
                this.ciudadCliente = ciudadCliente;
                this.codpostCliente = codpostCliente;
                this.dni = dni;
        }

        @NotNull
        public String getUsuarioCliente() {
                return usuarioCliente;
        }

        public void setUsuarioCliente(@NotNull String usuarioCliente) {
                this.usuarioCliente = usuarioCliente;
        }

        @NotNull
        public String getPasswordCliente() {
                return passwordCliente;
        }

        public void setPasswordCliente(@NotNull String passwordCliente) {
                this.passwordCliente = passwordCliente;
        }

        @NotNull
        public String getNombreCliente() {
                return nombreCliente;
        }

        public void setNombreCliente(@NotNull String nombreCliente) {
                this.nombreCliente = nombreCliente;
        }

        @NotNull
        public String getApellidoCliente() {
                return apellidoCliente;
        }

        public void setApellidoCliente(@NotNull String apellidoCliente) {
                this.apellidoCliente = apellidoCliente;
        }

        @NotNull
        public Integer getTelefonoCliente() {
                return telefonoCliente;
        }

        public void setTelefonoCliente(@NotNull Integer telefonoCliente) {
                this.telefonoCliente = telefonoCliente;
        }

        @NotNull
        public String getEmailCliente() {
                return emailCliente;
        }

        public void setEmailCliente(@NotNull String emailCliente) {
                this.emailCliente = emailCliente;
        }

        @NotNull
        public String getCalleCliente() {
                return calleCliente;
        }

        public void setCalleCliente(@NotNull String calleCliente) {
                this.calleCliente = calleCliente;
        }

        @NotNull
        public Integer getNumeroCalleCliente() {
                return numeroCalleCliente;
        }

        public void setNumeroCalleCliente(@NotNull Integer numeroCalleCliente) {
                this.numeroCalleCliente = numeroCalleCliente;
        }

        public String getInfoAdicionalCliente() {
                return infoAdicionalCliente;
        }

        public void setInfoAdicionalCliente(String infoAdicionalCliente) {
                this.infoAdicionalCliente = infoAdicionalCliente;
        }

        @NotNull
        public String getPaisCliente() {
                return paisCliente;
        }

        public void setPaisCliente(@NotNull String paisCliente) {
                this.paisCliente = paisCliente;
        }

        @NotNull
        public String getProvinciaCliente() {
                return provinciaCliente;
        }

        public void setProvinciaCliente(@NotNull String provinciaCliente) {
                this.provinciaCliente = provinciaCliente;
        }

        @NotNull
        public String getCiudadCliente() {
                return ciudadCliente;
        }

        public void setCiudadCliente(@NotNull String ciudadCliente) {
                this.ciudadCliente = ciudadCliente;
        }

        @NotNull
        public Integer getCodpostCliente() {
                return codpostCliente;
        }

        public void setCodpostCliente(@NotNull Integer codpostCliente) {
                this.codpostCliente = codpostCliente;
        }

        @NotNull
        public Integer getDni() {
                return dni;
        }

        public void setDni(@NotNull Integer dni) {
                this.dni = dni;
        }

        public List<Pedido> getPedidos() {
                return pedidos;
        }

        public void setPedidos(List<Pedido> pedidos) {
                this.pedidos = pedidos;
        }
}
