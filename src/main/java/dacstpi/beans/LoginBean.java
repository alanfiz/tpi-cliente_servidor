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

//    public String verificarRol(String user) {
//        try {
//            userRol = userRolDao.findByUser(user);
//            rol = userRol.getRol();
//            return rol;
//        } catch (DaoException e) {
//           e.printStackTrace();
//        }
//        return null;
//    }

//    public String verificarPass(String user, String pass, String rol) {
//        try {
//            if (rol == "Administrador"){
//                administrador = administradorDao.findByUser(user);
//                if (administrador.getPasswordAdmin().equals(pass)) {return "index.html";} else {return "#";}
//            }
//            else { cliente = clienteDao.findByUser(user);
//                if (cliente.getPasswordCliente().equals(pass)) {return "index2.html";} else {return "#";}
//            }
//
//        } catch (DaoException e) {
//            e.printStackTrace();
//        }
//        return null;
//    }





}

