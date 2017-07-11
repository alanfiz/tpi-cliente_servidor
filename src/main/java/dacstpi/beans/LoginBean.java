package dacstpi.beans;


import dacstpi.dao.AdministradorDao;
import dacstpi.dao.ClienteDao;
import dacstpi.dao.DaoException;
import dacstpi.dao.UserRolDao;
import dacstpi.model.Administrador;
import dacstpi.model.Cliente;
import dacstpi.model.UserRol;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.util.List;


@ManagedBean(name = "loginbean")
@ViewScoped
public class LoginBean {

    private String user;
    private String pass;
    private String rol;


    @EJB
    private UserRolDao userRolDao;
    private AdministradorDao administradorDao;
    private ClienteDao clienteDao;
    private UserRol userRol;
    private Administrador administrador;
    private Cliente cliente;
    private List<UserRol> listaUser;

    public String verificarUserPass(String user , String pass) {
        try {
            Boolean result = false;
            listaUser = userRolDao.findAll();

//          Recorre la tabla UserRol
            for (int i=0; i == listaUser.size(); i++) {
                userRol = listaUser.get(i);

//              Busca si existe el nombre de usuario ingresado
                if (userRol.getUsername().equals(user)) {

//                  Si existe, consulta el tipo de rol de ese usuario
                    if (userRol.getRol().equals("administrador")) {

                        administrador = userRol.getAdministrador(); //Si el rol es administrador trae ese objeto administrador
                        result = administrador.getPasswordAdmin().equals(pass); //Consulta si la password ingresada es correcta

                        if (result.equals(true)) {return "index.html";} //Si la password es correcta, devuelve la pagina index.html

                    } else {

                        cliente = userRol.getCliente(); //Al comprobar que es el rol es cliente, trae ese objeto cliente
                        result = cliente.getPasswordCliente().equals(pass); //Consulta si la password ingresada es correcta

                        if (result.equals(true)) {return "index2.html";}else{cliente=null;} //Si la password es correcta, devuelve la pagina index2.html
                    }

                    break; //Hace un break si encuentra el usuario que se ingreso
                }

            } if (result.equals(false)) {return "loginError .html";} //Retorna la pagina de error de logueo si no encontro un usuario como el ingresado o la password no es correcta

        } catch (DaoException e) {
           e.printStackTrace();
        }

        return null;
    }


    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}

