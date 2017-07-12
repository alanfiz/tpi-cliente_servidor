package dacstpi.beans;


import dacstpi.dao.AdministradorDao;
import dacstpi.dao.ClienteDao;
import dacstpi.dao.DaoException;
import dacstpi.dao.UserRolDao;
import dacstpi.model.Administrador;
import dacstpi.model.Cliente;
import dacstpi.model.UserRol;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.ws.rs.QueryParam;
import java.util.List;


@ManagedBean(name = "loginbean")
@ViewScoped
public class LoginBean {

    private String user;
    private String pass;
    private String rol;
    private Long id;
    private Boolean logueado;

    @EJB
    private UserRolDao userRolDao;
    private AdministradorDao administradorDao;
    private ClienteDao clienteDao;
    private UserRol userRol;
    private Administrador administrador;
    private Cliente cliente;
    private List<UserRol> listaUser;
    private Boolean result;
    private String pagina;

    @PostConstruct
    public void init(){
        pagina = new String();
        result = false;
    }

    public String verificarUserPass() {
        try {
            listaUser = userRolDao.findAll();

//          Recorre la tabla UserRol
        for (int i=0; i < listaUser.size(); i++) {
            userRol = listaUser.get(i);

//              Busca si existe el nombre de usuario ingresado
            if (userRol.getUsername().equals(user)) {

//                  Si existe, consulta el tipo de rol de ese usuario
                if (userRol.getRol().equals("administrador")) {

                    administrador = userRol.getAdministrador(); //Si el rol es administrador trae ese objeto administrador
                    result = administrador.getPasswordAdmin().equals(pass); //Consulta si la password ingresada es correcta

                    if (result) {pagina = "/index.xhtml?faces-redirect=true";} //Si la password es correcta, devuelve la pagina index.xhtml

                } else {

                    cliente = userRol.getCliente(); //Al comprobar que es el rol es cliente, trae ese objeto cliente
                    result = (cliente.getPasswordCliente().equals(pass)); //Consulta si la password ingresada es correcta

                    if (result) {logueado = true; pagina = "/index2.xhtml?faces-redirect=true";} //Si la password es correcta, devuelve la pagina index2.xhtml
                }

                break; //Hace un break si encuentra el usuario que se ingreso
            }

        } if (!result) {pagina = "/loginError.xhtml?faces-redirect=true";} //Retorna la pagina de error de logueo si no encontro un usuario como el ingresado o la password no es correcta
        } catch (DaoException e) {
            e.printStackTrace();
        }
        return pagina;
    }


    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public UserRolDao getUserRolDao() {
        return userRolDao;
    }

    public void setUserRolDao(UserRolDao userRolDao) {
        this.userRolDao = userRolDao;
    }

    public AdministradorDao getAdministradorDao() {
        return administradorDao;
    }

    public void setAdministradorDao(AdministradorDao administradorDao) {
        this.administradorDao = administradorDao;
    }

    public ClienteDao getClienteDao() {
        return clienteDao;
    }

    public void setClienteDao(ClienteDao clienteDao) {
        this.clienteDao = clienteDao;
    }

    public UserRol getUserRol() {
        return userRol;
    }

    public void setUserRol(UserRol userRol) {
        this.userRol = userRol;
    }

    public Administrador getAdministrador() {
        return administrador;
    }

    public void setAdministrador(Administrador administrador) {
        this.administrador = administrador;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<UserRol> getListaUser() {
        return listaUser;
    }

    public void setListaUser(List<UserRol> listaUser) {
        this.listaUser = listaUser;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getLogueado() {
        return logueado;
    }

    public void setLogueado(Boolean logueado) {
        this.logueado = logueado;
    }
}

